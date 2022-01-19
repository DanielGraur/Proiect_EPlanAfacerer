import java.awt.*;
import javax.swing.*;

public class FinalizareDocumente extends JFrame {
private JButton b1,b2;
private JLabel text;
    public FinalizareDocumente() {
        super("Documentele sunt pregatite");
      
        JPanel p= new JPanel(new GridLayout(0,2,10,10));
        JLabel text= new JLabel("Descarca Fisierul cu documente",JLabel.CENTER);
        p.add(text);
        JButton b2= new JButton("Descarca fisierele");
        p.add(b2, BorderLayout.SOUTH);    
        JPanel p1=new JPanel();
        JButton b1= new JButton("Inchide fereastra");
        p1.add(b1);
        p.add(p1, BorderLayout.SOUTH);
        add(p);

         b1.addActionListener( e -> {
           this.dispose();
         } );
    }
    
}
