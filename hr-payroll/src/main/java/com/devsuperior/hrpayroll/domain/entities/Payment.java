package com.devsuperior.hrpayroll.domain.entities;

import lombok.Data;

@Data
public class Payment {

	private String nome;

	private Double dailyIncome;

	private Integer days;

	public Payment (String bob, double dailyIncome, int days) {
		this.nome = bob;
		this.dailyIncome = dailyIncome;
		this.days = days;
	}

	@Override
	public int hashCode () {
		return getClass().hashCode();
	}

	public double getTotal(){
		return days * dailyIncome;
	}

}
