import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReaderTests {

    @Test
    public void consoleInput() throws IOException {
        InputStream read = System.in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(read));
        String readLine = reader.readLine();
        System.out.println(readLine);
        Scanner scanner = new Scanner(System.in);
        while (true)

        {
//            scanner.
            System.out.print("Введите любое целое число от 1 до 10: ");
//            Scanner scan = new Scanner(System.in)
            String username0 = scanner.nextLine();
            int number = scanner.nextInt();//read only number, '/n' - symbol
            String username01 = scanner.nextLine();
            System.out.print("Вы ввели число " + username0 + number + username01);

            System.out.print("Enter your username: ");
//            Scanner scanner = new Scanner(System.in);
            String username = "";
//            String username = scanner.nextLine();
            String username1 = scanner.nextLine();
            String username2 = scanner.nextLine();
            int number1 = scanner.nextInt();
            System.out.println("Your username is " + username + username1 + username2 + number1);

        }
    }
}
