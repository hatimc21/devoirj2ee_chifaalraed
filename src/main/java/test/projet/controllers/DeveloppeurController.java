package test.projet.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import test.projet.models.Developpeur;
import test.projet.models.Ticket;
import test.projet.repository.DeveloppeurRepository;
import test.projet.repository.TicketRepository;
import test.projet.services.DeveloppeurService;
import test.projet.services.TicketService;



@Controller
public class DeveloppeurController {
	
	@Autowired
	private DeveloppeurService devService;
	@Autowired
	private TicketService ticketService;
	
	@GetMapping("/redirection")
	public String ll(Model m) {
		return "tickets/affect";
	}
	
	@GetMapping("/liste")
	public String tableau(Model m) {
		return "tickets/listeadmin";
	}
	
	@GetMapping("/select")
	public String liste(Model model) {
		List<Developpeur> listeDev=devService.lesDeveloppeurs();
		model.addAttribute("listeDev", listeDev);
		model.addAttribute("dev", new Developpeur());
		List<Ticket> listeTicket=ticketService.lesTicketsN();
		model.addAttribute("listeTicket", listeTicket);
		model.addAttribute("ticket", new Ticket());
		return "tickets/affect";
	}
	
	@PostMapping("/aff")
	public String affecter(@RequestParam("dev")int code_dev,@RequestParam("ticket")int id_t) {
		devService.affecterTicket(code_dev, id_t);
		return "tickets/affect";
		
	}
	
	


}
