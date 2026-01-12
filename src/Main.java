import com.mynsc.conversor.aplicacion.AppConfig;
import com.mynsc.conversor.aplicacion.DataBaseClient;
import com.mynsc.conversor.modelos.Client;
import com.mynsc.conversor.modelos.Menu;

public class Main {
    public static void main(String[] args) {
        // String apiKey = AppConfig.getKey();
        // String url = DataBaseClient.createUrl(apiKey);
        // Client client = new Client(url);

        Menu.printMenu();
    }
}