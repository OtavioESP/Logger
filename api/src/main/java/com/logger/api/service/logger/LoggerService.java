package com.logger.api.service.logger;

import com.logger.api.domain.logger.LoggerMessageDTO;
import com.logger.api.producer.LoggerProducer;
import com.logger.api.repositories.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {

    @Autowired
    private LoggerFactory loggerFactory;

    @Autowired
    private LoggerRepository loggerRepository;

    @Autowired
    private LoggerProducer loggerProducer;

    public void createLogInstance(LoggerMessageDTO loggerMessage) {
        loggerProducer.sendNewLogMessage(loggerMessage);
    }

}
