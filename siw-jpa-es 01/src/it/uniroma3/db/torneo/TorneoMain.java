package it.uniroma3.db.torneo;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


import java.util.*;



public class TorneoMain {
	public static void main (String [] args) {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("torneo-unit");
		//"product-unit" serve per la configurazione tremite file .xml nella cartella "META-INF"
		//il file .xml serve per specificare quali classi sono gestite e le proprietà della connessione al db
		EntityManager em = emf.createEntityManager();
		
		//creo una squadra
		Squadra team1= new Squadra();
		team1.setNomeAllenatore("Arrigo minkia");
		team1.setNome("FC Latina");
		team1.setAnnoFondazione(1997);

		
		//creo un giocatore
		Giocatore g1= new Giocatore();
		g1.setNome("Valentino");
		g1.setCognome("Pappalardo");
		g1.setPeso(90);
		g1.setRuolo("centrocampista");
		g1.setAltezza(1.80);
		GregorianCalendar cal = new GregorianCalendar (2000, 2, 20);
		Date data1= cal.getTime();
		g1.setDataDiNascita(data1);
		
		
		//creo un giocatore
		Giocatore g2= new Giocatore();
		g2.setNome("Fabiano");
		g2.setCognome("Baudo");
		g2.setPeso(70);
		g2.setRuolo("attacante");
		g2.setAltezza(1.90);
		GregorianCalendar cal1 = new GregorianCalendar (1993, 12, 5);
		Date data2= cal1.getTime();
		g2.setDataDiNascita(data2);
		
		
		List<Giocatore> giocatori= new ArrayList<Giocatore> ();
		giocatori.add(g2);
		giocatori.add(g1);
		
		team1.setGiocatori(giocatori);
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		em.persist(team1);
		
		tx.commit();
		em.close();
		emf.close();
	}
}
