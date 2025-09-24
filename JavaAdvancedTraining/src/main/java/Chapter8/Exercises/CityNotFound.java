package Chapter8.Exercises;

import java.util.Scanner;

public class CityNotFound {
    public static void main(String[] args) {
        String[] arCities = new String[]{
                "London", "Midrand", "Brooklyn", "Pretoria",
                "Rustenburg", "Centurion", "Randburg", "Sandton"
        };

        Scanner sc = new Scanner(System.in);
        int cityPosition = -1;

        try {
            System.out.print("Enter city position to look for: ");
            cityPosition = sc.nextInt();

            System.out.println("City at position " + cityPosition + " is " + arCities[cityPosition]);
        }catch (ArrayIndexOutOfBoundsException ex){
            System.err.println("There is no city found at position [" + cityPosition +"]");
        }
        
    }
}
