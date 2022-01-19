import java.sql.*;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ManagerCont {
    private static Conectare c=Conectare.getInstanta();
    private static Connection con=c.getConexiune();
     public static void memoreazaCont(Client c){
        try{
            PreparedStatement ps=con.prepareStatement("INSERT INTO client(name,prenume, parola, email, companie) VALUES (?,?,?,?,?)");
            ps.setString(1, c.getNume());
            ps.setString(2, c.getPrenume());
            ps.setString(3, c.getParola());
            ps.setString(4, c.getEmail());
            ps.setString(5, c.getCompanie());
            
            ps.executeUpdate();
             JOptionPane.showMessageDialog(null,"Inregistrarea a fost creata");  
        }catch(Exception e){e.printStackTrace();}
    }
     public static boolean cautaCont(String name){
    try{
            PreparedStatement ps=con.prepareStatement("SELECT * FROM client WHERE email=?");
            ps.setString(1, name);           
            
            ResultSet rs=ps.executeQuery();
            return rs.next();
}catch(Exception e){e.printStackTrace();}
    return false;
}
    public static ArrayList<String> getConturi(){
    ArrayList<String> lista=new ArrayList<>();
    try{
        Statement st=c.getStatement();
        ResultSet rs=st.executeQuery("Select * from client");
        while(rs.next()){
                String name=rs.getString("name");
                String prenume=rs.getString("prenume");
                String parola=rs.getString("parola");
                String email=rs.getString("email");
                String companie=rs.getString("companie");
                
            }
        
    }catch(Exception e){e.printStackTrace();}
return lista;
}
     public static void stergeCont(Client c){
     try{
        PreparedStatement ps=con.prepareStatement("DELETE FROM client WHERE name=? and prenume=?");
        ps.setString(1, c.getNume());
        ps.setString(2, c.getPrenume());
        ps.executeUpdate();
     JOptionPane.showMessageDialog(null,"Inregistrarea a fost stearsa!");
     return;
}catch(Exception e){e.printStackTrace();}
     JOptionPane.showMessageDialog(null,"Eroare la baza de date! Contul nu a fost sters");  
   
}
    
}
