package com.lockbur.bieti.server.service.impl;

import com.lockbur.bieti.server.domain.AppServer;
import com.lockbur.bieti.server.domain.Application;
import com.lockbur.bieti.server.mapper.AppServerMapper;
import com.lockbur.bieti.server.mapper.ApplicationMapper;
import com.lockbur.bieti.server.service.ApplicationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangkun23 on 2017/1/11.
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Resource
    private ApplicationMapper applicationMapper;

    @Override
    public List<Application> findAll() {
        return applicationMapper.findAll();
    }

    @Override
    public Application findById(Integer id) {
        return applicationMapper.findById(id);
    }

    @Transactional
    @Override
    public void update(Application app){
        applicationMapper.update(app);
    }
}
