package com.logger.api.domain.logger;

import com.logger.api.domain.services.Service;
import com.logger.api.utils.CreatedStampedEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Entity
@Table(name="log")
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Value
public class Logger extends CreatedStampedEntity {

    @Id
    UUID id;

    @ManyToOne
    @JoinColumn(name = "servico")
    Service service;

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
