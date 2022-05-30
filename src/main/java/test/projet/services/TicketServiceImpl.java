package test.projet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.projet.models.Ticket;
import test.projet.repository.TicketRepository;





@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	TicketRepository ticketRepository;
	@Autowired
	DeveloppeurService devRepository;

	@Override
	public List<Ticket> lesTickets() {
		return ticketRepository.findAll();

	}

	@Override
	public void supprimer(int id_t) {
		ticketRepository.deleteById(id_t);

	}

	@Override
	public void ajouter(Ticket ticket) {
		ticket.setStatut("en attente");
		ticketRepository.save(ticket);

	}

	@Override
	public void modifier(Ticket ticket) {
		Ticket p = getTicket(ticket.getId_t());
		if (p != null) {
			p.setStatut(ticket.getStatut());
			p.setTypeUrgence(ticket.getTypeUrgence());
			p.setDescription(ticket.getDescription());
			p.setEnvironnement(ticket.getEnvironnement());
			p.setAttribue(ticket.getAttribue());
			ticketRepository.save(p);
		}
	}
	
	@Override
	public void modifierr(Ticket ticket) {
		Ticket p = getTicket(ticket.getId_t());
		if (p != null) {
			p.setStatut(ticket.getStatut());
			ticketRepository.save(p);
		}
	}

	@Override
	public Ticket getTicket(int id_t) {
		if (ticketRepository.existsById(id_t))
			return ticketRepository.getById(id_t);
		else
			return null;
	}
	
	@Override
	public List<Ticket> lesTicketsN() {
		return ticketRepository.findByAttribue(false);
	}
	


}
