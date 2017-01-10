/**
 * Copyright 2013 Jaroslaw Palka<jaroslaw.palka@symentis.pl>
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lockbur.bieti.agent.spring;

import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.stack.IpAddress;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.util.Assert;

public class JGroupsChannelFactoryBean extends AbstractFactoryBean<JChannel> {

    private String clusterName;

    @Override
    public JChannel createInstance() throws Exception {

        Assert.hasText(clusterName, "JGroups cluster name is null or empty");

        Address address = new IpAddress("127.0.0.1", 7800);

        JChannel channel = new JChannel("tcp-nio.xml");
        channel.connect(clusterName);

        return channel;

    }

    @Override
    public Class<?> getObjectType() {
        return JChannel.class;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    @Override
    protected void destroyInstance(JChannel instance) throws Exception {
        instance.disconnect();
    }

}