package it.itis.cuneo;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by d.claudio.borgogno on 30/01/2020.
 */
public class Allievo {
    private String cognome;
    private String nome;
    private String votoInformatica;
    private String votoMatematica;
    private String votoStoria;

    public Allievo() {
    }

    public Allievo(String cognome, String nome, String votoInformatica, String votoMatematica, String votoStoria) {
        this.cognome = cognome;
        this.nome = nome;
        this.votoInformatica = votoInformatica;
        this.votoMatematica = votoMatematica;
        this.votoStoria = votoStoria;
    }

    public String getCognome() {
        return cognome;
    }

    @XmlAttribute
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    @XmlAttribute
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVotoInformatica() {
        return votoInformatica;
    }

    @XmlElement
    public void setVotoInformatica(String votoInformatica) {
        this.votoInformatica = votoInformatica;
    }

    public String getVotoMatematica() {
        return votoMatematica;
    }

    @XmlElement
    public void setVotoMatematica(String votoMatematica) {
        this.votoMatematica = votoMatematica;
    }

    public String getVotoStoria() {
        return votoStoria;
    }

    @XmlElement
    public void setVotoStoria(String votoStoria) {
        this.votoStoria = votoStoria;
    }

    @Override
    public String toString() {
        return "Allievo{" +
                "cognome='" + cognome + '\'' +
                ", nome='" + nome + '\'' +
                ", votoInformatica='" + votoInformatica + '\'' +
                ", votoMatematica='" + votoMatematica + '\'' +
                ", votoStoria='" + votoStoria + '\'' +
                '}';
    }
}
