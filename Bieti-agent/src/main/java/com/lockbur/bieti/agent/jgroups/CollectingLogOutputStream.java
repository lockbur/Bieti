package com.lockbur.bieti.agent.jgroups;

import org.apache.commons.exec.LogOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangkun23 on 2017/1/6.
 */
public class CollectingLogOutputStream extends LogOutputStream {

    private static final Logger logger = LoggerFactory.getLogger(CollectingLogOutputStream.class);

    private final List<String> lines = new LinkedList<String>();

    @Override
    protected void processLine(String line, int level) {

        logger.info("line{}", line);
        lines.add(line);
    }

    public List<String> getLines() {
        return lines;
    }
}
