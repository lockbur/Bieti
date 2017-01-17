package com.lockbur.bieti.server.service;

/**
 * Created by wangkun23 on 2017/1/9.
 */
public interface CommandService {

    public void deploy(Integer projectId) throws Exception;

    public void start(Integer id) throws Exception;

    public void restart(Integer id) throws Exception;

    public void stop(Integer id) throws Exception;

    public void unDeploy(Integer id) throws Exception;


}
