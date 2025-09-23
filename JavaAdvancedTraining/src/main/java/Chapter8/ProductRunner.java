package Chapter8;

import java.util.Scanner;

public class ProductRunner {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            double price;
            int qty;
            System.out.print("Enter price: ");
            price = sc.nextDouble();

            System.out.print("Enter Qty: ");
            qty = sc.nextInt();
            Product objProd = new Product("CK200", "Coke Zero", price, qty);

            objProd.sell(5);
            objProd.increasePrice(5);

            System.out.println(objProd);
        } catch (IllegalArgumentException | LowStockException | HighPriceIncreaseException e) {
            System.err.println(e.getMessage());
        }


    }
}
