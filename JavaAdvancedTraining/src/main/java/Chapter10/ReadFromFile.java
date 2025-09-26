package Chapter10;

import java.io.*;

public class ReadFromFile {
    public static void main(String[] args) {
        String filePath = "D:\\repos\\java-advanced-interns-2025\\JavaAdvancedTraining\\src\\main\\resources\\Dummy Text.txt";
        File myFile = new File(filePath);
        String text;

        try {
            FileReader reader = new FileReader(myFile);
            BufferedReader read = new BufferedReader(reader);

            while ((text = read.readLine()) != null){
                System.out.println(text);
            }
            reader.close();
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found... " + e.getMessage());
        }catch (IOException e){
            System.err.println("Cannot read from file [" + myFile.getName() + "]");
        }
    }
}
