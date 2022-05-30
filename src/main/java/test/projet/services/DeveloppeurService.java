package test.projet.services;

import java.util.List;

import test.projet.models.Developpeur;
import test.projet.models.Ticket;

public interface DeveloppeurService {
	
	public List<Developpeur> lesDeveloppeurs();

	public void affecterTicket(int idDev,int idTicjet);
	
}
