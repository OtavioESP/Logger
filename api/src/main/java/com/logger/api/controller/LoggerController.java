package com.logger.api.controller;

import com.logger.api.domain.logger.LoggerRequestDTO;
import com.logger.api.domain.logger.LoggerResponseDTO;
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
    public ResponseEntity<LoggerResponseDTO> createLog(
            @RequestBody LoggerRequestDTO body,
            @RequestHeader(value = "X-Api-Key") String token
    ) {
        System.out.println(token);
        System.out.println(body.function());
        System.out.println(body.args());
        LoggerResponseDTO newLog = this.loggerService.createLogInstance(body, token);

        return ResponseEntity.ok(newLog);
    }
}
