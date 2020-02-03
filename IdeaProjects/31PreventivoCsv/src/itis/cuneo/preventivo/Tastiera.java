package itis.cuneo.preventivo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Tastiera {
	 public static DateFormat dfDayHour = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    public static DateFormat dfDay = new SimpleDateFormat("dd/MM/yyyy");

		private static InputStreamReader r = new InputStreamReader(System.in);
		private static BufferedReader br = new BufferedReader(r);
		
		
		public static String leggiNome(String outStr){
			String sc=null;
			
			System.out.print(outStr);
			try {
				sc=br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sc;
		}
		
		
		public static int leggiNumero(String outStr){
			int s=0;
			
			System.out.print(outStr);
			try {
				s=Integer.parseInt(br.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return s;
		}
		
		

		public static double leggiNumeroDouble(String outStr){
			double s=0;
			
			System.out.print(outStr);
			try {
				s=Double.parseDouble(br.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return s;
		}
		
		
		public static float leggiNumeroFloat(String outStr) {
			float f=0;
			
			System.out.print(outStr);
			try {
				f=Float.parseFloat(br.readLine());
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			return f;
		}
		
		
		public static Date leggiData(String outStr){
		    Date date = null;
		    DateFormat dfDay = new SimpleDateFormat("dd/MM/yyyy");

		    System.out.print(outStr);
		    try {
				date = dfDay.parse(br.readLine());
				//formatteddate = df.format(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		    return date;
		}
		
		
		//Date df = Tastiera.leggiDataOra("06/08/2019 08:34", Tastiera.dfDayHour);
		//Date df = Tastiera.leggiDataOra("06/08/2019", Tastiera.dfDay);
		public static Date leggiDataOra(String outStr, DateFormat df){
		    Date date = null;

		    System.out.print(outStr);
		    try {
				date = df.parse(br.readLine());
				//formatteddate = df.format(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		        
		    return date;
		}

		
		public static Calendar leggiDataOraCalendar(String outStr, DateFormat df){
			Date date = Tastiera.leggiDataOra(outStr, df);

		    Calendar calendar = Calendar. getInstance();
		    calendar. setTime(date);
		        
		    return calendar;
		}
		
			
		//String sDateHour = Tastiera.convertDataOra(thisPuntoAttributoOggetto, Tastiera.dfDayHour); //->"06/08/2019 08:34"
		//String sDate = Tastiera.convertDataOra(thisPuntoAttributoOggetto, Tastiera.dfDay); //->"06/08/2019"
		public static String convertDataOra(Date inDate, DateFormat df){
		    String strDate = df.format(inDate);	        
		    return strDate;
		}
		
		
		public static String convertDataOra(Calendar inCalendar, DateFormat df){
		    String strDate = df.format(inCalendar);	        
		    return strDate;
		}
		
		
		public static Calendar convertiDataOraToCalendar(String inStr, DateFormat df){
			Date date = null;
			try {
				date = df.parse(inStr);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		    Calendar calendar = Calendar. getInstance();
		    calendar. setTime(date);
		        
		    return calendar;
		}	

		
}
