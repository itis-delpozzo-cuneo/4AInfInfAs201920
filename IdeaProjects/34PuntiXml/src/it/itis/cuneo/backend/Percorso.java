package it.itis.cuneo.backend;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Percorso {

    //Da modificare con il percorso ed il nome del file
	public static final String FILE_NAME = "F:\\4AInf\\IdeaProjects\\34PuntiXml\\src\\punti2.xml";
	private List<Punto> percorso; 

	public Percorso() {
		super();
		percorso = new ArrayList<Punto>();
	}

	public void addPunto(Punto punto){
	    this.addPunto(punto);
    }

	public List<Punto> getPercorso() {
		return percorso;
	}

	@XmlElement
	public void setPercorso(List<Punto> percorso) {
        this.percorso = percorso;
    }

    @Override
	public String toString() {
		return "Percorso [percorso=" + percorso + "]";
	}

	public String toXml() {
        String xml="";
        for(Punto punto : this.percorso){
            xml += punto.toXml();
        }
        xml = "<percorso>\n" + xml + "</percorso>";
        return xml;
    }

    public void scriviXml(){
        BufferedWriter bw = null;
        try {
            simulaPercorso();
            bw = new BufferedWriter(new FileWriter(FILE_NAME));
            bw.write(this.toXml());
            System.out.println(this.toXml());
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	
    //https://www.mkyong.com/java/jaxb-hello-world-example/
    public void marshallingXml(){
        try {
            File file = new File(Percorso.FILE_NAME);
            JAXBContext jaxbContext = JAXBContext.newInstance(Percorso.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(this, file);
            jaxbMarshaller.marshal(this, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    public void unmarshallingXml() {
        try {
            File file = new File(Percorso.FILE_NAME);
            JAXBContext jaxbContext = JAXBContext.newInstance(Percorso.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Percorso percorso = (Percorso) jaxbUnmarshaller.unmarshal(file);
            System.out.println(percorso);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }


    private void simulaPercorso() {
        Percorso percorso = new Percorso();
        Punto punto1 = new Punto("p1", 100, 100);
        percorso.addPunto(punto1);
        Punto punto2 = new Punto("p2", 200, 400);
        percorso.addPunto(punto2);
        Punto punto3 = new Punto("p3", 300, 800);
        percorso.addPunto(punto3);
        Punto punto4 = new Punto("p4", 400, 1400);
        percorso.addPunto(punto4);

    }

    public static void main(String[] args) {
        Percorso percorso = new Percorso();

        percorso.simulaPercorso();
        //Metodo di scrittura basato sulle api dei file di testo già conosciuti
        percorso.scriviXml();
        //Metodo di scrittura basato su jaxb
        percorso.marshallingXml();

        //Metodo di lettura e parser basato su jaxb
        //percorso.unmarshallingXml();
    }

	public void caricaTabella(DefaultTableModel tableModelPunti) {
		for(Punto punto: this.percorso) {
			tableModelPunti.addRow(new Object[] {punto.getNome(), punto.getCordx(), punto.getCordy() });
		}
	}

}
