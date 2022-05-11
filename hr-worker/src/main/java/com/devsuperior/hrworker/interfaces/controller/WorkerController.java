package com.devsuperior.hrworker.interfaces.controller;

import com.devsuperior.hrworker.domain.entities.Worker;
import com.devsuperior.hrworker.domain.services.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/workers")
public class WorkerController {

	private static Logger logger = LoggerFactory.getLogger(WorkerController.class);

	@Autowired
	private Environment env;

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
		logger.info("PORT = " + env.getProperty("local.server.port"));

		Optional<Worker> worker = workerService.findById(id);
		if(worker.isPresent()){
			return new ResponseEntity<>(worker.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
