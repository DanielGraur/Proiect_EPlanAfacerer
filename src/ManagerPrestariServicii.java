import java.sql.*;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ManagerPrestariServicii{
    private static Conectare c=Conectare.getInstanta();
    private static Connection con=c.getConexiune();
     public static void memoreazaPrestariServicii(prestariServicii cs){
        try{
            PreparedStatement ps=con.prepareStatement("INSERT INTO contractprestariservicii(nume,prenume, companie, domeniu_activare, servicii) VALUES (?,?,?,?,?)");
            ps.setString(1, cs.getNumePS());
            ps.setString(2, cs.getPrenumePS());
            ps.setString(3, cs.getCompaniePS());
            ps.setString(4, cs.getDomeniuActivarePS());
            ps.setString(5, cs.getServiciiPS());
            ps.executeUpdate();
             JOptionPane.showMessageDialog(null,"Inregistrarea a fost creata");  
        }catch(Exception e){e.printStackTrace();}
    }
     public static boolean cautaExtraseConturi(String nume){
 	    try{
 	            PreparedStatement ps=con.prepareStatement("SELECT * from contractprestariservicii WHERE nume=?");
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
        ResultSet rs=st.executeQuery("Select * from contractprestariservicii");
        while(rs.next()){
                String numePS=rs.getString("nume");
                String prenumePS=rs.getString("prenume");
                String companiePS=rs.getString("companie");
                String domeniuAcPS=rs.getString("domeniu_activare");
                String serviciiPS=rs.getString("servicii");
                
            }
        
    }catch(Exception e){e.printStackTrace();}
return lista;
}
     public static void stergeFisiereBanca(prestariServicii ps){
     try{
        PreparedStatement ps1=con.prepareStatement("DELETE FROM contractprestariservicii WHERE nume=? and prenume=?");
        ps1.setString(1, ((prestariServicii) ps1).getNumePS());
        ps1.setString(2, ((prestariServicii) ps1).getPrenumePS());
        ps1.executeUpdate();
     JOptionPane.showMessageDialog(null,"Inregistrarea a fost stearsa!");
     return;
}catch(Exception e){e.printStackTrace();}
     JOptionPane.showMessageDialog(null,"Eroare la baza de date! Contul nu a fost sters");  
   
}
    
}
