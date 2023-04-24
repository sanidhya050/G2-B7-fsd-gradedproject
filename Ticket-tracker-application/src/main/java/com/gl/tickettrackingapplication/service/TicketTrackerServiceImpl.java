package com.gl.tickettrackingapplication.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.tickettrackingapplication.dao.TicketRepository;
import com.gl.tickettrackingapplication.entity.Ticket;

@Service
public class TicketTrackerServiceImpl implements Ticket_tracker_service {

	@Override
	public void save(Ticket theTicket) {
		// TODO Auto-generated method stub
		ticketRepository.save(theTicket);
	}

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public List<Ticket> findAll() {
		return ticketRepository.findAll();
	}

	@Override
	public void deleteById(int Id) {
		 ticketRepository.deleteById(Id);
    }
	@Override
	public Ticket findById( int Id) {
		Ticket ticket = ticketRepository.findById(Id).get();
		if (ticket == null)
			throw new RuntimeException("Did not find the ticket id :" + Id );
		else 
			return ticket ;
	}

	@Override
	public void id(int id) {
		// TODO Auto-generated method stub
	}

}
