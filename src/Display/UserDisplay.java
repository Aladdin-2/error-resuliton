package Display;

import Management.ProductManager;
import Management.UserManager;

import java.util.Scanner;

public class UserDisplay {
    Scanner scan = new Scanner(System.in);
    ProductManager productManager= new ProductManager();
    MainDisplay shoppingCart;


    public void usersDisplay() {
        while (true) {
            System.out.println("1.Add product.");
            System.out.println("2.Delete product by ID.");
            System.out.println("3.Show cart.");
            System.out.println("4.Calculate the total price of the cart.");
            System.out.println("5.Show the most expensive product.");
            System.out.println("6.Exit...");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    productManager.addProduct();
                    break;
                case 2:
                    productManager.removeProduct();
                    break;
                case 3:
                    productManager.displayCartItems();
                    break;
                case 4:
                    productManager.calculateTotalCartPrice();
                    break;
                case 5:
                    productManager.getMostExpensiveProduct();
                    break;
                case 6:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

}