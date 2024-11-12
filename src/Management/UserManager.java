package Management;

import Display.AdminDisplay;
import Display.UserDisplay;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserManager {

    UserDisplay userDisplay = new UserDisplay();
    AdminDisplay admin = new AdminDisplay();
    Map<String, String> users = new HashMap<>();
    String loggedInUser = null;
    String adminUsername = "Aladdin";
    String adminPassword = "23345";
    FileManager fileManager;

    public boolean registerUser() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a username: ");
        String username = scan.nextLine();

        if (fileManager.isUserExists(username)) {
            System.out.println("Username already exists. Try a different one.");
            return false;
        } else {
            System.out.print("Enter a password: ");
            String password = scan.nextLine();
            users.put(username, password);
            System.out.println("Registration successful! You can now log in.");
            userDisplay.usersDisplay();
            return true;
        }
    }


    public boolean loginUser() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scan.nextLine();
        System.out.print("Enter your password: ");
        String password = scan.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            System.out.println("Login successful! Welcome, " + username);
            userDisplay.usersDisplay();
            return true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return false;
        }
    }

    public boolean loginAdmin() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scan.nextLine();
        System.out.print("Enter your password: ");
        String password = scan.nextLine();

        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            loggedInUser = username;
            System.out.println("Login successful! Welcome, Aladdin.");
            admin.adminDisplay();
            return true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return false;
        }
    }


    public String customToString(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("Users List:\n");

        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append("Username: ").append(entry.getKey())
                    .append(" | Password: ").append(entry.getValue())
                    .append("\n");
        }

        return sb.toString();
    }

}

