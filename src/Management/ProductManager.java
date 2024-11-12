package Management;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    Scanner scan = new Scanner(System.in);

    private List<Product> cartItems = new ArrayList<>();

    public void addProduct() {
        while (true) {
            try {
                System.out.print("Write the product name (type 'exit' to stop!): ");
                String name = scan.nextLine();
                name = name.toUpperCase();
                if (name.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.print("Write the product price: ");
                double price = scan.nextDouble();
                scan.nextLine();
                System.out.print("Write the product count: ");
                int count = scan.nextInt();
                scan.nextLine();
                cartItems.add(new Product(name, price, count));
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter the correct format!");
                scan.nextLine();
            }
        }
    }

    public void removeProduct() {
        if (cartItems.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Write the product ID: ");
        int id = scan.nextInt();
        scan.nextLine();
        boolean found = false;
        for (Product product : cartItems) {
            if (id == product.getProductID()) {
                cartItems.remove(product);
                System.out.println("This product has been deleted!");
                found = true;
                break;
            }
            if (!found) {
                System.out.println("This product was not found!");
            }
        }


    }

    public void displayCartItems() {
        if (cartItems.isEmpty()) {
            System.out.println("The cart is empty!");
        } else {
            for (Product product : cartItems) {
                System.out.println(product);
            }
        }
    }

    public Product getMostExpensiveProduct() {
        if (cartItems.isEmpty()) return null;
        Product mostExpensive = cartItems.get(0);
        for (Product product : cartItems) {
            if (product.getProductPrice() > mostExpensive.getProductPrice()) {
                mostExpensive = product;
            }
        }
        return mostExpensive;
    }

    public void addProductCountOfTheSameName(String name, double price, int count) {
        if (cartItems.isEmpty()) {
            return;
        }
        for (Product item : cartItems) {
            if (item.getProductName().equalsIgnoreCase(name) && item.getProductPrice() == price) {
                item.setProductCount(item.getProductCount() + count);
                return; // Once the product count is updated, exit the method
            }
        }
        // If product is not found, it will just exit without recursion
    }


    public void applyDiscount() {
        System.out.println("To apply a discount, write the name of the product: ");
        String name = scan.nextLine();
        System.out.println("How much discount do you want?");
        double discount = scan.nextDouble();
        scan.nextLine();
        for (Product item : cartItems) {
            if (item.getProductName().equalsIgnoreCase(name)) {
                double discountPrice = item.getProductPrice() * (discount / 100);
                item.setProductPrice((item.getProductPrice() - discountPrice));
            }
        }
        System.out.println("Discount applied!");
    }

    public void searchProductByName() {
        System.out.println("Write the product name you want to search: ");
        String name = scan.nextLine();
        for (Product item : cartItems) {
            if (item.getProductName().equalsIgnoreCase(name)) {
                System.out.println(item);
            }
        }
    }

    public void calculateTotalCartPrice() {
        if (cartItems.isEmpty()) {
            System.out.println("The cart is empty!");
        } else {
            double totalPrice = 0;
            for (Product items : cartItems) {
                totalPrice += items.getProductPrice();
            }
            System.out.println("The total price of the items in cart: " + totalPrice);
        }
    }


    public void updateProductCount() {
        System.out.println("Write the name of the product you want to change the quantity of");
        String name = scan.nextLine();
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty!");
        }
        for (Product item : cartItems) {
            if (item.getProductName().equalsIgnoreCase(name)) {
                System.out.println(item);
                System.out.println("New count: ");
                int newCount = scan.nextInt();
                item.setProductCount(newCount);
                break;
            }
        }

    }

}
