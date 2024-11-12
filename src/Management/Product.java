package Management;

import java.util.Random;

public class Product {
    private String productName;
    private Double productPrice;
    private int productID;
    private int productCount;

    public Product() {
    }

    public Product(String productName, double productPrice, int productCount) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCount = productCount;
        this.productID = new Random().nextInt(100, 1000);
    }

    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        if (productCount < 0) {
            System.out.println("Count cannot be negative");
            return;
        }
        this.productCount = productCount;
    }

    public void displayProductDetails() {
        System.out.println("Management.Product name=" + productName + ", product price= " + productPrice + " , product ID= " + productID);
    }

    @Override
    public String toString() {
        return "Management.Product{ " +
                "Management.Product id='" + productID + '\'' +
                ", product name=" + productName +
                ", product price=" + productPrice +
                ", product count=" + productCount +
                " }";
    }
}
