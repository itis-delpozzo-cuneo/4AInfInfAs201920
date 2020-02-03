package it.itis.cuneo;

import javax.xml.bind.annotation.XmlAttribute;

public class Libro {

	private String codIsbn;
	private String titolo;
	private float prezzo;
	
	
	public String getCodIsbn() {
		return codIsbn;
	}
	
	@XmlAttribute
	public void setCodIsbn(String codIsbn) {
		this.codIsbn = codIsbn;
	}
	public String getTitolo() {
		return titolo;
	}
	
	@XmlAttribute
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public float getPrezzo() {
		return prezzo;
	}
	
	@XmlAttribute
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	
}
