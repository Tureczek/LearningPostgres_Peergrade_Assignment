import java.sql.*;

public class RetrieveRecordExample {

    private static final String query = "SELECT id,name,email,country,password FROM Users WHERE id = ?";
    private static final String getAll = "SELECT * FROM users";

    DbHelper dbHelper = new DbHelper();

    public void getUserById() {


        try (Connection con = DriverManager.getConnection(dbHelper.url, dbHelper.user, dbHelper.password);


             PreparedStatement stmt = con.prepareStatement(query);) {
            stmt.setInt(1, 1);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                String password = rs.getString("password");
                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    public void getAllUsers() {

        try (Connection con = DriverManager.getConnection(dbHelper.url, dbHelper.user, dbHelper.password);

             PreparedStatement stmt = con.prepareStatement(getAll);) {


            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                String password = rs.getString("password");
                System.out.println(id + "," + name + "," + email + "," + country + "," + password);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        RetrieveRecordExample example = new RetrieveRecordExample();
        //example.getUserById();
        example.getAllUsers();
    }

}
