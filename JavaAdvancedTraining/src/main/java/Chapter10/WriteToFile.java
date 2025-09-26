package Chapter10;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author Kabelo Tlhape
 * This class demonstrate creation of .txt file
 */
public class WriteToFile {
    public static void main(String[] args) {
        String filePath = "D:\\repos\\java-advanced-interns-2025\\JavaAdvancedTraining\\src\\main\\resources\\Hobbies.txt";

        File myFile = new File(filePath);

        try {
            myFile.createNewFile();
            //Write to file
            PrintStream pen = new PrintStream(myFile);//open the file for writing
            pen.println("Tennis");
            pen.println("Soccer");
            pen.print("Chess");
            pen.println("Hiking");

            pen.close();
        } catch (IOException e) {
            System.err.println("Failed to create file... " + e.getMessage() );
        }
    }
}
