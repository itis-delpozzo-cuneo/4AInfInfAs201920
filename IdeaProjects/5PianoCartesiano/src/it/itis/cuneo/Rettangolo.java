package it.itis.cuneo;

/**
 * Created by d.claudio.borgogno on 07/10/2019.
 */
public class Rettangolo {

    //attributi
    private Segmento segmentoAlto;
    private Segmento segmentoDestro;
    private Segmento segmentoBasso;
    private Segmento segmentoSinistro;

    public Rettangolo(Segmento segmentoAlto, Segmento segmentoBasso, Segmento segmentoDestro, Segmento segmentoSinistro){
        this.segmentoAlto = new Segmento(segmentoAlto);
        this.segmentoBasso = new Segmento(segmentoBasso);
        this.segmentoDestro = new Segmento(segmentoDestro);
        this.segmentoSinistro = new Segmento(segmentoSinistro);
    }

    public Rettangolo(Rettangolo rettangolo){
        this.segmentoAlto = new Segmento( rettangolo.getSegmentoAlto());
        segmentoBasso = new Segmento( rettangolo.getSegmentoBasso());
        segmentoDestro = new Segmento( rettangolo.getSegmentoDestro());
        segmentoSinistro = new Segmento( rettangolo.getSegmentoSinistro());
    }

    public void setSegmentoAlto(Segmento segmentoAlto){
        this.segmentoAlto = segmentoAlto;
    }

    public Segmento getSegmentoAlto(){
        return segmentoAlto;
    }

    public void setSegmentoBasso(Segmento segmentoBasso){
        this.segmentoBasso = segmentoBasso;
    }

    public Segmento getSegmentoBasso(){
        return segmentoBasso;
    }

    public void setSegmentoSinistro(Segmento segmentoSinistro){
        this.segmentoSinistro = segmentoSinistro;
    }

    public Segmento getSegmentoSinistro(){
        return segmentoSinistro;
    }

    public void setSegmentoDestro(Segmento segmentoDestro){
        this.segmentoDestro = segmentoDestro;
    }

    public Segmento getSegmentoDestro(){
        return segmentoDestro;
    }

    public String toString()
    {
        return "{Segmenti --> \"segmentoAlto\":" + segmentoAlto + "," + "\"segmentoDestro\" "
                + segmentoDestro + "," + "\"segmentoSinistro\"" + segmentoSinistro +"," +
                "\"segmentoBasso\"" + segmentoBasso + "}";
    }

}
