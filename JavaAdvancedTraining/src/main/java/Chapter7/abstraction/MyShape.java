package Chapter7.abstraction;
/**
 * @author Kabelo Tlhape
 */
public abstract class MyShape {
    /**
     * Calculate the area
     * @return the area as a {@code double}
     */
    public abstract double calcArea();

    /**
     * Calculate the perimeter
     * @return the perimeter as a {@code double}
     */
    public abstract double calcPerimeter();
    /**
     * Display the details of the shape
     */
    public abstract void display();

    /**
     * Draw a shape
     */
    public abstract void draw();
}
