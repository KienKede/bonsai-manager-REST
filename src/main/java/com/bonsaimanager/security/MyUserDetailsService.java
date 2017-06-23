package com.bonsaimanager.security;

import java.security.Principal;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.bonsaimanager.backend.domain.Privilege;
import com.bonsaimanager.backend.domain.Role;
import com.bonsaimanager.backend.domain.RolePrivilege;
import com.bonsaimanager.backend.domain.User;
import com.bonsaimanager.backend.domain.UserRole;
import com.bonsaimanager.backend.service.IPrincipalService;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;

/**
 * Database user authentication service.
 */
@Component
public final class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private IPrincipalService principalService;

    public MyUserDetailsService() {
        super();
    }

    // API - public

    /**
     * Loads the user from the datastore, by it's user name <br>
     */
    @Override
    public final UserDetails loadUserByUsername(final String username) {
        Preconditions.checkNotNull(username);

        final User user = principalService.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Username was not found: " + username);
        }

        final Set<UserRole> userRoles = user.getUserRoles();
        Set<Role> roles = Sets.newHashSet();
        for(UserRole userRole : userRoles){
        	roles.add(userRole.getRole());
        }
        
        Set<RolePrivilege> rolePrivileges = Sets.newHashSet();
        for(Role role : roles){
        	Iterator<RolePrivilege> rolePrivilegesFromOneRole = role.getRolePrivileges().iterator();
        	
        	while(rolePrivilegesFromOneRole.hasNext()){
        		rolePrivileges.add((RolePrivilege) rolePrivilegesFromOneRole.next());
        	}
        }
        	
        final Set<Privilege> privileges = Sets.newHashSet();
        for (RolePrivilege rolePrivilege : rolePrivileges) {
            privileges.add(rolePrivilege.getPrivilege());
        }
        final Function<Object, String> toStringFunction = Functions.toStringFunction();
        final Collection<String> rolesToString = Collections2.transform(privileges, toStringFunction);
        final String[] roleStringsAsArray = rolesToString.toArray(new String[rolesToString.size()]);
        final List<GrantedAuthority> auths = AuthorityUtils.createAuthorityList(roleStringsAsArray);

        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), auths);
    }

}
