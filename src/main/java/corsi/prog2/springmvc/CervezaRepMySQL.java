package corsi.prog2.springmvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository // Si la calse es de persistencia, debe anotarse como @Repository
public class CervezaRepMySQL implements CervezasRepository {

    private final String dbFullURL;
    private final String dbUser;
    private final String dbPswd;

    @Autowired  // Inyección en el contructor (constructor injection)
    public CervezaRepMySQL(
            @Qualifier("dbName") String dbName,
            @Qualifier("dbURL") String dbURL,
            @Qualifier("dbUser") String dbUser,
            @Qualifier("dbPswd") String dbPswd) {
        dbFullURL = "jdbc:mysql://" + dbURL + "/" + dbName;
        this.dbUser = dbUser;
        this.dbPswd = dbPswd;
    }

    @Override
    public List<Cerveza> getCervezasByColor(String color) {
        ArrayList<Cerveza> resultado = new ArrayList<Cerveza>();
        try {
            Connection con = DriverManager.getConnection(dbFullURL, dbUser, dbPswd);
            Statement stmt = con.createStatement();
            stmt.execute("SELECT marca, color, foto FROM cervezas WHERE color='" + color + "';");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                Cerveza cerveza = new Cerveza();
                cerveza.setMarca(rs.getString(1));
                cerveza.setColor(rs.getString(2));
                cerveza.setFoto(rs.getString(3));
                resultado.add(cerveza);
            }
            con.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return resultado;
    }

    @Override
    public List<String> getColores() {
        ArrayList<String> resultado = new ArrayList<String>();
        try {
            Connection con = DriverManager.getConnection(dbFullURL, dbUser, dbPswd);
            Statement stmt = con.createStatement();
            stmt.execute("SELECT DISTINCT color FROM cervezas;");
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                resultado.add(rs.getString(1));
            }
            con.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return resultado;
    }

}
