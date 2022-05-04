package com.devsuperior.hrpayroll.domain.entities;

import lombok.Data;

import java.util.UUID;

@Data
public class Worker {

	private UUID id;

	private String name;

	private Double dayliIncome;

}
