package it.itis.cuneo;

/**
 * Created by d.claudio.borgogno on 07/10/2019.
 */
public class Punto {

    //attributi
    private int x;
    private int y;

    //metodi
    public Punto(){
        super();
    }

    public Punto (int x, int y){
        this.x = x;
        this.y = y;
    }

    public Punto (Punto p){
        x = p.getX();
        y = p.getY();
    }

    public void setX(int x){
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public String toString(){
        return "Punto{ \"x\": " + x + ", " +
                " \"y\": " + y + "}";
    }

    public static void main(String[] args){
        //puntoA e puntoB referenziano due aree
        // di memoria diverse
        Punto puntoA = new Punto(4, 6);
        //puntoB è una copia di puntoA
        // per il suo stato, ma fisicamente sono
        // in due aree di memoria diverse
        Punto puntoB = new Punto(puntoA);

        //puntoC e puntoA come handler referenziano
        // la stessa area di memoria
        Punto puntoC = puntoA;

        Punto puntoD = new Punto();

        Punto puntoE = null;
        //se il richiamo al costruttore
        // non viene svolto ho un null pointer
        puntoE = new Punto();

        System.out.println(puntoE.toString());
    }
}
