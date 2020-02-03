package it.itis.cuneo.frontend;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import it.itis.cuneo.backend.Percorso;

public class GraficoGUI extends JFrame implements ActionListener{
	
	private JTable tablePunti;
	private DefaultTableModel tableModelPunti;
	private final String[] headerTablePunti = new String[] {"Nome", "X", "Y"};
	
	private JButton btnDesign;
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem menuRead;
	private JMenuItem menuWrite;
	private JMenuItem menuClose;
	
	public GraficoGUI() {
		super("GraficoPallina");
		initComponents();
		this.setExtendedState(MAXIMIZED_BOTH);
		this.pack();
		this.setVisible(true);
		
	}
	
	public void initComponents(){
		menuBar = new JMenuBar();
		menu = new JMenu ("File");
		menuBar.add(menu);
		
		menuRead = new JMenuItem("Read");
		menu.add(menuRead);
		menuRead.addActionListener(this);
		
		menuWrite = new JMenuItem("Write");
		menu.add(menuWrite);
		menuWrite.addActionListener(this);
		
		menuClose = new JMenuItem("Close");
		menu.add(menuClose);
		menuClose.addActionListener(this);
		
		this.setJMenuBar(menuBar);
		
		this.tableModelPunti = new DefaultTableModel(headerTablePunti, 0);
		this.tablePunti = new JTable(this.tableModelPunti);
		this.tablePunti.setPreferredSize(new Dimension(400,500));
		JScrollPane scrollPane = new JScrollPane(this.tablePunti);
		
		this.setLayout(new BorderLayout());
		//JPanel panelTablePunti = new JPanel();
		this.add(scrollPane,BorderLayout.CENTER);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource().equals(this.menuRead)){
			Percorso percorso = new Percorso();
			percorso.unmarshallingXml();
			TableModel tableModel = (DefaultTableModel)this.tablePunti.getModel();
			percorso.caricaTabella( (DefaultTableModel)tableModel );
		}
		
	}
	
	public static void main (String[]args) {
		
		GraficoGUI g = new GraficoGUI();
		
	}

}
