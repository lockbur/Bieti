package com.lockbur.bieti.server.service.impl;

import com.lockbur.bieti.server.domain.Project;
import com.lockbur.bieti.server.mapper.ProjectMapper;
import com.lockbur.bieti.server.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangkun23 on 2017/1/9.
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;


    @Override
    public int insert(Project project) {
        return projectMapper.insert(project);
    }

    @Override
    public List<Project> findAll() {
        return projectMapper.findAll();
    }
}
