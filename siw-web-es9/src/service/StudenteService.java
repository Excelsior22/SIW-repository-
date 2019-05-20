package service;

import java.util.ArrayList;
import java.util.List;

import model.Studente;

public class StudenteService {
	private List<Studente> studenti=  new ArrayList<Studente>();;
	
	public StudenteService() {
		generaStudenti(this.studenti);
	}
	//salverà uno studente
	public void salvaStudente (Studente studente) {
		//TODO
	}
	
	public List<Studente> listaStudenti(){
		return studenti;
	}

	private void generaStudenti(List<Studente> studenti) {
		Studente s1= new Studente();
		s1.setCognome("Pampana");
		s1.setNome("Alessio");
		s1.setId(1L);
		Studente s2= new Studente();
		s2.setCognome("Nalollo");
		s2.setNome("Franco");
		s2.setId(2L);
		studenti.add(s1);
		studenti.add(s2);
	}
	
	public Studente studenteByIdLong (Long id) {
		Studente studente= null;
		for(Studente s:this.studenti) {
			if(s.getId().equals(id)) {
				studente= s;
			}
		}
		return studente;
	}
}
