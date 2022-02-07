import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteRecordExample {

    DbHelper dbHelper = new DbHelper();

    private static final String deleteUser = "DELETE FROM users WHERE id = ?;";

    public static void main(String[] args) throws SQLException {
        DeleteRecordExample deleteRecordExample = new DeleteRecordExample();
        deleteRecordExample.deleteRecord();
    }

    private void deleteRecord() throws SQLException {

        try (Connection con = DriverManager.getConnection(dbHelper.url, dbHelper.user, dbHelper.password);

             PreparedStatement stmt = con.prepareStatement(deleteUser);){
            stmt.setInt(1,2);

            int result = stmt.executeUpdate();
            System.out.println("User deleted");
        }catch (SQLException e){
            System.out.println(e);
        }
    }
}
