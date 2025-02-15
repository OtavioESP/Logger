package com.logger.api.domain.logger;

import com.logger.api.domain.services.Service;

public record LoggerResponseDTO(Service service, String errorType, String traceback) {
    public LoggerResponseDTO(Logger log) {
        this(log.getService(), log.getErrorType(), log.getTraceback());
    }
}
