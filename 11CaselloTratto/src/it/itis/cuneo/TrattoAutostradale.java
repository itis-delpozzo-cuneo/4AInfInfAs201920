package it.itis.cuneo;

import java.util.Calendar;

/**
 * Created by d.claudio.borgogno on 21/10/2019.
 */
public class TrattoAutostradale {

    //attributi
    private Casello caselloIngresso;
    private Casello caselloUscita;
    private int distanza;

    public TrattoAutostradale() {
    }

    public TrattoAutostradale(Casello caselloIngresso, Casello caselloUscita, int distanza) {
        this.caselloIngresso = caselloIngresso;
        this.caselloUscita = caselloUscita;
        this.distanza = distanza;
    }

    public Casello getCaselloIngresso() {
        return caselloIngresso;
    }

    public void setCaselloIngresso(Casello caselloIngresso) {
        this.caselloIngresso = new Casello(caselloIngresso);
    }

    public Casello getCaselloUscita() {
        return caselloUscita;
    }

    public void setCaselloUscita(Casello caselloUscita) {
        this.caselloUscita = new Casello(caselloUscita);
    }

    public int getDistanza() {
        return distanza;
    }

    public void setDistanza(int distanza) {
        this.distanza = distanza;
    }

    @Override
    public String toString() {
        return "TrattoAutostradale{" +
                "caselloIngresso=" + caselloIngresso +
                ", caselloUscita=" + caselloUscita +
                ", distanza=" + distanza +
                '}';
    }

    public double velocitaMedia(){
        double velocitaMedia = 0;
        long nMilliSecUscita1970 =
                caselloUscita.getDataUscita().getTimeInMillis();
        long nMilliSecIngresso1970 =
                caselloIngresso.getDataEntrata().getTimeInMillis();

        velocitaMedia = (nMilliSecUscita1970 - nMilliSecIngresso1970 )
                            / ( distanza * 1000) ;
        return velocitaMedia;
    }

    public static void main(String[] args) {
        Casello caselloIngresso = new Casello();
        Calendar cDataIngresso = InputOutputUtility
                .leggiDataOraCalendar
                        ("Inserisci data ingresso (dd/MM/yyyy HH:mm:ss): ",
                         InputOutputUtility.dfDayHour);
        caselloIngresso.setDataEntrata(cDataIngresso);

        Casello caselloUscita = new Casello();
        Calendar cDataUscita = InputOutputUtility
                .leggiDataOraCalendar
                        ("Inserisci data uscita (dd/MM/yyyy HH:mm:ss): ",
                                InputOutputUtility.dfDayHour);
        caselloUscita.setDataUscita(cDataUscita);

        //public TrattoAutostradale(Casello caselloIngresso, Casello caselloUscita, int distanza) {
        TrattoAutostradale trattoAutostradale = new TrattoAutostradale(
                caselloIngresso, caselloUscita, 10);
        double velocitaMedia = trattoAutostradale.velocitaMedia();
        System.out.println("velocitaMedia: "+velocitaMedia);



    }


}
