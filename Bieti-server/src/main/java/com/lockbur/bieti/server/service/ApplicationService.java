package com.lockbur.bieti.server.service;

import com.lockbur.bieti.server.domain.Application;
import com.lockbur.bieti.server.domain.Project;

import java.util.List;

/**
 * Created by wangkun23 on 2017/1/11.
 */
public interface ApplicationService {

    public List<Application> findAll();

    public Application findById(Integer id);

    public void update(Application app);

}
