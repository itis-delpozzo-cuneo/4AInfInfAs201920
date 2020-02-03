package it.itis.cuneo.backend;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Punto {
	private String nome;
	private int cordx;
	private int cordy;
	public Punto(String nome, int cordx, int cordy) {
		super();
		this.nome = nome;
		this.cordx = cordx;
		this.cordy = cordy;
	}
	public String getNome() {
		return nome;
	}
	@XmlAttribute
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCordx() {
		return cordx;
	}
	@XmlElement
	public void setCordx(int cordx) {
		this.cordx = cordx;
	}
	public int getCordy() {
		return cordy;
	}
	@XmlElement
	public void setCordy(int cordy) {
		this.cordy = cordy;
	}
	@Override
	public String toString() {
		return "Punto [nome=" + nome + ", cordx=" + cordx + ", cordy=" + cordy + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cordx;
		result = prime * result + cordy;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Punto other = (Punto) obj;
		if (cordx != other.cordx)
			return false;
		if (cordy != other.cordy)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public String toXml() {
		return  "\t<punto nome=\""+ nome + "\">" +
				"\t\t<cordx>" + cordx + "</cordx>\n" +
				"\t\t<cordy>" + cordy + "</cordy>\n"+
				"\t</punto>\n";
	}



}
