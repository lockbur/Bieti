package com.lockbur.bieti.server.service.impl;

import com.lockbur.bieti.server.domain.Instance;
import com.lockbur.bieti.server.mapper.InstanceMapper;
import com.lockbur.bieti.server.service.InstanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 服务器实例管理
 * Created by wangkun23 on 2017/1/9.
 */
@Service
public class InstanceServiceImpl implements InstanceService {

    @Resource
    private InstanceMapper instanceMapper;

    @Override
    public int insert(Instance instance) {
        return instanceMapper.insert(instance);
    }

    @Override
    public List<Instance> findByAppServerId(Integer appServerId) {
        return instanceMapper.findByAppServerId(appServerId);
    }
}
