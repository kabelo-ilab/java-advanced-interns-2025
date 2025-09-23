package Chapter7.interfaces;

/**
 * @author Kabelo Tlhape
 * This class implements methods from {@code IShape} and
 * {@code IGraphics} interfaces
 */
public class MyRectangle implements IShape, IGraphics{
    private int length, width;

    public MyRectangle(int l, int w){
        this.length = l;
        this.width = w;
    }
    /**
     * Apply paint on the shape
     *
     * @param color The color of the paint as a {@code string}
     */
    @Override
    public void applyPaint(String color) {

    }

    /**
     * Draw the shape
     */
    @Override
    public void draw() {
        System.out.println("\n");
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < width; col++) {
                System.out.print("* ");
            }
            System.out.println(); // Move to the next line
        }
    }

    /**
     * Calculate the area of the shape
     *
     * @return The calculated area
     */
    @Override
    public double getArea() {
        return this.length * this.width;
    }

    /**
     * Calculate the perimeter of the shape
     *
     * @return The calculated perimeter
     */
    @Override
    public double getPerimeter() {
        return (length + width) * 2;
    }

    /**
     * Display details of the shape
     */
    @Override
    public void display() {
        System.out.println("===== " + this.getClass().getSimpleName() + "======");
        System.out.format("""
                Length: %d
                Width: %d
                Area: %.2f
                Perimeter: %.2f""",length, width, getArea(), getPerimeter());
    }
}
