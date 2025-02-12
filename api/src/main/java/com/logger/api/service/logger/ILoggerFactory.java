package com.logger.api.service.logger;

import com.logger.api.domain.logger.Logger;

public interface ILoggerFactory {
    Logger createLogger(
            String errorType,
            String traceback,
            String function,
            Integer line,
            String filename,
            String token
    );
}
