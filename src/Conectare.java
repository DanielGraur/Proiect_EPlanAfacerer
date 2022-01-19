import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conectare {
    private static Conectare conexiune;
    private Connection con;
    private Statement stmt;
    
    private Conectare() {  
        try{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conectare.class.getName()).log(Level.SEVERE, null, ex);
            }

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/planafacere","root","Marmota23");
            stmt = con.createStatement();

        }catch(SQLException e){System.out.println("eroare de conectare: "+e.getMessage());}
    }
    
    public Connection getConexiune(){
        return con;
    }
    public Statement getStatement(){
        return stmt;
    }
    
    public void inchide(){
        try{
            stmt.close();
            con.close();
        }catch(Exception e){}
    }
    
    public static Conectare getInstanta(){
        if(conexiune==null) conexiune=new Conectare();
        return conexiune;
    }
   } 
    
    


