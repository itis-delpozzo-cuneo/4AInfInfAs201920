package it.itis.cuneo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name="ElencoLibri")
public class ElencoLibri extends ArrayList<Libro>{


	public List<Libro> getLista() {
		return this;
	}
	
	@XmlElement(name = "Libro")
	public void setLista(List<Libro> lista) {
		this.clear();
		this.addAll(lista);
	}
	 
    
	
}
