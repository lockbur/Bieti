package com.lockbur.bieti.server.service.impl;

import com.lockbur.bieti.server.domain.AppServer;
import com.lockbur.bieti.server.mapper.AppServerMapper;
import com.lockbur.bieti.server.service.AppServerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangkun23 on 2017/1/11.
 */
@Service
public class AppServerServiceImpl implements AppServerService {
    @Resource
    private AppServerMapper appServerMapper;

    @Override
    public List<AppServer> findAll() {
        return appServerMapper.findAll();
    }
}
