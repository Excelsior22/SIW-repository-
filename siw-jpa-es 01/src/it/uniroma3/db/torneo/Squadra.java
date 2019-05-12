package it.uniroma3.db.torneo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Squadra {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private  Long id; 
	@Column(nullable= false)
	private String nome;
	@Column(nullable= false)
	private  String nomeAllenatore;
	@Column(nullable=false)
	private int annoFondazione;
	/*
	 * Politiche di fetch e operazioni Cascade
	 * Fetch
	 * quando si cariano i dati di una squadra molto spesso sono richiesti 
	 * anche i dati dei giocatori. Essendo una associazione OneToMany
	 * di default il fetch è impostato su lazy load per la lista dei giocatori,
	 * quindi conviene modificarla e renderla eager.
	 * Cascade
	 * mettiamo in cascata la operazione di persist, in modo tale che quando inseriamo nel db
	 * una squadra verrano automaticamente inseriti anche i giocatori, refresh per aggiornare entrambi
	 * 
	 * 
	 */
	@OneToMany (fetch= FetchType.EAGER, cascade= {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
	@JoinColumn(name= "squadra_id")
	private List<Giocatore> giocatori; 
	
	public Squadra() {
	}
	
	public Squadra (Long id,String nome, String na, int af,List<Giocatore> lista) {
		this.nome=nome;
		this.id=id;
		this.nomeAllenatore=na;
		this.annoFondazione= af;
		this.giocatori=lista;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeAllenatore() {
		return nomeAllenatore;
	}
	public void setNomeAllenatore(String nomeAllenatore) {
		this.nomeAllenatore = nomeAllenatore;
	}
	public int getAnnoFondazione() {
		return annoFondazione;
	}
	public void setAnnoFondazione(int annoFondazione) {
		this.annoFondazione = annoFondazione;
	}
	public List<Giocatore> getGiocatori() {
		return giocatori;
	}
	public void setGiocatori(List<Giocatore> giocatori) {
		this.giocatori = giocatori;
	}

	
	
	

}
