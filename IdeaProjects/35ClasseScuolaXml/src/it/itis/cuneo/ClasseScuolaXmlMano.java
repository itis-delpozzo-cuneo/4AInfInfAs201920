package it.itis.cuneo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by d.claudio.borgogno on 30/01/2020.
 */
@XmlRootElement (name = "classescuola")
public class ClasseScuolaXmlMano {
    public static final String PATH_FILE =
            "C:\\Users\\d.claudio.borgogno\\IdeaProjects\\"+
            "35ClasseScuolaXml\\xml\\classe.xml";

    private String name;
    private List<Allievo> lAllievo;
    //private ArrayList<Allievo> lAllievo;

    //Jaxb VUOLE SEMPRE i costruttori vuoti!!
    public ClasseScuolaXmlMano(){
        this.name="";
        this.lAllievo = new ArrayList<Allievo>();
    }

    public void addAllievo(Allievo allievo){
        this.lAllievo.add(allievo);
    }

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public List<Allievo> getlAllievo() {
        return lAllievo;
    }

    //@XmlElement(name="allievo")
    @XmlElement (name = "allievo")
    public void setlAllievo(List<Allievo> lAllievo) {
        this.lAllievo = lAllievo;
    }

    public void unMarshallXml(){
        try {
            File file = new File(PATH_FILE);
            JAXBContext jaxbContext =
                    JAXBContext.newInstance(ClasseScuolaXmlMano.class);

            Unmarshaller jaxbUnmarshaller =
                    jaxbContext.createUnmarshaller();
                    //jaxbContext.createMarshaller();
            ClasseScuolaXmlMano classeScuola = (ClasseScuolaXmlMano)
                    jaxbUnmarshaller.unmarshal(file);

            System.out.println(classeScuola.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public void marshallXml(){
        File file = new File(PATH_FILE);
        try {
            JAXBContext jaxbContext =
                    JAXBContext.newInstance(ClasseScuolaXmlMano.class);
            Marshaller jaxbMarshaller =
                    jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(
                    Marshaller.JAXB_FORMATTED_OUTPUT, true);
            //this: è il riferimento alla classe attuale
            // è un istanza di ClasseScuola.class
            jaxbMarshaller.marshal(this, file);
            jaxbMarshaller.marshal(this, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "ClasseScuola{" +
                "name='" + name + '\'' +
                ", lAllievo=" + lAllievo +
                '}';
    }

    public void simula(){
        //public Allievo(String cognome, String nome,
        // String votoInformatica, String votoMatematica,
        // String votoStoria)
        this.setName("4A-inf");
        Allievo allievo1 = new Allievo("Rossi", "Mario", "6", "7", "6");
        this.addAllievo(allievo1);
        Allievo allievo2 = new Allievo("Meria", "Luigi", "8", "7", "8");
        this.addAllievo(allievo2);
        Allievo allievo3 = new Allievo("Romani", "Marta", "8", "6", "5");
        this.addAllievo(allievo3);
        Allievo allievo4 = new Allievo("Sarti", "Laura", "5", "5", "6");
        this.addAllievo(allievo4);
    }

    public static void main(String[] args) {
        ClasseScuolaXmlMano classeScuola = new ClasseScuolaXmlMano();
        //classeScuola.unMarshallXml();

        classeScuola.simula();
        classeScuola.marshallXml();
    }

}
