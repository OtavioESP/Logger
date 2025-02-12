package com.logger.api.service.logger;

import com.logger.api.domain.logger.Logger;

import java.util.UUID;


public class LoggerFactory implements ILoggerFactory {

    private String fetchOriginSystem(String token) {
        return "teste";
    }

    @Override
    public Logger createLogger(
            String errorType,
            String traceback,
            String function,
            Integer line,
            String filename,
            String token
    ) {
        String originSystem = this.fetchOriginSystem(token);
        Logger newLogger = new Logger(UUID.randomUUID(), originSystem, errorType, traceback, function, line, filename);
        return newLogger;
    }
}
