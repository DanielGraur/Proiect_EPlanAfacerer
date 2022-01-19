import java.sql.*;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MemoreazaDateORC {
    private static Conectare c=Conectare.getInstanta();
    private static Connection con=c.getConexiune();
     public static void memoreazaContORC(ORC orc){
        try{
            PreparedStatement ps=con.prepareStatement("INSERT INTO fisiereorc(nume,prenume, companie, asociati_companie,capital) VALUES (?,?,?,?,?)");
            ps.setString(1, orc.getNumeORC());
            ps.setString(2, orc.getPrenumeORC());
            ps.setString(3, orc.getCompanieORC());
            ps.setString(4, orc.getAsociatiORC());
            ps.setString(5, orc.getCapitalORC());
            ps.executeUpdate();
             JOptionPane.showMessageDialog(null,"Inregistrarea a fost creata");  
        }catch(Exception e){e.printStackTrace();}
    }
     public static boolean cautaORC(String nume){
 	    try{
 	            PreparedStatement ps=con.prepareStatement("SELECT * from fisiereORC WHERE nume=?");
 	            ps.setString(1, nume);    	           
 	            
 	            ResultSet rs=ps.executeQuery();
 	            return rs.next();
 	}catch(Exception e){e.printStackTrace();}
 	    return false;
 	}
     
    public static ArrayList<String> getFisireORC(){
    ArrayList<String> lista=new ArrayList<>();
    try{
        Statement st=c.getStatement();
        ResultSet rs=st.executeQuery("Select * from fisiereorc");
        while(rs.next()){
                String nume=rs.getString("nume");
                String prenume=rs.getString("prenume");
                String companie=rs.getString("companie");
                String asociati=rs.getString("asociati_companie");
                String capital=rs.getString("capital");
                
            }
        
    }catch(Exception e){e.printStackTrace();}
return lista;
}
     public static void stergeFisiereORC(ORC orc){
     try{
        PreparedStatement ps=con.prepareStatement("DELETE FROM fisiereorc WHERE nume=? and prenume=?");
        ps.setString(1, orc.getNumeORC());
        ps.setString(2, orc.getPrenumeORC());
        ps.executeUpdate();
     JOptionPane.showMessageDialog(null,"Inregistrarea a fost stearsa!");
     return;
}catch(Exception e){e.printStackTrace();}
     JOptionPane.showMessageDialog(null,"Eroare la baza de date! Contul nu a fost sters");  
   
}
    
}
