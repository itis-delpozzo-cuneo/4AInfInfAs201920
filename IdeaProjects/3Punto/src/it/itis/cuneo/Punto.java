package it.itis.cuneo;
import java.lang.Math;

public class Punto {

    // Attributi
    private int x;
    private int y;

    // Metodi
    public Punto() {

    }

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int newX) {
        this.x = newX;
    }

    public int getX() {
        return this.x;
    }

    public void setY(int newY) {
        this.y = newY;
    }

    public int getY() {
        return this.y;
    }

    public int getQuadrante() {
        int res = 4;

        if(this.x > 0 && this.y > 0) {
            res = 1;
        } else if(this.x < 0 && this.y > 0) {
            res = 2;
        } else if(this.x < 0 && this.y < 0) {
            res = 3;
        }

        return res;
    }

    public boolean equals(Punto p2) {
        boolean res = false;

        if(this.x == p2.getX() && this.y == p2.getY()) {
            res = true;
        }

        return res;
    }

    public double getDistanza(Punto p2) {
        double res = Math.sqrt((this.x - p2.getX()) * (this.x - p2.getX()) + (this.y - p2.getY()) * (this.y - p2.getY()));

        return res;
    }

    public String toString() {
        return ("{\n\tx:" + this.x + ",\n\ty:" + this.y + "\n\b};");
    }

    public static void main(String[] args) {
        Punto puntoA = new Punto(1, 2);
        Punto puntoB = new Punto(-1, 4);

        System.out.println("PuntoA > " + puntoA);
        System.out.println("PuntoB > " + puntoB);

        System.out.println("Quadrante puntoA > " + puntoA.getQuadrante());
        System.out.println("Quadrante puntoB > " + puntoB.getQuadrante());

        System.out.println("Distanza AB > " + puntoA.getDistanza(puntoB));

        puntoB.setX(1);
        puntoB.setY(2);

        System.out.println("PuntoA > " + puntoA);
        System.out.println("PuntoB > " + puntoB);

        System.out.println("Distanza AB > " + puntoA.getDistanza(puntoB));

        System.out.println("puntoA = puntoB? > " + puntoA.equals(puntoB));
    }
}
