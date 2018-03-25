package com.jproject.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ResultDTO {
	
	private LocalDate SettlementDate;
	private BigDecimal usdTotalAmount;
	
	public LocalDate getSettlementDate() {
		return SettlementDate;
	}
	public void setSettlementDate(LocalDate settlementDate) {
		SettlementDate = settlementDate;
	}
	public BigDecimal getUsdTotalAmount() {
		return usdTotalAmount;
	}
	public void setUsdTotalAmount(BigDecimal usdTotalAmount) {
		this.usdTotalAmount = usdTotalAmount;
	}
	
	

}
