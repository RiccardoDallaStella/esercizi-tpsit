import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/cucina alpini?"+"user=root&password=");

        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Cliente> list = new ArrayList<>();

        try {
            stmt = conn.createStatement();
            if(stmt.execute("SELECT clienti.* FROM clienti"))
                rs = stmt.getResultSet();

            while(rs.next()){
                Cliente c = new Cliente();
                c.setCognome(rs.getString(2));
                c.setNome(rs.getString(3));
                c.setAnnoNascita(rs.getDate(4));
                c.setIndirizzo(rs.getString(5));
                list.add(c);
            }
            //stmt.executeQuery() solo per le select
        }
        catch (SQLException ex){
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {

            try { //Chiusura della risposta
                rs.close();
            } catch (SQLException sqlEx) { }
        }

        try {
            stmt.close(); //Chiusura della sessione di richiesta al database
        } catch (SQLException sqlEx) { }

        for (Cliente c: list)
            System.out.println(c);
    }
}