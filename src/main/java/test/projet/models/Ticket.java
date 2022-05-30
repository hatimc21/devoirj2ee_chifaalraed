package test.projet.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="tickets")
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_t;
	private String statut;
	private String typeUrgence;
	private String description;
	private String environnement;
	private boolean attribue=false;
	
	
	
	@JoinColumn(name = "developpeur_id")
	@ManyToOne
	private Developpeur developpeur;
	
	
	@JoinColumn(name = "client_id")
	@ManyToOne
	private Client client;
	
	@JoinColumn(name = "administrateur_id")
	@ManyToOne
	private Administrateur administrateur;
	


	public int getId_t() {
		return id_t;
	}
	public void setId_t(int id_t) {
		this.id_t = id_t;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getTypeUrgence() {
		return typeUrgence;
	}
	public void setTypeUrgence(String typeUrgence) {
		this.typeUrgence = typeUrgence;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEnvironnement() {
		return environnement;
	}
	public void setEnvironnement(String environnement) {
		this.environnement = environnement;
	}
	public boolean getAttribue() {
		return attribue;
	}
	public void setAttribue(boolean attribue) {
		this.attribue = attribue;
	}

	
	

}

