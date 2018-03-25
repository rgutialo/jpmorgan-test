package com.jproject.repo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.jproject.fixture.OperationRepositoryInitializer;
import com.jproject.model.Operation;
import com.jproject.repo.OperationRepository;

public class OperationRepositoryImpl implements OperationRepository {
	
	private  List<Operation> repository = new ArrayList<Operation> ();

	public void initializeRepo()
	{ 
		this.repository = OperationRepositoryInitializer.initializeRepo();
	}
	
	public List<Operation> getIncomingsOperations() {
		
		List<Operation> incomingOperations = this.repository.stream().filter(operation -> 
		("S").equals(operation.getOperationType())).collect(Collectors.toList());
		
		return incomingOperations;
	}

	public List<Operation> getOutgoingsOperations() {
		
		List<Operation> outGoingOperations = this.repository.stream().filter(operation -> 
		("B").equals(operation.getOperationType())).collect(Collectors.toList());
		
		return outGoingOperations;
	}

	@Override
	public void save(Operation operation) {
	
		Optional<Operation> oper = findById(operation.getId());
		
		if (!oper.isPresent())
		{
			repository.add(operation);
		}
		else
		{
			repository.remove(oper.get());
			repository.add(operation);
		}
		
	}

	@Override
	public Optional<Operation> findById(Long id) {
		
		return Optional.of(repository.stream().filter(oper -> id.equals(oper.getId())).findAny().orElse(null));
	}
	
	

}
