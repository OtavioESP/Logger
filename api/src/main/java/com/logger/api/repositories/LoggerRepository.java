package com.logger.api.repositories;

import com.logger.api.domain.logger.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LoggerRepository extends JpaRepository<Logger, UUID> {}
