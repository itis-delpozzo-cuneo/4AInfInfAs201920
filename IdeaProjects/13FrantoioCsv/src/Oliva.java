import java.util.Calendar;
import java.util.StringTokenizer;

/**
 * Created by d.claudio.borgogno on 23/11/2019.
 */
public class Oliva {

    private String codiceOliva;
    private ColoreOliva coloreOliva;
    private MaturazioneOliva maturazioneOliva;
    private Calendar dataRaccolta;

    public Oliva() { super(); }
    public Oliva(String codiceOliva, ColoreOliva coloreOliva, MaturazioneOliva maturazioneOliva, Calendar dataRaccolta) {
        this.codiceOliva = codiceOliva;
        this.coloreOliva = coloreOliva;
        this.maturazioneOliva = maturazioneOliva;
        this.dataRaccolta = dataRaccolta;
    }

    public void setCodiceOliva(String codiceOliva) {this.codiceOliva = codiceOliva;}
    public void setColoreOliva(ColoreOliva coloreOliva) {this.coloreOliva = coloreOliva;}
    public void setMaturazioneOliva(MaturazioneOliva maturazioneOliva) {this.maturazioneOliva = maturazioneOliva;}
    public void setDataRaccolta(Calendar dataRaccolta) {this.dataRaccolta = dataRaccolta;}
    public String getCodiceOliva() {return codiceOliva;}
    public ColoreOliva getColoreOliva() {return coloreOliva;}
    public MaturazioneOliva getMaturazioneOliva() {return maturazioneOliva;}
    public Calendar getDataRaccolta() {return dataRaccolta;}

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Oliva oliva = (Oliva) o;

        if (codiceOliva != null ? !codiceOliva.equals(oliva.codiceOliva) : oliva.codiceOliva != null) return false;
        if (coloreOliva != oliva.coloreOliva) return false;
        if (maturazioneOliva != oliva.maturazioneOliva) return false;
        return dataRaccolta != null ? dataRaccolta.equals(oliva.dataRaccolta) : oliva.dataRaccolta == null;

    }

    @Override
    public String toString() {
        return "Oliva{" +
                "codiceOliva='" + codiceOliva + '\'' +
                ", coloreOliva=" + coloreOliva +
                ", maturazioneOliva=" + maturazioneOliva +
                ", dataRaccolta=" + InputOutputUtility.convertDataOra(
                this.dataRaccolta, InputOutputUtility.dfDayHour) + "\n" +
                '}';
    }

    public void caricaDaCsv(String linea) {
        StringTokenizer st =
            new StringTokenizer(linea, FrantorioCsv.SEPARATOR);

        int cntCampi=0;
        while (st.hasMoreElements()){
            //linea contiene un formato riga csv, così definito:
            // 0:codiceOliva, 1:coloreOliva, 2:maturazioneOliva, 3:dataRaccolta
            String campoCsv = (String) st.nextElement();

            switch (cntCampi){
                case 0: codiceOliva = campoCsv;
                        break;
                case 1:
                    if(campoCsv.equalsIgnoreCase("1")){
                        coloreOliva = ColoreOliva.VERDE;
                    }
                    if(campoCsv.equalsIgnoreCase("2")){
                        coloreOliva = ColoreOliva.NERO;
                    }
                    if(campoCsv.equalsIgnoreCase("3")){
                        coloreOliva = ColoreOliva.MARRONE;
                    }
                    break;
                case 2:
                    int tipoMaturazione = new Integer(campoCsv).intValue();
                    switch (tipoMaturazione){
                        case 1:
                            maturazioneOliva = MaturazioneOliva.PICCOLA;
                            break;
                        case 2:
                            maturazioneOliva = MaturazioneOliva.ACERBA;
                            break;
                        case 3:
                            maturazioneOliva = MaturazioneOliva.MATURA;
                            break;
                        case 4:
                            maturazioneOliva = MaturazioneOliva.MARCITURA;
                            break;
                    }
                    break;
                case 3:
                    dataRaccolta = InputOutputUtility.convertiDataOraToCalendar(
                            campoCsv, InputOutputUtility.dfDayHour
                    );
                    break;
            }


            cntCampi++;
        }
    }

    public String generaRigaCsv() {
        /*return
                this.codiceOliva + FrantorioCsv.SEPARATOR +
                this.coloreOliva + FrantorioCsv.SEPARATOR +
                this.maturazioneOliva + FrantorioCsv.SEPARATOR +
                InputOutputUtility.convertDataOra(
                        this.dataRaccolta, InputOutputUtility.dfDayHour);*/

        String rigaCsv="";
        int iColoreOliva=-1;
        int iMaturazioneOliva=-1;

        switch (this.coloreOliva){
            case VERDE: iColoreOliva=0;
                        break;
            case NERO: iColoreOliva=1;
                          break;
            case MARRONE: iColoreOliva=2;
                       break;
        }

        switch (this.maturazioneOliva){
            case PICCOLA: iMaturazioneOliva=0;
                break;
            case ACERBA: iMaturazioneOliva=1;
                break;
            case MATURA: iMaturazioneOliva=2;
                break;
            case MARCITURA: iMaturazioneOliva=3;
                break;
        }
        rigaCsv =   this.codiceOliva + FrantorioCsv.SEPARATOR +
                    iColoreOliva + FrantorioCsv.SEPARATOR +
                    iMaturazioneOliva + FrantorioCsv.SEPARATOR +
                    //this.dataRaccolta.getTime() + "\n";
                    InputOutputUtility.convertDataOra(
                            this.dataRaccolta, InputOutputUtility.dfDayHour) + "\n";
        return rigaCsv;
    }
}
