package com.lockbur.bieti.server.service;

import com.lockbur.bieti.server.domain.Application;
import com.lockbur.bieti.server.domain.DeployJob;

import java.util.List;

/**
 * Created by wangkun23 on 2017/1/11.
 */
public interface DeployJobService {

    public List<DeployJob> findAll();

}
