package file;

import java.io.*;

public class FileReaderUtil {
    public static void readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null)
                System.out.println(line);
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
