import java.util.Scanner;

import com.mynsc.conversor.modelos.Menu;

public class Main {
    public static void main(String[] args) {
        Scanner inpScanner = new Scanner(System.in);
        boolean leave = true;

        while (leave) {
            leave = Menu.printMenu(inpScanner);
        }

        inpScanner.close();
    }
}