package Display;

import Management.FileManager;
import Management.ProductManager;

import java.util.Scanner;

public class AdminDisplay {
    Scanner scan = new Scanner(System.in);
    ProductManager productManager = new ProductManager();
    FileManager fileManager = new FileManager();
    MainDisplay mainDisplay = new MainDisplay();


    public void adminDisplay() {
        while (true) {
            System.out.println("1.Apply a discount to the product.");
            System.out.println("2.Adding users to a file.");
            System.out.println("3.Return to user menu...");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    productManager.applyDiscount();
                    break;
                case 2:
                    fileManager.saveToFile();
                    break;
                case 3:
                    System.out.println("Logging out! ");
                    break;
            }
        }
    }
}
