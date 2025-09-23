package Chapter7.abstraction;

public class MyRectangle extends MyShape{
    private int length, width;

    public MyRectangle(int l, int w){
        this.length = l;
        this.width = w;
    }
    /**
     * Calculate the area
     *
     * @return the area as a {@code double}
     */
    @Override
    public double calcArea() {
        return this.length * this.width;
    }

    /**
     * Calculate the perimeter
     *
     * @return the perimeter as a {@code double}
     */
    @Override
    public double calcPerimeter() {
        return (length + width) * 2;
    }

    /**
     * Display the details of the shape
     */
    @Override
    public void display() {
        System.out.println("===== " + this.getClass().getSimpleName() + "======");
        System.out.format("""
                Length: %d
                Width: %d
                Area: %.2f
                Perimeter: %.2f""",length, width, calcArea(), calcPerimeter());
    }

    /**
     * Draw a shape
     */
    @Override
    public void draw() {
        System.out.println();
        for (int row = 0; row < length; row++) {
            for (int col = 0; col < width; col++) {
                System.out.print("* ");
            }
            System.out.println(); // Move to the next line
        }
    }
}
