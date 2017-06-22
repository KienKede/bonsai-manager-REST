package com.bonsaimanager.common.frontend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.bonsaimanager.common.persistence.model.IEntity;

public interface ISortingController<T extends IEntity> {

    public List<T> findAllPaginatedAndSorted(final int page, final int size, final String sortBy, final String sortOrder);

    public List<T> findAllPaginated(final int page, final int size);

    public List<T> findAllSorted(final String sortBy, final String sortOrder);

    public List<T> findAll(final HttpServletRequest request);

}
