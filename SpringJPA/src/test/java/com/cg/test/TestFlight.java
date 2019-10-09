package com.cg.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cg.entity.Flight;
import com.cg.service.FlightService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appctx.xml")
public class TestFlight {

	@Autowired
	private FlightService service;

	@Test
	public void testAddFlight() {
		Flight fl = new Flight();
		fl.setCarrier("Air India");
		fl.setSource("Jaipur");
		fl.setDestination("Lucknow");
		fl.setDistance(574);
		int flid = service.addFlight(fl);
		System.out.println("Flight ID: " + flid);
	}

	@Test
	public void testGetFlight() {
		Flight f1 = service.getFlight(2);
		System.out.println(f1.toString());
	}
	@Test
	public void testFetchAll() {
		List<Flight> f = service.getList();
		for (Flight flight : f)
		System.out.println(flight.toString());
	}
	@Test
	public void testGetFlightByCarrier() {
		List<Flight> f2 = service.getByCarrier("Spicejet");
		for (Flight flight : f2)
		System.out.println(flight.toString());
	}
}
