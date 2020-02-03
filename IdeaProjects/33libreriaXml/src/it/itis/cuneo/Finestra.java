package it.itis.cuneo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JTable;

public class Finestra extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private final JLabel label = new JLabel("New label");
	private JTextField tcodice;
	private JTextField ttitolo;
	private JTextField tprezzo;
	private JButton conferma;
	private final Action action = new SwingAction();
	private JButton bottone;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finestra frame = new Finestra();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Finestra() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblCodiceIsbn = new JLabel("Codice:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblCodiceIsbn, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblCodiceIsbn, 0, SpringLayout.WEST, contentPane);
		contentPane.add(lblCodiceIsbn);
		
		tcodice = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.NORTH, tcodice, 0, SpringLayout.NORTH, lblCodiceIsbn);
		sl_contentPane.putConstraint(SpringLayout.WEST, tcodice, 26, SpringLayout.EAST, lblCodiceIsbn);
		contentPane.add(tcodice);
		tcodice.setColumns(10);
		
		JLabel lblTitolo = new JLabel("Titolo:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblTitolo, 23, SpringLayout.SOUTH, lblCodiceIsbn);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblTitolo, 0, SpringLayout.WEST, lblCodiceIsbn);
		contentPane.add(lblTitolo);
		
		ttitolo = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, ttitolo, 0, SpringLayout.WEST, tcodice);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, ttitolo, 0, SpringLayout.SOUTH, lblTitolo);
		contentPane.add(ttitolo);
		ttitolo.setColumns(10);
		
		JLabel lblPrezzo = new JLabel("Prezzo:");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPrezzo, 24, SpringLayout.SOUTH, lblTitolo);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblPrezzo, 0, SpringLayout.WEST, contentPane);
		contentPane.add(lblPrezzo);
		
		tprezzo = new JTextField();
		sl_contentPane.putConstraint(SpringLayout.WEST, tprezzo, 0, SpringLayout.WEST, tcodice);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, tprezzo, 0, SpringLayout.SOUTH, lblPrezzo);
		contentPane.add(tprezzo);
		tprezzo.setColumns(10);
		
		conferma = new JButton("Conferma");
		conferma.setAction(action);
		sl_contentPane.putConstraint(SpringLayout.NORTH, conferma, 19, SpringLayout.SOUTH, tprezzo);
		sl_contentPane.putConstraint(SpringLayout.EAST, conferma, 0, SpringLayout.EAST, tcodice);
		contentPane.add(conferma);
		
		bottone = new JButton("New button");
		bottone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, bottone, 25, SpringLayout.SOUTH, conferma);
		sl_contentPane.putConstraint(SpringLayout.EAST, bottone, 0, SpringLayout.EAST, tcodice);
		contentPane.add(bottone);
		
		table = new JTable();
		sl_contentPane.putConstraint(SpringLayout.NORTH, table, -42, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, table, -10, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, table, -19, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, table, -10, SpringLayout.EAST, contentPane);
		contentPane.add(table);
	
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
