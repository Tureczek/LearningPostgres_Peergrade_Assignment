import io.github.cdimascio.dotenv.Dotenv;

public class DbHelper {

    Dotenv dotenv = Dotenv.load();

    final String url = dotenv.get("psqlUrl");
    final String user = dotenv.get("psqlUser");
    final String password = dotenv.get("psqlPassword");

}
