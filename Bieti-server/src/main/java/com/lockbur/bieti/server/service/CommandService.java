package com.lockbur.bieti.server.service;

/**
 * Created by wangkun23 on 2017/1/9.
 */
public interface CommandService {

    public void deploy(Integer projectId) throws Exception;

    public void start();

    public void restart();

    public void stop();

    public void unDeploy();


}
