package com.devsuperior.hrworker.interfaces.controller;

import com.devsuperior.hrworker.domain.entities.Worker;
import com.devsuperior.hrworker.domain.entities.services.WorkerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/workers")
public class WorkerController {

	private final WorkerService workerService;

	public WorkerController (WorkerService workerService) {
		this.workerService = workerService;
	}

	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list =  workerService.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable UUID id){
		Optional<Worker> worker = workerService.findById(id);
		if(worker.isPresent()){
			return new ResponseEntity<>(worker.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
