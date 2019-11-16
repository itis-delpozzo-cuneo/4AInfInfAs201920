import java.util.Arrays;

/**
 * Created by d.claudio.borgogno on 13/11/2019.
 */
public class Archivio {
    public static final int MAX_PROGRAMMI = 10;
    private int cntProgrammi;
    private Programma[] vProgrammi;
    private int nProgrammi;

    //UML: relazione 1->n tra Archivio e Programma
    public Archivio(){
        vProgrammi = new Programma[MAX_PROGRAMMI];
        nProgrammi = MAX_PROGRAMMI;
        cntProgrammi = 0;
    }

    //UML: relazione 1->n tra Archivio e Programma
    public Archivio(int nProgrammi)
        throws ArchivioPienoException{
        if(nProgrammi>MAX_PROGRAMMI){
            throw new
              ArchivioPienoException(1, "Limite massimo superato");
        }
        vProgrammi = new Programma[nProgrammi];
        this.nProgrammi = nProgrammi;
        cntProgrammi = 0;
    }

    public Programma getProgramma(int posizione){
        Programma programma = null;
        if(posizione>0 && posizione<nProgrammi)
            programma = this.vProgrammi[posizione];
        return programma;
    }

    //esito<0 -> l'operazione non ha avuto successo
    public int setProgramma(Programma programma, int posizione){
        int esito=0;
        if(posizione>0 && posizione<nProgrammi){
            //Se sto cercando di inserire in una posizione piena
            if(this.vProgrammi[posizione]==null) {
                //Se sto aggiungendo in una posizione vuota
                //if (this.vProgrammi[posizione] == null)
                this.cntProgrammi++;
                this.vProgrammi[posizione] = programma;
                esito = posizione;
            }
            else{
                esito = -2;
            }
        }
        else{
            //Non sono riuscito a inserire
            esito=-1;
        }
        return esito;
    }

    public void killProgramma(int posizione){
        if(posizione>0 && posizione<nProgrammi){
            this.vProgrammi[posizione] = null;
            this.cntProgrammi--;
        }
    }

    public int getN(){
        return this.nProgrammi;
    }

    public Programma cercaProgrammaPerDenominazione
            (String denominazione){
        Programma programma = null;
        boolean bTrovato = false;

        for(int cntProgramma=0;
                cntProgramma<this.nProgrammi && !bTrovato;
                cntProgramma++)
        {
            programma = this.vProgrammi[cntProgramma];
            if(programma!=null &&
              denominazione.equalsIgnoreCase(programma.getDenominazione())){
                bTrovato = true;
            }
        }

        return programma;
    }

    //Override: sovrascrittura di un altro metodo con la stessa
    // firma, nella classe base java.lang.Object
    //Quindi esiste già un metodo con la stessa firma,
    // presente nella classe base
    @Override
    public String toString() {
        return "Archivio{" +
                "cntProgrammi=" + cntProgrammi +
                ", vProgrammi=" + Arrays.toString(vProgrammi) +
                ", nProgrammi=" + nProgrammi +
                '}';
    }

    public boolean equals(Archivio archivio){
        boolean bUguali=true;

        if(this.nProgrammi == archivio.getN()) {
            for (int cntProgramma = 0;
                 cntProgramma < this.nProgrammi && bUguali;
                 cntProgramma++) {
                Programma programmaInterno = this.getProgramma(cntProgramma);
                Programma programmaEsterno = archivio.getProgramma(cntProgramma);
                //No programmaInterno == programmaEsterno -> si confrontano handlers
                if(! programmaInterno.equals( programmaEsterno )){
                    bUguali=false;
                }
            }
        }
        else{
            //Se la dimensione definita per gli archivi è diversa
            bUguali=false;
        }

        return bUguali;
    }

    public int contaProgrammiUguali(Archivio archivio){
        int cntUguali = 0;

        for (int cProgramma = 0; cProgramma < this.nProgrammi; cProgramma++) {
            Programma programmaInterno = this.getProgramma(cProgramma);
            Programma programmaEsterno = archivio.getProgramma(cProgramma);
            if (programmaInterno.equals(programmaEsterno)) {
                cntUguali++;
            }
        }

        return cntUguali;
    }

    public int contaProgrammiUgualiIncrociati(Archivio archivio){
        int cntUgualiIncrociati = 0;
        boolean bUgualeTrovato=false;

        for(int contaProgrammiInterni=0;
            contaProgrammiInterni<MAX_PROGRAMMI;
            contaProgrammiInterni++)
        {
            bUgualeTrovato=false;
            for(int contaProgrammiEsterni=0;
                contaProgrammiEsterni<archivio.getN() && !bUgualeTrovato;
                contaProgrammiEsterni++)
            {
                if(vProgrammi[contaProgrammiInterni].
                        equals(archivio.vProgrammi[contaProgrammiEsterni]))
                {
                    bUgualeTrovato=true;
                    cntUgualiIncrociati++;
                }
            }
        }

        return cntUgualiIncrociati;
    }

    public void caricaArchivio(){
        this.nProgrammi = InputOutputUtility.leggiNumero("Quanti programmi per l'archivio: ");

        for(cntProgrammi=0; cntProgrammi<nProgrammi; cntProgrammi++){
            Programma programma = new Programma();
            System.out.println("\nInserisci il programma "
                    + cntProgrammi + " .... ");
            programma.caricaProgramma();
            this.setProgramma(programma, cntProgrammi);
        }
    }

    public void stampaMenu(){
        String menu="\n\n\t0: esci\n"+
                "\t1: carica archivio\n"+
                "\t2: elimina programma\n"+
                "\t3: ricerca programma per denominazione\n"+
                "\t4: stampa archivio";

        System.out.println(menu);
    }

    //public Programma(int codice, String denominazione,
    // String produttore, String sistemaOperativo,
    // int versione, int annoCreazione)
    public void simulaArchivio(){
        Programma programma1 =
                new Programma(1, "Office", "Microsoft",
                        "Windows", 10, 2010 );
        this.setProgramma(programma1, 0);

        Programma programma2 =
                new Programma(2, "Autocad", "Autodesk",
                        "Linux", 10, 2010 );
        this.setProgramma(programma2, 1);
    }

    public static void main(String[] args) {
        Archivio archivio = new Archivio();
        boolean bEsci = false;
        int sceltaMenu=-1;

        while(!bEsci){
            archivio.stampaMenu();
            sceltaMenu = InputOutputUtility.
                    leggiNumero("Inscrisci la scelta: ");
            switch (sceltaMenu){
                case 0: bEsci=true;
                        break;
                case 1: archivio.caricaArchivio();
                        break;
                case 2: int posDeleteProgr =
                            InputOutputUtility.leggiNumero(
                            "Inserisci la posizione da cancellare: ");
                        archivio.killProgramma(posDeleteProgr);
                        break;
                case 3: String denominazione =
                            InputOutputUtility.leggiNome("Inserisci denominazione: ");
                        Programma programma = archivio.
                                cercaProgrammaPerDenominazione(denominazione);
                        System.out.println(programma);
                        break;
                case 4:
                        System.out.println(archivio.toString());
                        break;
                case 99: archivio.simulaArchivio();
                         break;
            }
        }

    }

}
