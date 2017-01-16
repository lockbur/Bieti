package com.lockbur.bieti.server.service.impl;

import com.lockbur.bieti.server.domain.App;
import com.lockbur.bieti.server.mapper.AppMapper;
import com.lockbur.bieti.server.service.AppService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangkun23 on 2017/1/11.
 */
@Service
public class AppServiceImpl implements AppService {
    @Resource
    private AppMapper appMapper;

    @Override
    public List<App> findAll() {
        return appMapper.findAll();
    }

    @Override
    public App findById(Integer id) {
        return appMapper.findById(id);
    }

    @Transactional
    @Override
    public void update(App app){
        appMapper.update(app);
    }
}
