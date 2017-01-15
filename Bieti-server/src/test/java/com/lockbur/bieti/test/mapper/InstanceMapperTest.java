package com.lockbur.bieti.test.mapper;

import com.lockbur.bieti.server.domain.Instance;
import com.lockbur.bieti.server.mapper.InstanceMapper;
import com.lockbur.bieti.test.TestBase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wangkun23 on 2017/1/15.
 */
public class InstanceMapperTest extends TestBase {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private InstanceMapper instanceMapper;

    //@Test
    public void insert() {
        Instance instance = new Instance();
        instance.setAppServerId(1);
        instance.setAddress("127.0.0.1");
        instance.setHostname("localhost");
        instance.setPath("/export/App/server2");

        instanceMapper.insert(instance);
    }

    //@Test
    public void findByAppServerId() {
        List<Instance> list = instanceMapper.findByAppServerId(1);

        logger.info("size {}", list.size());
    }

}
