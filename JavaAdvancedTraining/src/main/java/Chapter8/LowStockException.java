package Chapter8;
/**
 * @author Kabelo Tlhape
 * Thrown when a {@code Product} has a low quantity in stock
 */
public class LowStockException extends Exception{
    /**
     * Constructs an {@code LowStockException} with the specified details message
     * @param message the detail message
     */
    public LowStockException(String message) {
        super(message);
    }
}
