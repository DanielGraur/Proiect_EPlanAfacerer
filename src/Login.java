import java.awt.BorderLayout;
import java.util.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame{
	 private static Conectare c=Conectare.getInstanta();
     private static Connection con=c.getConexiune();
	 private JTextField t1,t2;
	 private JButton b1,b2;
	
	public Login(){
		super("Introduceti datele pentru a va loga");
	    setLayout(new FlowLayout());
	    
	    JPanel p1=new JPanel(new GridLayout(4,2,10,10));
        p1.add(new JLabel("Introduceti email:"));
        t1=new JTextField(20);
        p1.add(t1);
        p1.add(new JLabel("Introduceti parola:"));
        t2=new JTextField(20);
        p1.add(t2);
        Ascultator a=new Ascultator();
        JPanel p2=new JPanel();
        b1=new JButton("Logare");
        b1.addActionListener(a);
        p2.add(b1);
        b2=new JButton("Inregistrati-va!");
        
        b2.addActionListener(a);
        p2.add(b2);
        add(p2,BorderLayout.SOUTH);
        
        add(p1);
        b1.addActionListener(e ->{
        	String t1Text = t1.getText();
        	String t2Text = t2.getText();
        	Client c = new Client(t1Text,t2Text, "", "", "");
        	if(ManagerCont.cautaCont(t1.getText()) && ManagerCont.cautaCont(t2.getText())) {
        		JOptionPane.showMessageDialog(Login.this, "V-ati logat cu succes");
        	}
        	else {
        		JOptionPane.showMessageDialog(Login.this, "Email-ul sau parola sunt gresite");
        		 t1.setText("");
        		 t2.setText("");
        	}
        });
      
        
	}
	  
    private class Ascultator implements ActionListener{
    	JFrame f;
    	
    	public void actionPerformed(ActionEvent e) {
    		if(e.getSource() == b1) {
    			f = new FereastraPrincipala();
    			f.pack();
    			f.setSize(400,300);
                f.setVisible(true);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		}
    		else if(e.getSource() == b2) {
    			f = new FereastraIntroducereNoua();
    			f.pack();
    			f.setSize(400,300);
                f.setVisible(true);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    		}
    	}
    }
    

	public static void main(String[] args) {
		
		 JFrame f=new Login();
	        f.setSize(400,250);
	        f.setVisible(true);
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
