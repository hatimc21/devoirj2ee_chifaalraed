package test.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import test.projet.models.Ticket;





public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	List<Ticket> findByAttribue(Boolean i);
	List<Ticket> findByDeveloppeurEmail(String email);
	List<Ticket> findByClientEmail(String email);

}
