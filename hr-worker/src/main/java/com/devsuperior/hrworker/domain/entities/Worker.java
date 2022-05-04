package com.devsuperior.hrworker.domain.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "tab_worker")
public class Worker {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wor_id")
	private UUID id;

	@Column(name = "wor_name")
	private String name;

	@Column(name = "wor_dayli_income")
	private Double dayliIncome;

}
