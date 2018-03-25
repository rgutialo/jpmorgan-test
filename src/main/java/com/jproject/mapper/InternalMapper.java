package com.jproject.mapper;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.jproject.dto.OperationDTO;
import com.jproject.model.Operation;

public class InternalMapper {
	
	public static OperationDTO OperationToDTO(Operation operation)
	{
		OperationDTO operDTO = new OperationDTO();
		
		operDTO.setId(operation.getId());
		operDTO.setEntity(operation.getEntity());
		operDTO.setOperationType(operation.getOperationType());
		operDTO.setAgreedFx(operation.getAgreedFx());
		operDTO.setCurrency(operation.getCurrency());
		operDTO.setInstructionDate(operation.getInstructionDate());
		operDTO.setSettlementDate(operation.getSettlementDate());
		operDTO.setUnits(operation.getUnits());
		operDTO.setPricePerUnit(operation.getPricePerUnit());
		if (operation.getUnits() != null && operation.getPricePerUnit() != null && operation.getAgreedFx() != null)
		{
			operDTO.setUsdTotalAmount(new BigDecimal(operation.getUnits()).multiply(operation.getPricePerUnit().multiply(operation.getAgreedFx())).setScale(2,RoundingMode.CEILING));
		}
		
		return operDTO;
		
	}

}
