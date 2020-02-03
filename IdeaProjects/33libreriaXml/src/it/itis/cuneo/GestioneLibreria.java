package it.itis.cuneo;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class GestioneLibreria {

	public static void main(String[] args) {
		
		 try {
			 	ElencoLibri elenco = new ElencoLibri();
			 	
			 	Libro l1 = new Libro();
			 	l1.setCodIsbn("5423");
			 	l1.setTitolo("Titolo 1");
			 	l1.setPrezzo(34);
			 	
			 	Libro l2 = new Libro();
			 	l2.setCodIsbn("8742");
			 	l2.setTitolo("Titolo 2");
			 	l2.setPrezzo(19);
			 	
			 	elenco.add(l1);
			 	elenco.add(l2);
			 
				File  file = new File("F:\\4AInf\\IdeaProjects\\33libreriaXmlEclipse\\ElencoLibri.xml");
				JAXBContext jaxbContext = JAXBContext.newInstance(ElencoLibri.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

				jaxbMarshaller.marshal(elenco, file);
				jaxbMarshaller.marshal(elenco, System.out);

			      } catch (JAXBException e) {
				e.printStackTrace();
			      }
		
	}

}
