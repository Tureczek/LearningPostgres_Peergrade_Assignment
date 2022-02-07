import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRecordExample {


    private static final String createUsers = "INSERT INTO users " +
            "(id, name, email, country, password) VALUES " +
            "(?,?,?,?,?);";

    public static void main(String[] args) throws SQLException {

        InsertRecordExample insertRecordExample = new InsertRecordExample();
        insertRecordExample.insertUser();
    }

    public void insertUser() throws SQLException{
        System.out.println(createUsers);
        DbHelper dbHelper = new DbHelper();

        try (Connection connection = DriverManager.getConnection(dbHelper.url, dbHelper.user, dbHelper.password);

             PreparedStatement preparedStatement = connection.prepareStatement(createUsers)){
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "Nicholas");
            preparedStatement.setString(3, "cph-nt123@cphbusiness.dk");
            preparedStatement.setString(4, "DK");
            preparedStatement.setString(5, "1234");

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
        }
    }
}
