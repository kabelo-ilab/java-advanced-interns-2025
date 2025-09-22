package Chapter7;

public class StudentRunner {
    public static void main(String[] args) {
        //Declare
        Student st = new Student("123456","Kelvin","Smith","Python");
        //Use
        st.displayDetails();
        System.out.println();

        //Declare
        Student st1 = new Student("45698","Carol","Smith","Java");
        //Use
        st1.displayDetails();
    }
}
