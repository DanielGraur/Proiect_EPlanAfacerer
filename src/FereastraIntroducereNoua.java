
import java.awt.*;
import javax.swing.*;
import javax.swing.JFrame;

public class FereastraIntroducereNoua extends JFrame {
 private JTextField t1,t2,t3,t4,t5;
    private JButton b1,b2;
    public FereastraIntroducereNoua() {
        super("Inregistrare noua");
     JPanel p1=new JPanel(new GridLayout(0,2,10,10));
     p1.add(new JLabel("Introduceti nume:"));
     t1=new JTextField(20);
     p1.add(t1);
     p1.add(new JLabel("Introduceti prenume:"));
     t2=new JTextField(20);
     p1.add(t2);
     p1.add(new JLabel("Introduceti parola:"));
     t3=new JTextField(20);
     p1.add(t3);
     p1.add(new JLabel("Introduceti email"));
     t4=new JTextField(20);
     p1.add(t4);
     p1.add(new JLabel("Introduceti companie"));
     t5=new JTextField(20);
     p1.add(t5);
     add(p1);
     JPanel p2=new JPanel();
     b1=new JButton("Inregistrati");
     p2.add(b1);
     b2=new JButton("Inapoi");
     p2.add(b2);
     add(p2,BorderLayout.SOUTH);
     b1.addActionListener( e -> {
    	 Client c=new Client(t1.getText(),t2.getText(),t3.getText(),t4.getText(),t5.getText());
         if (!ManagerCont.cautaCont(t1.getText())) {
        	 ManagerCont.memoreazaCont(c); 
        	 JOptionPane.showMessageDialog(FereastraIntroducereNoua.this, "Ati fost logat cu succes!");
         }
         else {
             JOptionPane.showMessageDialog(FereastraIntroducereNoua.this, "Exista deja deja o inregistrare cu acest nume");
             t1.setText("");
         }
            
     });
    
     b2.addActionListener( e -> {
        FereastraIntroducereNoua.this.dispose();
     });
    }
    }
