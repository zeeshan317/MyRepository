package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cg.entity.Flight;
import com.cg.repo.FlightRepo;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {

	@Autowired
	private FlightRepo repo;
	
	//@Transactional(propagation =Propagation.REQUIRED) when specifying particular method  otherwise all methods will be assigned.
	public int addFlight(Flight flight) {
		return repo.save(flight);
	}

	public Flight getFlight(int id) {
		return repo.fetch(id);
	}

	public List<Flight> getList() {
		return repo.list();
	}

	public List<Flight> getByCarrier(String carrier) {
		return repo.findByCarrier(carrier);
	}
	
}
