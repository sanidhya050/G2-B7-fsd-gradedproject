package com.gl.tickettrackingapplication.service;

import java.util.List;


import com.gl.tickettrackingapplication.entity.Ticket;

public interface Ticket_tracker_service {
	
	// create (insert or update ) 
	public void save(Ticket theTicket );
	
	// read or view
	public List<Ticket> findAll();
	
	// deletebyId
	public void deleteById(int Id);

	public Ticket findById(int Id);

	public void id(int id);

	
	// search 

}
