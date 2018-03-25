package com.jproject.fixture;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jproject.model.Operation;

public class OperationRepositoryInitializer {
	
	private OperationRepositoryInitializer() {}
	
	public static List<Operation> initializeRepo()
	{
		List<Operation> repository = new ArrayList<Operation>();
		
		repository.add(createOperation1());
		repository.add(createOperation2());
		repository.add(createOperation3());
		repository.add(createOperation4());
		repository.add(createOperation5());
		
		return repository;
	}
	
	private static Operation createOperation1()
    {
    	Operation operation1 = new Operation();
    	
    	operation1.setId(1L);
    	operation1.setEntity("foo");
    	operation1.setOperationType("B");
    	operation1.setAgreedFx(new BigDecimal(0.50));
    	operation1.setCurrency("SGP");
    	operation1.setInstructionDate(LocalDate.of(2018, 1, 1));
    	operation1.setSettlementDate(LocalDate.of(2018, 1, 6));
    	operation1.setUnits(200);
    	operation1.setPricePerUnit(new BigDecimal(100.25));
    	
    	return operation1;
    }
    
    private static Operation createOperation2()
    {
    	Operation operation2 = new Operation();
    	
    	operation2.setId(2L);
    	operation2.setEntity("bar");
    	operation2.setOperationType("S");
    	operation2.setAgreedFx(new BigDecimal(0.22));
    	operation2.setCurrency("AED");
    	operation2.setInstructionDate(LocalDate.of(2018, 1, 1));
    	operation2.setSettlementDate(LocalDate.of(2018, 1, 6));
    	operation2.setUnits(450);
    	operation2.setPricePerUnit(new BigDecimal(150.5));
    	
    	return operation2;
    }
    
    private static Operation createOperation3()
    {
    	Operation operation3 = new Operation();
    	
    	operation3.setId(3L);
    	operation3.setEntity("bar2");
    	operation3.setOperationType("S");
    	operation3.setAgreedFx(new BigDecimal(0.19));
    	operation3.setCurrency("AED");
    	operation3.setInstructionDate(LocalDate.of(2018, 1, 1));
    	operation3.setSettlementDate(LocalDate.of(2018, 1, 5));
    	operation3.setUnits(410);
    	operation3.setPricePerUnit(new BigDecimal(152.5));
    	
    	return operation3;
    }
    
    private static Operation createOperation4()
    {
    	Operation operation4 = new Operation();
    	
    	operation4.setId(4L);
    	operation4.setEntity("foo2");
    	operation4.setOperationType("B");
    	operation4.setAgreedFx(new BigDecimal(0.51));
    	operation4.setCurrency("SGP");
    	operation4.setInstructionDate(LocalDate.of(2018, 1, 1));
    	operation4.setSettlementDate(LocalDate.of(2018, 1, 1));
    	operation4.setUnits(210);
    	operation4.setPricePerUnit(new BigDecimal(99.25));
    	
    	return operation4;
    }
    
    private static Operation createOperation5()
    {
    	Operation operation4 = new Operation();
    	
    	operation4.setId(5L);
    	operation4.setEntity("foo");
    	operation4.setOperationType("B");
    	operation4.setAgreedFx(new BigDecimal(0.23));
    	operation4.setCurrency("EUR");
    	operation4.setInstructionDate(LocalDate.of(2018, 1, 1));
    	operation4.setSettlementDate(LocalDate.of(2018, 1, 7));
    	operation4.setUnits(100);
    	operation4.setPricePerUnit(new BigDecimal(35.25));
    	
    	return operation4;
    }

}
