package it.itis.cuneo;

/**
 * Created by d.claudio.borgogno on 21/12/2019.
 */
public class Fornaio implements Pasticcere, RivenditaAlimentari {

    private boolean isFornoConFuocoAcceso;


    @Override
    public void accendiForno() {

        isFornoConFuocoAcceso = true;

    }

    @Override
    public void riempiMagazzino() {

    }
}
