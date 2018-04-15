import org.junit.Test;

import java.io.*;
import java.net.URISyntaxException;

public class FileReading {

    @Test
    public void byteReader() throws URISyntaxException, FileNotFoundException, IOException {
        File file = new File("/home/dmitry/dev/JavaCore/JavaIO/fileFolder/fileForRead.txt");

        InputStream is = new FileInputStream(file);
        System.out.println("available= " + is.available());

        for (int i = 0; i < is.available(); i++) {
            int byteSymbol = is.read();
            System.out.print(byteSymbol + "  ");

            if (i != 0 && i % 10 == 0) System.out.println();
        }


//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//        System.out.println(reader.readLine());
    }

    @Test
    public void charReader() {

    }
}
