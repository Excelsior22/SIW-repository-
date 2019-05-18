package model;

//questa diventerà un'identità 
//se modifichi questa, attenzione a controllare se fa modificata anche StudenteForm
public class Studente {
	
	private String nome;
	private String cognome;

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

}
