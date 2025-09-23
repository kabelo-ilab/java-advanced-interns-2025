package Chapter8;

/**
 * The type Product.
 * GitHub repo for this section:
 * @author Kabelo Tlhape This class will throw exceptions based on the following rules:
 * <ol>
 *     <li>A product description should be at least 5 characters long</li>
 *     <li>Price cannot be zero or negative</li>
 *     <li>Quantity to sell cannot be more than quantity in stock</li>
 *     <li>The price increase should be less than R10</li>
 *     </ol>
 *     {@see <a href="https://github.com/kabelo-ilab/java-advanced-interns-2025/issues/5">Find this on git</a>}
 */
public class Product {
    private String code, description;
    private double price;
    private int qtyInStock;

    /**
     * Instantiates a new Product.
     *
     * @param code        product code
     * @param description product description
     * @param price       the price
     * @param qtyInStock  the quantity in stock
     */
    public Product(String code, String description, double price, int qtyInStock) {
        setCode(code);
        setDescription(description);
        setPrice(price);
        setQtyInStock(qtyInStock);
    }


    /**
     * Gets product code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets product code.
     *
     * @param code the code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets product description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param desc the product description
     * @throws IllegalArgumentException if the product description ({@code desc}) is less than 5 characters
     */
    public void setDescription(String desc) throws IllegalArgumentException {
        if (desc.length() < 5){
            throw new IllegalArgumentException("Description should be at least 5 characters long." +
                    "\nCurrent description: [" + desc + "]");
        }
        this.description = desc;
    }

    /**
     * Gets the product price.
     *
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the product price.
     *
     * @param price the price of the product
     * @throws IllegalArgumentException if the {@code price} is zero or negative
     */
    public void setPrice(double price) throws IllegalArgumentException {
        if (price <= 0){
            throw new IllegalArgumentException("Price cannot be zero / negative. " +
                    "\nCurrent price: [" + price + "]");
        }
        this.price = price;
    }

    /**
     * Gets quantity in stock.
     *
     * @return the quantity in stock
     */
    public int getQtyInStock() {
        return qtyInStock;
    }

    /**
     * Sets quantity in stock.
     *
     * @param qtyInStock the qty in stock
     */
    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    /**
     * Sell the product.
     *
     * @param qtyToSell the quantity to sell
     * @throws LowStockException if the quantity to sell {@code qtyToSell} is greater than the current quantity in stock {@code qtyInStock}
     */
    public void sell(int qtyToSell) throws LowStockException{
        if (qtyToSell > qtyInStock){
            throw new LowStockException("Not enough quantity to sell " + getDescription() +
                    ".\nCurrent Quantity in stock: " + getQtyInStock() +
                    "\nRequested quantity to sell: " + qtyToSell);
        }
        this.qtyInStock -= qtyToSell;
    }

    /**
     * Increase price of the product.
     *
     * @param percentage the percentage to increase the price by
     * @throws HighPriceIncreaseException if the price increase is greater or equals to 10
     */
    public void increasePrice(double percentage) throws HighPriceIncreaseException{
        double increase = this.price * (percentage / 100);
        if (increase >= 10){
            throw new HighPriceIncreaseException("The price increase on " + getDescription() +
                    " is too high [" + increase + "]" +
                    "\nThe increase should be less than 10.00");
        }
        this.price += increase;
    }

    @Override
    public String toString() {
        return String.format("""
                
                ===== Product Details for %s [%s] =====
                
                Code: %s
                Description: %s
                Price: %.2f
                Qty In Stock: %d""",getDescription(), getCode(),
                getCode(), getDescription(), getPrice(), getQtyInStock());
    }
}
