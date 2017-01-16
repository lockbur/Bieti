package com.lockbur.bieti.server.mapper;

import com.lockbur.bieti.server.domain.App;

import java.util.List;

/**
 * Created by wangkun23 on 2017/1/11.
 */
public interface AppMapper {

    public int insert(App application);

    public List<App> findAll();

    public App findById(Integer id);

    public void update(App app);
}
