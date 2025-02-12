package com.logger.api.domain.logger;

import java.util.Map;

public record LoggerRequestDTO(
        String errorType,
        String traceback,
        String function,
        Map<String, Object> args,
        Integer line,
        String filename) {
}
