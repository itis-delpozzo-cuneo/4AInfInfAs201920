import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

    public class MyComboBox extends JFrame{

        public MyComboBox(){
            this.setTitle("ArrayListComboBoxModel");

            initComponents();

            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(300, 225);
            this.setVisible(true);
        }

        public void initComponents(){
            Collection<Object> col = System.getProperties().values();
            ArrayList<Object> arrayList = new ArrayList<Object>(col);
            ArrayListComboBoxModel model = new ArrayListComboBoxModel(arrayList);

            JComboBox comboBox = new JComboBox(model);
            this.add(comboBox, BorderLayout.NORTH);
        }

        public static void main(String args[]) {
            MyComboBox frame = new MyComboBox();
        }
    }