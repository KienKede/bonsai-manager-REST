package com.bonsaimanager.common.persistence.service;

import org.springframework.data.domain.Page;

import com.bonsaimanager.common.interfaces.IOperations;
import com.bonsaimanager.common.persistence.model.IEntity;

public interface IRawService<T extends IEntity> extends IOperations<T> {

    Page<T> findAllPaginatedAndSortedRaw(final int page, final int size, final String sortBy, final String sortOrder);
    Page<T> findAllPaginatedRaw(final int page, final int size);

}