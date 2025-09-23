package Chapter7.interfaces;

public interface IGraphics {
    /**
     * Apply paint on the shape
     * @param color The color of the paint as a {@code string}
     */
    void applyPaint(String color);

    /**
     * Draw the shape
     */
    void draw();
}
