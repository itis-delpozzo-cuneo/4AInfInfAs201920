package it.itis.cuneo;

/**
 * Created by d.claudio.borgogno on 21/09/2019.
 */
public class Numero {
    //Attributi
    private int valore;

    //Metodi
    public Numero(int valore){
        this.valore = valore;
    }

    public void setValore(int valore){
        this.valore = valore;
    }

    public int getValore(){
        return this.valore; //meglio esplicito che implicito
    }

    //come se fosse esterno
    public static void main(String args[]){
        int x;
        Numero numero = new Numero(5);
        x = numero.getValore();
        System.out.println(x);
    }


}
