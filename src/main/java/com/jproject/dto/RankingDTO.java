package com.jproject.dto;

import java.math.BigDecimal;

public class RankingDTO {
	
	private String entity;
	private BigDecimal usdAmount;
	
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
	public BigDecimal getUsdAmount() {
		return usdAmount;
	}
	public void setUsdAmount(BigDecimal usdAmount) {
		this.usdAmount = usdAmount;
	}
	
}
