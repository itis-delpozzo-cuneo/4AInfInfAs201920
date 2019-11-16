/**
 * Created by d.claudio.borgogno on 13/11/2019.
 */
public class Programma {
    private int codice;
    private String denominazione;
    private String produttore;
    private String sistemaOperativo;
    private int versione;
    private int annoCreazione;

    public Programma() {
    }

    public Programma(int codice, String denominazione, String produttore, String sistemaOperativo, int versione, int annoCreazione) {
        this.codice = codice;
        this.denominazione = denominazione;
        this.produttore = produttore;
        this.sistemaOperativo = sistemaOperativo;
        this.versione = versione;
        this.annoCreazione = annoCreazione;
    }

    public int getCodice() {
        return codice;
    }

    public void setCodice(int codice) {
        this.codice = codice;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public String getProduttore() {
        return produttore;
    }

    public void setProduttore(String produttore) {
        this.produttore = produttore;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public int getVersione() {
        return versione;
    }

    public void setVersione(int versione) {
        this.versione = versione;
    }

    public int getAnnoCreazione() {
        return annoCreazione;
    }

    public void setAnnoCreazione(int annoCreazione) {
        this.annoCreazione = annoCreazione;
    }

    public boolean equals(Programma programma){
        boolean bUguali = false;

        if(programma!=null
           && this.codice == programma.getCodice()
           && this.denominazione.equalsIgnoreCase(programma.getDenominazione())
           && this.produttore.equalsIgnoreCase(programma.getProduttore())
           && this.sistemaOperativo.equalsIgnoreCase(programma.getSistemaOperativo())
           && this.versione == programma.getVersione()
           && this.annoCreazione == programma.getAnnoCreazione()
        )
            bUguali=true;

        return bUguali;
    }

    @Override
    public String toString() {
        return "Programma{" +
                "codice=" + codice +
                ", denominazione='" + denominazione + '\'' +
                ", produttore='" + produttore + '\'' +
                ", sistemaOperativo='" + sistemaOperativo + '\'' +
                ", versione=" + versione +
                ", annoCreazione=" + annoCreazione +
                '}';
    }

    public void caricaProgramma(){
        this.codice = InputOutputUtility.leggiNumero("\tInserisci codice: ");
        this.denominazione = InputOutputUtility.leggiNome("\tInserisci denominazione: ");
        this.produttore = InputOutputUtility.leggiNome("\tInserisci produttore: ");
        this.sistemaOperativo = InputOutputUtility.leggiNome("\tInserisci sistema operativo: ");
        this.versione = InputOutputUtility.leggiNumero("\tInserisci versione: ");
        this.annoCreazione = InputOutputUtility.leggiNumero("\tInserisci anno di creazione: ");
    }
}
