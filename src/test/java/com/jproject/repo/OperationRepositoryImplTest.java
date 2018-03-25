package com.jproject.repo;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.junit.Test;

import com.jproject.model.Operation;
import com.jproject.repo.impl.OperationRepositoryImpl;

public class OperationRepositoryImplTest{
	
	
	@Resource
    private OperationRepositoryImpl operationRepository = new OperationRepositoryImpl();
    
    @Test
    public void testOperationPersist() {
    	
    	operationRepository.initializeRepo();
    	Operation operation1 = createOperation1();
        operationRepository.save(operation1);
         
        Optional <Operation> operation11 = operationRepository.findById(1L);
        assertEquals(operation1.getEntity(), operation11.get().getEntity());
    }
    
    @Test
    public void testIncomingReport()
    {
    	operationRepository.initializeRepo();
    	List<Operation> incomingDailyReport = operationRepository.getIncomingsOperations();
    	assertEquals(incomingDailyReport.size(),2);
    }
    
    @Test
    public void testOutgoingReport()
    {
    	operationRepository.initializeRepo();
    	List<Operation> outgoinDailyReport = operationRepository.getOutgoingsOperations();
    	assertEquals(outgoinDailyReport.size(),3);
    }
		
	private Operation createOperation1()
	    {
	    	Operation operation1 = new Operation();
	    	
	    	operation1.setId(1L);
	    	operation1.setEntity("foo");
	    	operation1.setOperationType("B");
	    	operation1.setAgreedFx(new BigDecimal(0.50));
	    	operation1.setCurrency("SGP");
	    	operation1.setInstructionDate(LocalDate.now());
	    	operation1.setSettlementDate(LocalDate.now());
	    	operation1.setUnits(200);
	    	operation1.setPricePerUnit(new BigDecimal(100.25));
	    	
	    	return operation1;
	    }
}
