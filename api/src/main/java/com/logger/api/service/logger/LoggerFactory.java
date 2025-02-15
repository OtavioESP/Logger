package com.logger.api.service.logger;

import com.logger.api.domain.logger.Logger;
import com.logger.api.domain.services.Service;
import com.logger.api.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class LoggerFactory implements ILoggerFactory {

    @Autowired
    private ServiceRepository serviceRepository;

    private Service fetchOriginService(String token) {
        return serviceRepository.findByToken(token)
                .orElseThrow(() -> new RuntimeException("Service not found: " + token));
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
        Service originService = this.fetchOriginService(token);
        return new Logger(
                UUID.randomUUID(),
                originService,
                errorType,
                traceback,
                function,
                line,
                filename
        );
    }
}
