import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateRecordExample {

    DbHelper dbHelper = new DbHelper();

    private static final String updateUser = "UPDATE users SET name = ? WHERE id = ?;";

    public static void main(String[] args) throws SQLException {
        UpdateRecordExample updateRecordExample = new UpdateRecordExample();
        updateRecordExample.updateOne();
    }

    private void updateOne() throws SQLException {
        System.out.println(updateUser);

        try (Connection con = DriverManager.getConnection(dbHelper.url, dbHelper.user, dbHelper.password);

        PreparedStatement stmt = con.prepareStatement(updateUser)){
            stmt.setString(1, "Nicholas Tureczek");
            stmt.setInt(2, 1);

            stmt.executeUpdate();
        }catch (SQLException e){
            System.out.println(e);
        }

    }
}

