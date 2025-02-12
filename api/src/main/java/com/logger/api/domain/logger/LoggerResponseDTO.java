package com.logger.api.domain.logger;

import java.util.UUID;

public record LoggerResponseDTO(UUID id, String system, String errorType, String traceback) {
    public LoggerResponseDTO(Logger log) {
        this(log.getId(), log.getSystem(), log.getErrorType(), log.getTraceback());
    }
}
