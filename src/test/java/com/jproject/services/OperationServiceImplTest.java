package com.jproject.services;

import static org.junit.Assert.assertEquals;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.jproject.dto.RankingDTO;
import com.jproject.dto.ResultDTO;
import com.jproject.services.impl.OperationServiceImpl;

public class OperationServiceImplTest {
	
	@Resource
    private OperationServiceImpl operationService = new OperationServiceImpl();
    
    @Test
    public void testGetIncomingByDate() {
    	
    	List<ResultDTO> testResult= operationService.getIncomingByDate();
    	assertEquals(testResult.size(),1); 
    }
    
    @Test
    public void testGetOutgoingsByDate() {
    	
    	List<ResultDTO> testResult= operationService.getOutgoingsByDate();
    	assertEquals(testResult.size(),2); 
    }
    
    @Test
    public void testIncomingRank() {    	
    	List<RankingDTO> testResult= operationService.getIncomingRanking();
    	assertEquals(testResult.size(),2); 
    	assertEquals(testResult.get(0).getEntity(),"bar"); 
    }
    
    @Test
    public void testOutgoingRank() {    	
    	List<RankingDTO> testResult= operationService.getOutgoingRanking();
    	assertEquals(testResult.size(),2); 
    	assertEquals(testResult.get(0).getEntity(),"foo"); 
    }

}
