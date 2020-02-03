package itis.cuneo.preventivo;

public class Articolo {

	private String codice;
	private String descrizione;
	private double importoSenzaIVA;
	private int scontoPercentuale;
	private int quantita;

	public Articolo() {
		super();
	}

	public Articolo(String codice, String descrizione, double importoSenzaIVA, int scontoPercentuale, int quantita) {
		super();
		this.codice = codice;
		this.descrizione = descrizione;
		this.importoSenzaIVA = importoSenzaIVA;
		this.scontoPercentuale = scontoPercentuale;
		this.quantita = quantita;
	}
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public double getImportoSenzaIVA() {
		return importoSenzaIVA;
	}
	public void setImportoSenzaIVA(double importoSenzaIVA) {
		this.importoSenzaIVA = importoSenzaIVA;
	}
	public int getScontoPercentuale() {
		return scontoPercentuale;
	}
	public void setScontoPercentuale(int scontoPercentuale) {
		this.scontoPercentuale = scontoPercentuale;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	@Override
	public String toString() {
		return "Articolo [codice=" + codice + ", descrizione=" + descrizione + ", importoSenzaIVA=" + importoSenzaIVA
				+ ", scontoPercentuale=" + scontoPercentuale + ", quantita=" + quantita + "]";
	}
	
	public String toRowCsv() {
		return "Articolo"+ Preventivo.SEPARATOR +codice + Preventivo.SEPARATOR  + descrizione + Preventivo.SEPARATOR  + importoSenzaIVA
				+ Preventivo.SEPARATOR  + scontoPercentuale + Preventivo.SEPARATOR + quantita + "\n";
	}
	
	public double calcolaPrezzoScontato(double p) {
		double sconto, prezzoFinale;
		sconto = p * (this.getScontoPercentuale()/100); //prezzo*(5/100) = prezzo*0.5
		prezzoFinale = p - sconto;
		//prezzoFinale = prezzo * (1 - (this.getScontoPercentuale()/100)) = prezzo * 0.95
		return prezzoFinale;
	}
	
	public Articolo caricaArticolo() {
		codice = Tastiera.leggiNome("inserire il codice: ");
		descrizione = Tastiera.leggiNome("inserire la descrizione: ");
		importoSenzaIVA = Tastiera.leggiNumeroDouble("inserire l'importo: ");
		scontoPercentuale = Tastiera.leggiNumero("inserire lo sconto in percentuale: ") ;
		quantita = Tastiera.leggiNumero("inserire la quantit�: ") ;
		Articolo articolo= new Articolo(codice,descrizione,importoSenzaIVA,scontoPercentuale,quantita);
		return articolo;
	}
	
}
