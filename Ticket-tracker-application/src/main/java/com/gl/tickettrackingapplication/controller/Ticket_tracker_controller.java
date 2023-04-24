package com.gl.tickettrackingapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.tickettrackingapplication.entity.Ticket;
import com.gl.tickettrackingapplication.service.Ticket_tracker_service;

@RequestMapping("/ticket")
@Controller
public class Ticket_tracker_controller {

	/*
	 * /ticket/showFormforAdd --> display where we can create the ticket
	 * /ticket/showFormForView --> view all the object data
	 * /ticket/showFormforUpdate --> update ticket object /ticket/ delete--> delete
	 * ticket object based on id /ticket/save / update --> save or update ticket
	 * object into database /ticket/read --> display all the ticket data
	 * 
	 * extract the common url and put on class level
	 */
	@Autowired
	private Ticket_tracker_service ticket_tracker_service;

	@GetMapping("/showFormforAdd")
	public String showFormforAdd(Model theModel) {
		Ticket theTicket = new Ticket();

		theModel.addAttribute("ticket", theTicket);
		return " ticket/ticket-form";
	}

	@GetMapping("/read")
	public String readTickets(Model theModel) {
		// read the data of an ticket
		ticket_tracker_service.findAll();
		// get all the tickets from the database
		List<Ticket> theTickets = ticket_tracker_service.findAll();
		theModel.addAttribute("tickets", theTickets);
		return "tickets/read-tickets";
	}

	// ticket/save / update
	@PostMapping("/update")
	public String updateTicket(@ModelAttribute("ticket") Ticket theTicket) {
		ticket_tracker_service.save(theTicket);
		return "redirect:/tickets/read";
	}

	@PostMapping("/delete")
	public String deleteTicket(@RequestParam("TicketId") int id) {
		ticket_tracker_service.deleteById(id);
		return "redirect:/tickets/read";

	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("TicketId") int id, Model theModel) {
		ticket_tracker_service.findById(id);
		theModel.addAttribute("ticket", ticket);
		return " ticket/ticket-form";
	}

	@RequestMapping("/search")
	public String search(@RequestParam("count") int id) {
		ticket_tracker_service.id(id);
		return " ticket/first three records";
	}
}
