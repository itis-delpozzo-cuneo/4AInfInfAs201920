import javax.swing.*;
import java.util.ArrayList;

public class ListaStati extends JFrame {
    JList<String> lStati;                   //JList GUI: disegno della JList sul JFrame
    DefaultListModel defaultLStati;         //JList Model: rappresenta i dati in memoria

    public ListaStati(){
        this.setTitle("Esempio di uso delle liste.");
        initComponents();
        pack();
        setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void initComponents(){
        defaultLStati = new DefaultListModel();
        this.lStati = new JList<String>(defaultLStati);

        //this.add(lStati);

        JScrollPane scrollPane = new JScrollPane(lStati);
        this.add(scrollPane);

        defaultLStati.add(0, "Francia");
        defaultLStati.add(1, "Germania");
        defaultLStati.add(2, "Italia");

        for(int cntStati=0; cntStati<10; cntStati++){
            defaultLStati.addElement("Spagna"+cntStati);
        }
    }

    public static void main(String[] args) {
        ListaStati listaStati = new ListaStati();
    }
}
