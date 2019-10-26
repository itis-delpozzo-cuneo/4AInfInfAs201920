package it.itis.cuneo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by d.claudio.borgogno on 21/10/2019.
 */
public class Casello {

    //attributi
    //Calendar ha anche ore, minuti e secondi
    //rispetto alla Date(java.util.Date)
    private String identifier;
    private Calendar dataEntrata;
    private Calendar dataUscita;

    //metodi
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setDataEntrata(Calendar dataEntrata) {
        this.dataEntrata = dataEntrata;
    }

    public Calendar getDataEntrata() {
        return this.dataEntrata;
    }

    public void setDataUscita(Calendar dataUscita) {
        this.dataUscita = dataUscita;
    }

    public Calendar getDataUscita() {
        return this.dataUscita;
    }

    public Casello() {
    }

    public Casello(String identifier, Calendar dataEntrata, Calendar dataUscita) {
        this.identifier = identifier;
        this.dataEntrata = dataEntrata;
        this.dataUscita = dataUscita;
    }

    public Casello(Casello casello) {
        this.identifier = new String(casello.getIdentifier());

        //Calendar.getInstance(); method factory
        //L'istanza creata, ha come default i secs di 01/01/1970
        //Calendar cData = new Calendar(); non è accessibile
        Calendar cDataEntrata = Calendar.getInstance();
        cDataEntrata.setTime(casello.getDataEntrata().getTime());
        this.dataEntrata = cDataEntrata;

        Calendar cDataUscita = Calendar.getInstance();
        cDataUscita.setTime(casello.getDataUscita().getTime());
        this.dataUscita = cDataUscita;
    }

    public static void main(String[] args){
        //cast Stringa -> Data (SimpleDateFormat)
        //es.          23/10/2019 09:25:43
        //pattern      dd/MM/yyyy hh24:mm:ss
        //pattern: stringa che contiene un formato
        //          della data di input,
        //          rappresentato in una stringa

        //final String FORMATO_DMY_HMS = "dd/MM/yyyy hh24:mm:ss";
        final String FORMATO_DMY_HMS = "dd/MM/yyyy HH:mm:ss";

        String strDataPartenza = "29/08/2002 13:30:40";
        Calendar cDataEntrata = Calendar.getInstance();

        SimpleDateFormat sdfHH = new SimpleDateFormat(FORMATO_DMY_HMS);
        //parsificare una stringa secondo un formato, permette di ottenere
        // una variabile di altro tipo
        //Eccezione: anomalia software che si verifica quando il codice
        // genera un errore in tempo di esecuzione
        // ParseException: la stringa non rispetta il formato atteso
        Date dataPartenza=null;
        try {
            dataPartenza = sdfHH.parse(strDataPartenza);
        } catch (ParseException e) {
            //Errore nel formato della stringa
            //Viene stampato uno stackTrace: una traccia dello stack
            // è l'elenco delle chiamate ai metodi
            e.printStackTrace();
        }

        //Calendar mantiene il numero di secondi dal 01/01/1970
        cDataEntrata.setTime(dataPartenza);

        System.out.println("cDataEntrata: "+cDataEntrata);

        //Formattare la data in output
        // SimpleDateFormat.format(Date)
        String strData = sdfHH.format(dataPartenza);
        System.out.println("\n\nsdfHH.format(dataPartenza): "+ strData);

        //Casello casello1 = new Casello("1", 0);
    }

}
