package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    public Connection abrirConexao(){
        try{
          return DriverManager.getConnection("jdbc:mysql://localhost:3306/desafio_jdbc?user=filipe&password=281004");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
