package test.projet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.projet.models.Developpeur;
import test.projet.models.Ticket;
import test.projet.repository.DeveloppeurRepository;
import test.projet.repository.TicketRepository;

@Service
public class DeveloppeurServiceImpl implements DeveloppeurService{

	@Autowired
	DeveloppeurRepository devRepository;
	
	@Autowired
	TicketRepository ticketRepository;

	@Override
	public List<Developpeur> lesDeveloppeurs() {
		return devRepository.findAll();

	}
	
	@Override
	public void affecterTicket(int idDev,int idTicket) {
		Developpeur dev=devRepository.getById(idDev);
		Ticket ticket=ticketRepository.getById(idTicket);
		System.out.println("*************************");
		System.out.println(dev);
		System.out.println(ticket);
		if(dev!=null && ticket!=null) {
			dev.getTickets().add(ticket);
			ticket.setAttribue(true);
			devRepository.save(dev);
			
		}
	}
	
}
