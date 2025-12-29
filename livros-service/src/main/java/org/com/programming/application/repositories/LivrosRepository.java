package org.com.programming.application.repositories;

import org.com.programming.application.entities.LivrosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<LivrosEntity, Long> {
}
