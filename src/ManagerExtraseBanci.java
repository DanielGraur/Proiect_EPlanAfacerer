import java.sql.*;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ManagerExtraseBanci{
    private static Conectare c=Conectare.getInstanta();
    private static Connection con=c.getConexiune();
     public static void memoreazaExtraseBanci(conturiBanci cb){
        try{
            PreparedStatement ps=con.prepareStatement("INSERT INTO conturi(nume,prenume, companie, capital, extrase_Cont) VALUES (?,?,?,?,?)");
            ps.setString(1, cb.getNumeB());
            ps.setString(2, cb.getPrenumeB());
            ps.setString(3, cb.getCapitalB());
            ps.setString(4, cb.getCompanieB());
            ps.setString(5, cb.getExtraseContB());
            ps.executeUpdate();
             JOptionPane.showMessageDialog(null,"Inregistrarea a fost creata");  
        }catch(Exception e){e.printStackTrace();}
    }
     public static boolean cautaExtraseConturi(String nume){
 	    try{
 	            PreparedStatement ps=con.prepareStatement("SELECT * from conturi WHERE nume=?");
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
        ResultSet rs=st.executeQuery("Select * from conturi");
        while(rs.next()){
                String numeB=rs.getString("nume");
                String prenumeB=rs.getString("prenume");
                String companieB=rs.getString("companie");
                String capitalB=rs.getString("capital");
                String extrase_cont=rs.getString("extrase_Cont");
                
            }
        
    }catch(Exception e){e.printStackTrace();}
return lista;
}
     public static void steregeFisiereBanca(conturiBanci cb){
     try{
        PreparedStatement ps=con.prepareStatement("DELETE FROM conturi WHERE nume=? and prenume=?");
        ps.setString(1, cb.getNumeB());
        ps.setString(2, cb.getPrenumeB());
        ps.executeUpdate();
     JOptionPane.showMessageDialog(null,"Inregistrarea a fost stearsa!");
     return;
}catch(Exception e){e.printStackTrace();}
     JOptionPane.showMessageDialog(null,"Eroare la baza de date! Contul nu a fost sters");  
   
}
    
}
