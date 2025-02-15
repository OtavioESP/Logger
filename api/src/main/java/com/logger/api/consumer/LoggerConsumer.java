package com.logger.api.consumer;

import com.logger.api.domain.logger.Logger;
import com.logger.api.domain.logger.LoggerMessageDTO;
import com.logger.api.repositories.LoggerRepository;
import com.logger.api.service.logger.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerConsumer {

    @Autowired
    private LoggerFactory loggerFactory;

    @Autowired
    private LoggerRepository loggerRepository;

    // trocar o logQueue para a variavel de ambiente queueName
    @RabbitListener(queues = "logQueue")
    public void receiveMessage(LoggerMessageDTO loggerMessage) {
        System.out.println("OLAAAAAA");
        final Logger newLog = loggerFactory.createLogger(
                loggerMessage.errorType(),
                loggerMessage.traceback(),
                loggerMessage.function(),
                loggerMessage.line(),
                loggerMessage.filename(),
                loggerMessage.token()
        );
        loggerRepository.save(newLog);
    }
}
