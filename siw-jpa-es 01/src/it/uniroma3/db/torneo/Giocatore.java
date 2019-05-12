package it.uniroma3.db.torneo;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Giocatore {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id; 
	@Column(nullable= false)
	private String nome;
	@Column(nullable= false)
	private String cognome;
	@Column (nullable= false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDiNascita;
	@Column (nullable= false)
	private String ruolo;
	@Column
	private double altezza;
	@Column
	private int peso; 
	
	public Giocatore () {
	}
	
	public Giocatore (Long id, String nome, String cognome, Date dn, String ruolo, double altezza, int peso) {
		this.id=id;
		this.nome= nome;
		this.cognome= cognome;
		this.dataDiNascita= dn;
		this.ruolo= ruolo;
		this.altezza= altezza; 
		this.peso= peso;
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
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Date getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	public double getAltezza() {
		return altezza;
	}
	public void setAltezza(double altezza) {
		this.altezza = altezza;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}

	
}
