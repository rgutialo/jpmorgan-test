package com.jproject.services;

import java.util.List;

import com.jproject.dto.RankingDTO;
import com.jproject.dto.ResultDTO;

public interface OperationService {
	
	public List<ResultDTO> getIncomingByDate();
	public List<ResultDTO> getOutgoingsByDate();
	public List<RankingDTO> getIncomingRanking();
	public List<RankingDTO> getOutgoingRanking();

}
