import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class InsertMultipleRecordsExample {

    private static final String insertManyUsers = "INSERT INTO users "+
            "(id, name, email, country, password) VALUES " +
            " (?,?,?,?,?);";


    public void insertManyUsers(List<User> list){
        DbHelper dbHelper = new DbHelper();
        try (Connection con = DriverManager.getConnection(dbHelper.url, dbHelper.user, dbHelper.password);
             PreparedStatement stmt = con.prepareStatement(insertManyUsers);){

            int count = 0;

            for (User user: list){
                stmt.setInt(1, user.getId());
                stmt.setString(2, user.getName());
                stmt.setString(3, user.getEmail());
                stmt.setString(4, user.getCountry());
                stmt.setString(5, user.getPassword());

                stmt.addBatch();
                count++;

                if (count % 100 == 0 || count == list.size()){
                    stmt.executeBatch();
                }
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        InsertMultipleRecordsExample example = new InsertMultipleRecordsExample();
        example.insertManyUsers(Arrays.asList(new User(2, "Patrick", "cph-pj428@cphbusiness.dk", "Danmark", "password123"),
                new User(3, "Martin", "cph-mh956@cphbusiness.dk", "DK", "password123")));
    }

}
