package Chapter7.inheritance;

public class StudentRunner {
    public static void main(String[] args) {
        Student st = new Student("123456","Kelvin","Smith","Python");
        st.displayDetails();

        PartTimeStudent objSt = new PartTimeStudent("Jones","Caroline","2456988","Java",true);
        objSt.displayDetails();

    }
}
