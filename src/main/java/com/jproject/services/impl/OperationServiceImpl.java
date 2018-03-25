package com.jproject.services.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.jproject.dto.OperationDTO;
import com.jproject.dto.RankingDTO;
import com.jproject.dto.ResultDTO;
import com.jproject.mapper.InternalMapper;
import com.jproject.model.Operation;
import com.jproject.repo.impl.OperationRepositoryImpl;
import com.jproject.services.OperationService;
import com.jproject.util.WeekDays;


public class OperationServiceImpl implements OperationService{
	
	private OperationRepositoryImpl operRepo = new OperationRepositoryImpl();
	
	public OperationServiceImpl()
	{
		this.operRepo.initializeRepo();
	}

	@Override
	public List<ResultDTO> getIncomingByDate() {
		List<OperationDTO> listIncomingOperationsDTO = new ArrayList<OperationDTO> ();
		List<Operation> listIncomingOperations = operRepo.getIncomingsOperations();
		
		listIncomingOperations.stream().forEach(operation -> {
			listIncomingOperationsDTO.add(InternalMapper.OperationToDTO(operation));
		});

		final List<ResultDTO> reportResult  = recalculateSettlementDate(listIncomingOperationsDTO);
		
		return reportResult;
	}

	@Override
	public List<ResultDTO> getOutgoingsByDate() {
		List<OperationDTO> listOutgoingOperationsDTO = new ArrayList<OperationDTO> ();
		List<Operation> listOutgoingOperations = operRepo.getOutgoingsOperations();
		
		listOutgoingOperations.stream().forEach(operation -> {
			listOutgoingOperationsDTO.add(InternalMapper.OperationToDTO(operation));
		});
		
		final List<ResultDTO> reportResult = recalculateSettlementDate(listOutgoingOperationsDTO);
		
		return reportResult;
	}
	
	@Override
	public List<RankingDTO> getIncomingRanking() {
		List<OperationDTO> listIncomingOperationsDTO = new ArrayList<OperationDTO> ();
		List<Operation> listIncomingOperations = operRepo.getIncomingsOperations();
		
		listIncomingOperations.stream().forEach(operation -> {
			listIncomingOperationsDTO.add(InternalMapper.OperationToDTO(operation));
		});
		
		Map<String,RankingDTO> resultsMap = new HashMap<String,RankingDTO> ();
		
		listIncomingOperationsDTO.stream().forEach(dtoOperation -> {
			final Set<OperationDTO> totalAmountOperation = listIncomingOperationsDTO.stream().filter(oper -> 
			oper.getEntity().equals(dtoOperation.getEntity())).collect(Collectors.toSet());
			
			BigDecimal totalUSDAmountOperation = totalAmountOperation.stream().map(OperationDTO::getUsdTotalAmount).reduce(BigDecimal.ZERO,BigDecimal::add);
			
			RankingDTO finalResult = new RankingDTO();
			finalResult.setEntity(dtoOperation.getEntity());
			finalResult.setUsdAmount(totalUSDAmountOperation);
			
			resultsMap.put(finalResult.getEntity(),finalResult);
		});
		
		List<RankingDTO> rankingResult = (resultsMap.values().stream().collect(Collectors.toList()));
		rankingResult.sort((a, b) -> b.getUsdAmount().compareTo(a.getUsdAmount()));
		return rankingResult;
		
	}
	
	@Override
	public List<RankingDTO> getOutgoingRanking() {
		List<OperationDTO> listOutgoingOperationsDTO = new ArrayList<OperationDTO> ();
		List<Operation> listOutgoingOperations = operRepo.getOutgoingsOperations();
		
		listOutgoingOperations.stream().forEach(operation -> {
			listOutgoingOperationsDTO.add(InternalMapper.OperationToDTO(operation));
		});
		
		Map<String,RankingDTO> resultsMap = new HashMap<String,RankingDTO> ();
		
		listOutgoingOperationsDTO.stream().forEach(dtoOperation -> {
			final Set<OperationDTO> totalAmountOperation = listOutgoingOperationsDTO.stream().filter(oper -> 
			oper.getEntity().equals(dtoOperation.getEntity())).collect(Collectors.toSet());
			
			BigDecimal totalUSDAmountOperation = totalAmountOperation.stream().map(OperationDTO::getUsdTotalAmount).reduce(BigDecimal.ZERO,BigDecimal::add);
			
			RankingDTO finalResult = new RankingDTO();
			finalResult.setEntity(dtoOperation.getEntity());
			finalResult.setUsdAmount(totalUSDAmountOperation);
			
			resultsMap.put(finalResult.getEntity(),finalResult);
		});
		
		List<RankingDTO> rankingResult = (resultsMap.values().stream().collect(Collectors.toList()));
		rankingResult.sort((a, b) -> b.getUsdAmount().compareTo(a.getUsdAmount()));
		return rankingResult;
		
	}
	
	private List<ResultDTO> recalculateSettlementDate(final List<OperationDTO> listOperationsDTO)
	{
		Map<LocalDate,ResultDTO> resultsMap = new HashMap<LocalDate,ResultDTO> ();
		
		listOperationsDTO.stream().forEach(dtoOperation -> {			
			dtoOperation.setSettlementDate(WeekDays.getNextWeekDay(dtoOperation.getSettlementDate(),dtoOperation.getCurrency()));
		});
	
		
		listOperationsDTO.stream().forEach(dtoOperation -> {
			final Set<OperationDTO> operationsPerDay = listOperationsDTO.stream().filter(oper -> 
			oper.getSettlementDate().equals(dtoOperation.getSettlementDate())).collect(Collectors.toSet());
			
			BigDecimal totalUSDAmountPerDay = operationsPerDay.stream().map(OperationDTO::getUsdTotalAmount).reduce(BigDecimal.ZERO,BigDecimal::add);
			
			ResultDTO finalResult = new ResultDTO();
			finalResult.setSettlementDate(dtoOperation.getSettlementDate());
			finalResult.setUsdTotalAmount(totalUSDAmountPerDay);
			
			resultsMap.put(finalResult.getSettlementDate(),finalResult);
		});
		return resultsMap.values().stream().collect(Collectors.toList());
		
		
	}
	
	

}