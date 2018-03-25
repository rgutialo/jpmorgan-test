package com.jproject.main;

import java.util.List;

import com.jproject.dto.RankingDTO;
import com.jproject.dto.ResultDTO;
import com.jproject.services.impl.OperationServiceImpl;


public class App 
{
    public static void main( String[] args )
    {
        OperationServiceImpl reportServer = new OperationServiceImpl();
        final List<ResultDTO> incomingsResult = reportServer.getIncomingByDate();
        final List<ResultDTO> outgoingResult = reportServer.getOutgoingsByDate();
        final List<RankingDTO> incomingsRanking = reportServer.getIncomingRanking();
        final List<RankingDTO> outgoingRanking = reportServer.getOutgoingRanking();
        
        System.out.println("Incomings Report:");
        System.out.println("-----------------");
        incomingsResult.forEach(result ->{
        	System.out.println("Date: ".concat(result.getSettlementDate().toString().concat(" - Amount: ").concat(result.getUsdTotalAmount().toPlainString().concat(" USD"))));
        });
        
        System.out.println("Outgoings Report:");
        System.out.println("-----------------");
        outgoingResult.forEach(result ->{
        	System.out.println("Date: ".concat(result.getSettlementDate().toString().concat(" - Amount: ").concat(result.getUsdTotalAmount().toPlainString().concat(" USD"))));
        });
        
        System.out.println("Incomings Ranking:");
        System.out.println("-----------------");
        incomingsRanking.forEach(result ->{
        	System.out.println("Entity: ".concat(result.getEntity().toString().concat(" - Amount: ").concat(result.getUsdAmount().toPlainString().concat(" USD"))));
        });
        
        System.out.println("Outgoing Ranking:");
        System.out.println("-----------------");
        outgoingRanking.forEach(result ->{
        	System.out.println("Entity: ".concat(result.getEntity().toString().concat(" - Amount: ").concat(result.getUsdAmount().toPlainString().concat(" USD"))));
        });
        
        
        
    }
}
