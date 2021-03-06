package com.lockbur.bieti.server.service.impl;

import com.lockbur.bieti.server.domain.DeployJob;
import com.lockbur.bieti.server.mapper.DeployJobMapper;
import com.lockbur.bieti.server.service.DeployJobService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangkun23 on 2017/1/11.
 */
@Service
public class DeployJobServiceImpl implements DeployJobService {
    @Resource
    private DeployJobMapper deployJobMapper;

    @Override
    public List<DeployJob> findAll() {
        return deployJobMapper.findAll();
    }

    @Transactional
    @Override
    public void save(DeployJob deployJob) {
        deployJobMapper.insert(deployJob);
    }
}
