package test.projet.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
public class Developpeur {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code_dev;
	private String nom;
	private String prenom;
	private String email;
	
	
	@OneToMany(mappedBy = "developpeur")
	private List<Ticket> tickets;
	
	




	

	

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public int getCode_dev() {
		return code_dev;
	}

	public void setCode_dev(int code_dev) {
		this.code_dev = code_dev;
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

	@Override
	public String toString() {
		return "Developpeur [code_dev=" + code_dev + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", tickets=" + tickets + "]";
	}





}
