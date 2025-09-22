package Chapter7;

public class Student {
    String stNumber;
    String firstname;
    String lastname;
    String major;

    public Student(){
        this.stNumber = "00000";
        this.firstname = "No name";
        this.lastname = "No lastname";
        this.major = "Nothing";
    }

    public Student(String stNum, String firstname, String lastname, String major){
        this.stNumber = stNum;
        this.firstname = firstname;
        this.lastname = lastname;
        this.major = major;
    }

    public void displayDetails(){
        System.out.println("Student: " + this.firstname + " " + this.lastname + " (ST-" + this.stNumber + ")");
        System.out.println("Major: " + this.major);
    }
}
