package com.lockbur.bieti.server.mapper;

import com.lockbur.bieti.server.domain.Project;

import java.util.List;

/**
 * Created by wangkun23 on 2017/1/6.
 */
public interface ProjectMapper {

    /***
     * @param project
     * @return
     */
    public int insert(Project project);


    public List<Project> findAll();

    public Project findById(Integer id);
}
