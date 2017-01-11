package com.lockbur.bieti.server.mapper;

import com.lockbur.bieti.server.domain.DeployJob;
import java.util.List;

/**
 * Created by wangkun23 on 2017/1/6.
 */
public interface DeployJobMapper {

    public int insert(DeployJob deployJob);


    public List<DeployJob> findAll();

}
