package com.logger.api.domain.logger;

import com.logger.api.utils.TimeStampedEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Table(name="log")
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Value
public class Logger extends TimeStampedEntity {

    @Id
    UUID id;

    @Column(name = "sistema")
    String system;

    @Column(name = "tipo")
    String errorType;

    String traceback;

    @Column(name = "funcao")
    String function;

    @Column(name = "linha")
    Integer line;

    @Column(name = "arquivo")
    String filename;
}
