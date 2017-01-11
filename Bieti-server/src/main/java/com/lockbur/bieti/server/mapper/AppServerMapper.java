package com.lockbur.bieti.server.mapper;

import com.lockbur.bieti.server.domain.AppServer;

import java.util.List;

/**
 * 服务器管理
 * Created by wangkun23 on 2017/1/11.
 */
public interface AppServerMapper {

    public int insert(AppServer appServer);

    public List<AppServer> findAll();
}
