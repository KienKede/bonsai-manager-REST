package com.bonsaimanager.common.persistence.service;

import com.bonsaimanager.common.interfaces.IByNameApi;
import com.bonsaimanager.common.persistence.model.INameableEntity;

public interface IService<T extends INameableEntity> extends IRawService<T>, IByNameApi<T> {

    //

}