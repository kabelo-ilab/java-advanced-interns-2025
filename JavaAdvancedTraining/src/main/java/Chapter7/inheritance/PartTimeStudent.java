package Chapter7.inheritance;

/**
 * @author Kabelo Tlhape
 * Child class that inherits from Student class
 */
public class PartTimeStudent extends Student {
    private boolean isEmployed;// unique attribute

    public PartTimeStudent(String lastname, String firstname, String stNum, String major, boolean employed){
        super(stNum,firstname,lastname,major);
        setEmployed(employed);
    }
    public boolean getIsEmployed() {
        return isEmployed;
    }

    public void setEmployed(boolean employed) {
        isEmployed = employed;
    }

    @Override
    public void displayDetails(){
        System.out.println("\nStudent: " + getName() + " (ST-" + getStNumber() + ")");
        System.out.println("Major: " + getMajor());
        System.out.println("Employed? : " + getIsEmployed());
    }
}
