import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectURL {
    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        // Create a variable for the connection string
        String connectionUrl = "jdbc:sqlserver://localhost:13002;databaseName=TSQLV4;user=sa;password=PH@123456789;encrypt=true;trustServerCertificate=true";

        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {

            String SQL = "SELECT TOP 10 * FROM Sales.Orders";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it
            while (rs.next()) {
                System.out.println(rs.getString("custid"));
            }
        }

        // Handle any errors that may have occered
        catch (SQLException e) {
            e.printStackTrace();
        }

    }
}