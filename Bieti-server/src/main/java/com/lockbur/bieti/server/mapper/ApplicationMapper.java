package com.lockbur.bieti.server.mapper;

import com.lockbur.bieti.server.domain.Application;

import java.util.List;

/**
 * Created by wangkun23 on 2017/1/11.
 */
public interface ApplicationMapper {

    public int insert(Application application);

    public List<Application> findAll();

    public Application findById(Integer id);

    public void update(Application app);
}
