package com.jproject.mapper;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import org.junit.Test;

import com.jproject.dto.OperationDTO;
import com.jproject.model.Operation;

public class InternalMapperTest {
	
	@Test
    public void testOperationtoDTO() {
    	Operation operation = createOperation1();
    	OperationDTO operationDTO = InternalMapper.OperationToDTO(operation);
        
        assertEquals(operation.getId(),operationDTO.getId());
        assertEquals(operation.getEntity(),operationDTO.getEntity());
        assertEquals(operation.getEntity(),operationDTO.getEntity());
        assertEquals(operation.getOperationType(),operationDTO.getOperationType());
        assertEquals(operation.getAgreedFx(),operationDTO.getAgreedFx());
        assertEquals(operation.getCurrency(),operationDTO.getCurrency());
        assertEquals(operation.getInstructionDate(),operationDTO.getInstructionDate());
        assertEquals(operation.getSettlementDate(),operationDTO.getSettlementDate());
        assertEquals(operation.getUnits(),operationDTO.getUnits());
        assertEquals(operation.getPricePerUnit(),operationDTO.getPricePerUnit());
    }
	
	@Test
    public void tesUsdAmountCalculation() {
    	
		Operation operation = createOperation1();
    	OperationDTO operationDTO = InternalMapper.OperationToDTO(operation);
        BigDecimal usdCalculation = new BigDecimal(operationDTO.getUnits()).multiply(operationDTO.getPricePerUnit()).multiply(operationDTO.getAgreedFx());
        assertEquals(operationDTO.getUsdTotalAmount().compareTo(usdCalculation.setScale(2, RoundingMode.CEILING)),0);
    }
	
	
	
	private Operation createOperation1()
    {
    	Operation operation1 = new Operation();
    	
    	operation1.setId(1L);
    	operation1.setEntity("foo");
    	operation1.setOperationType("B");
    	operation1.setAgreedFx(new BigDecimal(0.52));
    	operation1.setCurrency("SGP");
    	operation1.setInstructionDate(LocalDate.now());
    	operation1.setSettlementDate(LocalDate.now());
    	operation1.setUnits(205);
    	operation1.setPricePerUnit(new BigDecimal(100.25));
    	
    	return operation1;
    }

}
