import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class Introducere_date_Conturi extends JFrame{
    private JTable tabel;
    private JTextField t1,t2,t3,t4,t5;
    private JButton b1,b2 , b3;
    private DefaultTableModel dtm;
    private JScrollPane scroll;
    private ResultSet rs;
    private Statement stmt;
    
    public Introducere_date_Conturi(){
        super("Introduceti datele ");
        setLayout(new FlowLayout());
        
        JPanel p1=new JPanel(new GridLayout(0,2,10,10));
        p1.add(new JLabel("Introduceti nume:"));
        t1=new JTextField(20);
        p1.add(t1);
        p1.add(new JLabel("Introduceti prenume:"));
        t2=new JTextField(20);
        p1.add(t2);
        p1.add(new JLabel("Introduceti companie:"));
        t3=new JTextField(20);
        p1.add(t3);
        p1.add(new JLabel("Introduceti capital companie"));
        t4=new JTextField(20);
        p1.add(t4);
        p1.add(new JLabel("Aveti extrase cont?"));
        t5=new JTextField(20);
        p1.add(t5);
        
        
        add(p1);
        JPanel p2=new JPanel();
        b1=new JButton("Inregistrati");
        p2.add(b1);
        b2=new JButton("Inapoi");
        p2.add(b2);
        b2.addActionListener( e -> {
            Introducere_date_Conturi.this.dispose();
         });
        add(p2,BorderLayout.SOUTH);
        b1.addActionListener( e -> {
        	conturiBanci cb=new conturiBanci(t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText());
            if (!ManagerExtraseBanci.cautaExtraseConturi(t1.getText())) ManagerExtraseBanci.memoreazaExtraseBanci(cb);
            else {
                JOptionPane.showMessageDialog(Introducere_date_Conturi.this, "Exista deja deja o inregistrare cu acest nume");
                t1.setText("");
            }
               
        });
        
        tabel = new JTable();
        dtm = new DefaultTableModel();
        createColumns(dtm);
        tabel.setModel(dtm);
        scroll = new JScrollPane(tabel);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        JPanel panel = new JPanel();       
        
        b3 = new JButton("Display Records");
        b3.addActionListener((ActionEvent e) -> {
            try {
                displayData();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        
        
        panel.add(b3);
        
       
       add(scroll, BorderLayout.CENTER);
       add(panel, BorderLayout.SOUTH);
        
        
    }
    

      public void displayData() throws SQLException {
        stmt = null;
        rs = null;
        String query1 = "SELECT * FROM conturi";
        Conectare con = Conectare.getInstanta();
        stmt= con.getStatement();
        rs = stmt.executeQuery(query1);
        while (rs.next()) {
        
            dtm.insertRow(0, new String[]{
                        rs.getString("nume"),
                        rs.getString("prenume"),
                        rs.getString("companie"),
                        rs.getString("capital"),
                        rs.getString("extrase_Cont")
                    });
        }
        
        tabel.setModel(dtm);
    }
    
    private void createColumns(DefaultTableModel dtm) {
        dtm.addColumn("Nume");
        dtm.addColumn("Prenume");
        dtm.addColumn("Companie");
        dtm.addColumn("Capital");
        dtm.addColumn("Extrase conturi");
    }}


