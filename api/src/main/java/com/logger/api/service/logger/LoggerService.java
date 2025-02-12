package com.logger.api.service.logger;

import com.logger.api.domain.logger.Logger;
import com.logger.api.domain.logger.LoggerRequestDTO;
import com.logger.api.domain.logger.LoggerResponseDTO;
import com.logger.api.repositories.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerService {

    @Autowired
    private LoggerRepository loggerRepository;

    public LoggerResponseDTO createLogInstance(LoggerRequestDTO data, String token) {
        final Logger newLog = new LoggerFactory().createLogger(
                data.errorType(),
                data.traceback(),
                data.function(),
                data.line(),
                data.filename(),
                token
        );
        loggerRepository.save(newLog);
        return new LoggerResponseDTO(newLog);
    }

}
