package com.jproject.repo;

import java.util.List;
import java.util.Optional;

import com.jproject.model.Operation;

public interface OperationRepository{
	
	public void initializeRepo();
	
	public List<Operation> getIncomingsOperations();
	
	public List<Operation> getOutgoingsOperations();
	
	public void save(Operation operation);
	
	public Optional <Operation> findById(Long id);
}
