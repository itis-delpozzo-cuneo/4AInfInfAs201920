package it.itis.cuneo;

/**
 * Created by d.claudio.borgogno on 30/09/2019.
 */
public class EseguiConversioni {

    //esempio di conversione tra wrapper, partendo da un primitivo
    public static void main(String[] args){
        //float: è un tipo primitivo, cioè una variabile semplice
        //Float: è una classe wrapper, contiene un primitivo dello stesso tipo
        //       ed i metodi che ne permettono l'elaborazione
        Float f;
        f = new Float(0.52d);
        //System.out.println(String s)
        //La firma del metodo sopra richiede una stringa come parametro
        // quindi il float viene convertito in una stringa al momento della chiamata
        // System.out.println(float fPrimitivo)
        // nel caso della firma sopra passiamo un Float wrapper
        // ma il metodo si aspetta un metodo primitivo
        System.out.println(f);


        int n;
        String quanteMele = "8";
        n = Integer.parseInt("6");
        System.out.println(n);

        Float ogF;
        ogF = new Float(n);
        String s2;
        s2 = "" + ogF;
        System.out.println("s2 = \"\" + ogF: " + s2);
        s2 = new String("" + ogF);
        System.out.println( "s2 = new String(\"\" + ogF): " + s2);
        s2 = ogF.toString();
        System.out.println("s2 = ogF.toString(): " + s2);

        // double -> Integer
        double dN = 6.5d;   //la d serve per definire il tipo della costante
        int intN = (int) dN; //intN = 6
        Integer iN = new Integer(intN);
        iN = intN;      //wrapper = primitivoDelloStessoTipo











    }
}
