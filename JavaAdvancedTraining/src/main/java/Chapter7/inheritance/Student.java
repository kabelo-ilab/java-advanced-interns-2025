package Chapter7.inheritance;

/**
 * @author Kabelo Tlhape
 * Parent class with common attributes for part-time and full-time
 * students
 */
public class Student {
    private String stNumber;
    private String firstname;
    private String lastname;
    private String major;

    public Student(String stNum, String firstname, String lastname, String major){
        setFirstname(firstname);
        setLastname(lastname);
        setStNumber(stNum);
        setMajor(major);
    }

    public String getStNumber() {
        return stNumber;
    }

    public void setStNumber(String stNumber) {
        this.stNumber = stNumber;
    }

    public String getName() {
        return firstname + " " + lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void displayDetails(){
        System.out.println("\nStudent: " + getName() + " (ST-" + getStNumber() + ")");
        System.out.println("Major: " + getMajor());
    }
}
