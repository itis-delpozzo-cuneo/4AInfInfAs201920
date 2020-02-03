import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileTesto {

	//Da Modificare
	public final static String PATH_FILE="C:\\Users\\d.claudio.borgogno\\32LetturaFileDiTesto\\";

	private ArrayList<String> aRighe;
	private String nomeFile;

	public FileTesto(String nomeFile)
	{
		aRighe= new  ArrayList<String>();
		this.nomeFile =nomeFile;
	}

	public ArrayList<String> leggiFile() throws IOException
	{
		String riga;
		File file = new File(PATH_FILE + nomeFile);
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);

		try {
			while( (riga = br.readLine()) != null)
			{
				aRighe.add(riga);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// file.deleteOnExit();
		return aRighe;
	}

	public void stampa()
	{
		for(int i=0;i<aRighe.size();i++)
		{
			System.out.println(aRighe.get(i).toString());
		}
	}
	
	public int scriviFile() throws IOException
	{
		String fileLetto;
		String riga;
		int risultato=1;
		
		File file = new File(PATH_FILE + nomeFile);
		FileWriter fw = null;
		
		try {
			fw= new FileWriter(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			risultato=0;
			e1.printStackTrace();
		}
		BufferedWriter bw = new BufferedWriter(fw);

		for(int i=0;i<aRighe.size();i++)
		{
			try {
				bw.write(aRighe.get(i));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				risultato=0;
				e.printStackTrace();
			}
		}
		bw.close();
		fw.close();
		
		return  risultato;
	}
	
	public void simula()
	{
			aRighe.add("domani piove ");	
			aRighe.add("domani nevica ");
			aRighe.add("stai dormendo!!");
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("leggi file 1\t");
		FileTesto ts = new FileTesto("leggi.txt");
		ts.leggiFile();
		ts.stampa();

		System.out.println("scrivi file 2: \t");
		FileTesto ts1= new FileTesto("scritto.txt");
		ts1.simula();
		ts1.scriviFile();		
		ts1.stampa();
		System.out.println("leggi file 2: \t");
		FileTesto ts2 = new FileTesto("scritto.txt");
		ts1.leggiFile();
		ts1.stampa();
	}

}
