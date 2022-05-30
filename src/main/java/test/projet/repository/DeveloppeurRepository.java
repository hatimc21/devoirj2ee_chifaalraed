package test.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import test.projet.models.Developpeur;
import test.projet.models.Ticket;




public interface DeveloppeurRepository extends JpaRepository<Developpeur, Integer> {

	
	
}
