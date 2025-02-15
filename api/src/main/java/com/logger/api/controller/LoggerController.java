package com.logger.api.controller;

import com.logger.api.domain.logger.LoggerMessageDTO;
import com.logger.api.domain.logger.LoggerRequestDTO;
import com.logger.api.service.logger.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoggerController {

    @Autowired
    private LoggerService loggerService;

    @PostMapping("/log")
    public ResponseEntity<Void> createLog(
            @RequestBody LoggerRequestDTO body,
            @RequestHeader(value = "X-Api-Key") String token
    ) {
        LoggerMessageDTO loggerMessageDTO = new LoggerMessageDTO(
                body.errorType(),
                body.traceback(),
                body.function(),
                body.args(),
                body.line(),
                body.filename(),
                token
        );
        loggerService.createLogInstance(loggerMessageDTO);
        return ResponseEntity.ok().build();
    }

//    @PostMapping("/test/queue")
//    public String sendLog(@RequestParam String message) {
//        loggerProducer.sendLogMessage(message);
//        return "Log sent!";
//    }
}
