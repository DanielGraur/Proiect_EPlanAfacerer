import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;


public class FereastraPrincipala extends JFrame{
    private JButton[] b;
    public FereastraPrincipala(){
        super("Fereastra principala");
        JPanel p=new JPanel(new GridLayout(4,2,10,10));
        b=new JButton[5];
        String[] et={"Detalii cont", "Introducere date ORC", "Introducere date conturi", "Introducere date prestari servicii","Salveaza si treci mai departe"};
        Ascultator a=new Ascultator();
        for(int i=0; i<et.length; i++){
        b[i]=new JButton(et[i]);
        p.add(b[i]);
        b[i].addActionListener(a);
    }
        add(p);
    }
    private class Ascultator implements ActionListener{
        JFrame f;
        
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==b[0]){
                f=new FereastraIntroducereNoua();
                f.pack();
                f.setSize(400,300);
                f.setVisible(true);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);                
            }
            else if(e.getSource()==b[1]){
                f=new IntrouducereDateORC();
                f.pack();
                f.setVisible(true);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
             if(e.getSource()==b[2]){
                f=new Introducere_date_Conturi();
                f.pack();
                f.setVisible(true);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
            }
             if(e.getSource() ==b[3]) {
            	 f = new IntroducetiDateServicii(); 
            	 f.pack();
                 f.setVisible(true);
                 f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
             }
             if(e.getSource()==b[4]){
                f=new FinalizareDocumente();
                f.pack();
                f.setVisible(true);
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
            
        
        }
    }
    
}
