package it.itis.cuneo;

/**
 * Created by d.claudio.borgogno on 07/10/2019.
 */
public class Segmento {

    //attributi
    private Punto punto1;
    private Punto punto2;

    //metodi
    /*public Segmento (Punto punto1, Punto punto2){
        this.punto1 = punto1;
        this.punto2 = punto2;
    }*/

    public Segmento (Punto punto1, Punto punto2){
        this.punto1 = new Punto(punto1.getX(), punto1.getY());
        this.punto2 = new Punto(punto2.getX(), punto2.getY());
    }

    //è identico a quello superiore
    /*public Segmento (Punto punto1, Punto punto2){
        this.punto1 = new Punto(punto1);
        this.punto2 = new Punto(punto2);
    }*/

    public Segmento (Segmento segmento){
        this.punto1 = new Punto(segmento.getPunto1());
        this.punto2 = new Punto(segmento.getPunto2());
    }

    public void setPunto1(Punto punto1) {
        this.punto1 = new Punto(punto1);
    }

    public Punto getPunto1() {
        return this.punto1;
    }

    public void setPunto2(Punto punto2) {
        this.punto2 = new Punto(punto2);
        //this.punto2 = punto2; //in questo caso se dereferenzio il parametro perdo
        //this.punto2 = new Punto(punto2.getX(), punto2.getY()); //equivale a quello precedente
    }

    public Punto getPunto2() {
        return this.punto2;
    }


}
