import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by d.claudio.borgogno on 04/11/2019.
 */
public class Calendario {

    public Calendario() {
    }

    public static void main(String[] args) {
        System.out.println("oggi1: " + new Date());

        Date dOggi = new Date();
        System.out.println("oggi2: " + dOggi);

        String strData = InputOutputUtility
                .leggiNome("Inserisci la data (dd/mm/yyyy): ");

        //strData -> dataTastiera (String -> Date in che formato)
        /*Date dataTastiera = InputOutputUtility
                .convertiDataOraToCalendar(strData,
                        InputOutputUtility.dfDay );*/

        Date dataTastiera = null;
        try {
            dataTastiera = InputOutputUtility.dfDay.parse(strData);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar cData = Calendar.getInstance();
        cData.setTime( dataTastiera );

        //strData -> calendar (String -> Calendar in che formato)
        Calendar cData2 = InputOutputUtility
                .convertiDataOraToCalendar(strData,
                        InputOutputUtility.dfDay );
    }
}
