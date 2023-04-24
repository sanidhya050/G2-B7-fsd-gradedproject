package com.gl.tickettrackingapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.tickettrackingapplication.entity.Ticket;

@Repository
public interface TicketRepository  extends JpaRepository <Ticket, Integer>{

}
