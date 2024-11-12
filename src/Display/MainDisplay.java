    package Display;

    import Management.UserManager;

    import java.util.*;

    public class MainDisplay {
        Scanner scan = new Scanner(System.in);
        UserManager userManager = new UserManager();
        AdminDisplay adminDisplay = new AdminDisplay();
        UserDisplay userDisplay = new UserDisplay();

        public void registrationDisplay() {
            while (true) {
                System.out.println("1.Login Admin.");
                System.out.println("2.Register user.");
                System.out.println("3.Login user..");
                System.out.println("4.Exit...");
                int choice = scan.nextInt();
                scan.nextLine();
                switch (choice) {
                    case 1:
                        if (userManager.loginAdmin()) {
                            adminDisplay.adminDisplay();
                        }

                        break;
                    case 2:
                        if (userManager.registerUser()) {
                            userDisplay.usersDisplay();
                        }
                        break;
                    case 3:
                        if (userManager.loginUser()) {
                            userDisplay.usersDisplay();
                        }
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid choice! Please try again.");

                }
            }

        }

    }
