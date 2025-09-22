package Chapter7.inheritance;

/**
 * @author Kabelo Tlhape
 * Protected - attributes are accessible within the parent class
 * and any other child class that inherits from the parent class
 */
public class MyShape {
    protected int length;
    protected int width;

    public MyShape(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public double calcArea(){
        return this.length * this.width;
    }

    public void display(String shape){
        System.out.println("\n======== " + shape + " ========");
        System.out.println("Length: " + this.length);
        System.out.println("Width: " + this.width);
        System.out.println("Area: " + this.calcArea());
    }
}
