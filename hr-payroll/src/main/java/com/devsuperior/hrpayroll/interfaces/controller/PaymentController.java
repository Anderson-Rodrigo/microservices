package com.devsuperior.hrpayroll.interfaces.controller;

import com.devsuperior.hrpayroll.domain.entities.Payment;
import com.devsuperior.hrpayroll.domain.service.PaymentService;
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

	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payment> findAll(@PathVariable UUID workerId,
										   @PathVariable Integer days){

		Payment payment = paymentService.getPayment(workerId, days);
		return new ResponseEntity<>(payment, HttpStatus.OK);
	}
}
