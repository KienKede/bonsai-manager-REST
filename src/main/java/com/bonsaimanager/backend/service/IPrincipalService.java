package com.bonsaimanager.backend.service;

import com.bonsaimanager.backend.domain.User;
import com.bonsaimanager.common.persistence.service.IService;

public interface IPrincipalService extends IService<User> {

    User getCurrentPrincipal();

}
