package com.devsuperior.hrpayroll.interfaces.controller;

import com.devsuperior.hrpayroll.domain.entities.Payment;
import com.devsuperior.hrpayroll.domain.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	private final PaymentService paymentService;

	public PaymentController (PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@HystrixCommand(fallbackMethod = "getPaymentAlternative")
	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payment> findAll(@PathVariable UUID workerId,
										   @PathVariable Integer days){

		Payment payment = paymentService.getPayment(workerId, days);
		return new ResponseEntity<>(payment, HttpStatus.OK);
	}

	public ResponseEntity<Payment> getPaymentAlternative(UUID workerId, Integer days){
		Payment payment = new Payment("TESTE", 2.2, 2);
		return new ResponseEntity<>(payment, HttpStatus.OK);
	}
}
