package com.lockbur.bieti.server.service;

import com.lockbur.bieti.server.domain.Instance;

import java.util.List;

/**
 * 应用实例管理
 * Created by wangkun23 on 2017/1/9.
 */
public interface InstanceService {

    public int insert(Instance instance);

    public List<Instance> findByAppServerId(Integer appServerId);
}
