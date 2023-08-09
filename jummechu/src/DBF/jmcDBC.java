package DBF;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jmcDBC {

    public static Connection DBConnect(){

        Connection con = null ;

        String url = "jdbc:oracle:thin:@localhost:1521:xe";

        String user = "JUMMECHU";
        String password = "1111";

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            con = DriverManager.getConnection(url, user, password);


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
}

