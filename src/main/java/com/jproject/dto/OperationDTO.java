package com.jproject.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OperationDTO {
	
	private Long id;
	
	private String entity;
	
	private String operationType;
	
	private BigDecimal agreedFx;
	
	private String currency;
	
	private LocalDate instructionDate;
	
	private LocalDate SettlementDate;
	
	private Integer units;
	
	private BigDecimal pricePerUnit;
	
	private BigDecimal usdTotalAmount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public BigDecimal getAgreedFx() {
		return agreedFx;
	}

	public void setAgreedFx(BigDecimal agreedFx) {
		this.agreedFx = agreedFx;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public LocalDate getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(LocalDate instructionDate) {
		this.instructionDate = instructionDate;
	}

	public LocalDate getSettlementDate() {
		return SettlementDate;
	}

	public void setSettlementDate(LocalDate settlementDate) {
		SettlementDate = settlementDate;
	}

	public Integer getUnits() {
		return units;
	}

	public void setUnits(Integer units) {
		this.units = units;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public BigDecimal getUsdTotalAmount() {
		return usdTotalAmount;
	}

	public void setUsdTotalAmount(BigDecimal usdTotalAmount) {
		this.usdTotalAmount = usdTotalAmount;
	}
	
	

}
