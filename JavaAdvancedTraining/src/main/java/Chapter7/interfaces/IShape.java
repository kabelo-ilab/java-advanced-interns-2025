package Chapter7.interfaces;

public interface IShape {
    /**
     * Calculate the area of the shape
     * @return The calculated area
     */
    double getArea();

    /**
     * Calculate the perimeter of the shape
     * @return The calculated perimeter
     */
    double getPerimeter();

    /**
     * Display details of the shape
     */
    void display();
}
