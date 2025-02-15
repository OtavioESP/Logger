package com.logger.api.domain.logger;

import java.io.Serializable;
import java.util.Map;

public record LoggerMessageDTO(
        String errorType,
        String traceback,
        String function,
        Map<String, Object> args,
        Integer line,
        String filename,
        String token
) implements Serializable {
}
