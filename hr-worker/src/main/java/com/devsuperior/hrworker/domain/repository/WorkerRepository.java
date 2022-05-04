package com.devsuperior.hrworker.domain.entities.repository;

import com.devsuperior.hrworker.domain.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, UUID> {

}
