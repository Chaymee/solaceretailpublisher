package com.solace.samples.solaceretailpublisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.solacesystems.jcsmp.JCSMPException;
import com.solacesystems.jcsmp.JCSMPStreamingPublishEventHandler;

public class DemoPublishEventHandler implements JCSMPStreamingPublishEventHandler {
    private static final Logger logger = LoggerFactory.getLogger(DemoPublishEventHandler.class);

    public void responseReceived(String messageID) {
        logger.info("Producer received response for msg: " + messageID);
    }

    public void handleError(String messageID, JCSMPException e, long timestamp) {
        logger.info("Producer received error for msg: %s@%s - %s%n", messageID, timestamp, e);
    }
}
