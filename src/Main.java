import io.github.cdimascio.dotenv.Dotenv;

public class Main {
    public static void main(String[] agrs) {
        Dotenv dotenv = Dotenv.configure()
            .directory("./src")
            .ignoreIfMalformed()
            .ignoreIfMissing()
            .load();
    }
}