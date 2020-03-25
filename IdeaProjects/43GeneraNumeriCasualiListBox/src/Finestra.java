import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class Finestra extends  JFrame implements  ActionListener, ListSelectionListener {
//jcombo provare  jcombo comboListModel
	JLabel numMax;
	JLabel numMin;
	JTextField tNumMax;
	JTextField tNumMin;
	JButton inserisci;
	JLabel lblEr; 
	JList listaDiNumeri;
	DefaultListModel listModel;
	
	JComboBox comboDiNumeri;
	DefaultComboBoxModel comboBoxModel;
	
	ArrayList<Numero> aNumeri;

	String[] sNumbers;
	int min;
	int max;
	int cntVolte=0;
	
	public Finestra()
	{
	 aNumeri= new ArrayList<Numero>();
	 //setSize(200,300);
	 setTitle("finestra Numeri Casuali");
	 initComponent();
	 pack();
	 setVisible(true);
	 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	 genera();
	 cntVolte=0;
	}

	private void initComponent() {
		// TODO Auto-generated method stub
		setLayout( new FlowLayout());
		
		numMin= new JLabel("numero minimo: ");
	    this.add(numMin);
	    tNumMin= new JTextField(20);
		this.add(tNumMin);	
		
		numMax= new JLabel("numero massimo: ");
	    this.add(numMax);
	    tNumMax= new JTextField(20);
		this.add(tNumMax);
	
		listaDiNumeri= new JList();
		this.add(listaDiNumeri);
		
		inserisci= new JButton("inserisci");
		this.add(inserisci);
		inserisci.addActionListener(this);
		
		lblEr = new JLabel();
		this.add(lblEr);
		
		listModel = new DefaultListModel();
		listModel.addElement("-1");
		listModel.addElement("0");
		listaDiNumeri= new JList(listModel);
		JScrollPane jsp = new JScrollPane(listaDiNumeri);
		this.add(jsp);
		
		comboBoxModel = new DefaultComboBoxModel();
		comboBoxModel.addElement("-2");
		comboBoxModel.addElement("0");
		JComboBox comboDiNumeri = new JComboBox(comboBoxModel);
		JScrollPane jsp2 = new JScrollPane(comboDiNumeri);
		this.add(jsp2);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent ar) {
		// TODO Auto-generated method stub
		if(ar.getSource().equals(inserisci))
		{
			if((!tNumMin.getText().equalsIgnoreCase(""))
				&&(!tNumMax.getText().equalsIgnoreCase("")))
			{
				lblEr.setText("");
				System.err.println(tNumMin.getText());
				System.err.println(tNumMax.getText());
				min=new Integer(tNumMin.getText().trim()).intValue();
				max=new Integer(tNumMax.getText().trim()).intValue();
				sNumbers= genera();
				
				
				//listaDiNumeri= new JList(sNumbers);
				listModel.removeAllElements();
				for(String sNumber : sNumbers){
					listModel.addElement(sNumber);
				}

				comboBoxModel.removeAllElements();
				for(String sNumber : sNumbers){
					comboBoxModel.addElement(sNumber);
				}
			}else
			{
				//System.out.println("inserisci i due numeri!!");
				lblEr.setText("Inserisci i due numeri!!");
			}
		}
	}
	
	public String[] genera()
	{
		boolean findRepeated;
		String[] vNum = new String[max-min+1];
		for(int i=0;i<vNum.length;i++)
		{
			do{
				vNum[i]=""+Math.round((Math.random()*(max-min))+min);
				findRepeated=false;
				for(int j=0; j<i && !findRepeated;j++){
					if(vNum[j].equalsIgnoreCase(vNum[i]))
						findRepeated=true;
				}
			}while(findRepeated);
			//System.err.println(vNum[i]);
		}
		return  vNum;
	}
	public static void main(String[]args)
	{
		Finestra fs = new Finestra();
		fs.genera();
	}

	@Override
	public void valueChanged(ListSelectionEvent le) {
		// TODO Auto-generated method stub
		
	}
}
