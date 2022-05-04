package com.devsuperior.hrworker.domain.entities.services;

import com.devsuperior.hrworker.domain.entities.Worker;
import com.devsuperior.hrworker.domain.entities.repository.WorkerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class WorkerService {

	private final WorkerRepository workerRepository;

	public WorkerService (WorkerRepository workerRepository) {
		this.workerRepository = workerRepository;
	}

	public List<Worker> findAll(){
		return workerRepository.findAll();
	}

	public Optional<Worker> findById(UUID id){
		return workerRepository.findById(id);
	}
}
