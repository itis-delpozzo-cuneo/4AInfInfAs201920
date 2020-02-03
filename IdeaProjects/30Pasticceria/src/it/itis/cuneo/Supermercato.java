package it.itis.cuneo;

/**
 * Created by d.claudio.borgogno on 21/12/2019.
 */
public class Supermercato implements Pasticcere, RivenditaAlimentari {

    private int gradiFornoConElettricita;


    @Override
    public void accendiForno() {


        this.gradiFornoConElettricita = 180;

    }

    @Override
    public void riempiMagazzino() {

    }
}
