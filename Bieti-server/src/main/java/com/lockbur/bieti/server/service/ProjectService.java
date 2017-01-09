package com.lockbur.bieti.server.service;

import com.lockbur.bieti.server.domain.Project;

import java.util.List;

/**
 * Created by wangkun23 on 2017/1/9.
 */
public interface ProjectService {

    /***
     * @param project
     * @return
     */
    public int insert(Project project);

    public Project findById(Integer id);

    public List<Project> findAll();
}
