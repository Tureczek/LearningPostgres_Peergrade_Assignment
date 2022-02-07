import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableExample {

    private static final String createTableSQL = "CREATE TABLE users " +
            "(ID INT PRIMARY KEY , NAME TEXT , EMAIL VARCHAR(50), " +
        "COUNTRY VARCHAR (50), PASSWORD VARCHAR(50))";

    public static void main(String[] args) throws SQLException {

        CreateTableExample createTableExample = new CreateTableExample();
        createTableExample.createTable();
    }

    public void createTable() throws SQLException {
        DbHelper dbHelper = new DbHelper();
        // Creating connection
        try(Connection con = DriverManager.getConnection(dbHelper.url, dbHelper.user, dbHelper.password);

        Statement stmt = con.createStatement();){

            stmt.execute(createTableSQL);
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    public static void printSQLException(SQLException ex){
        for (Throwable e:ex){
            if (e instanceof SQLException);
            e.printStackTrace(System.err);
            System.err.println("SQLState: " + ((SQLException) e).getSQLState());
            System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
            System.err.println("Message: " + e.getMessage());
            Throwable t = ex.getCause();
            while (t != null){
                System.out.println("Cause: " + t);
                t = t.getCause();
            }
        }
    }

}
