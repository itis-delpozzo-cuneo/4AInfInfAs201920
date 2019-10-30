package it.itis.cuneo;

/**
 * Created by d.claudio.borgogno on 30/10/2019.
 */
public class LibreriaPienaException extends Exception {
    private int codice;
    private String descrizione;

    public LibreriaPienaException(int codice, String descrizione) {
        this.codice = codice;
        this.descrizione = descrizione;
    }

    @Override
    public String toString() {
        return "LibreriaPienaException{" +
                "codice=" + codice +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
