package test.projet.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Administrateur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code_adm;
	private String nom;
	private String prenom;
	private String email;
	
	
	@OneToMany(mappedBy = "administrateur")
	private List<Ticket> tickets;
	
	public int getCode_adm() {
		return code_adm;
	}


	public void setCode_adm(int code_adm) {
		this.code_adm = code_adm;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Ticket> getTickets() {
		return tickets;
	}


	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}



	
	
}
