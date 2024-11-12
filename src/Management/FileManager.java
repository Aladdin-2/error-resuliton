package Management;

import java.io.*;

public class FileManager {
    static String fileName = "RegisterInfo.txt";
    UserManager userManager = new UserManager();

    public void saveToFile() {


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            if (!userManager.users.isEmpty()) {
                writer.write(userManager.customToString(userManager.users));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing the file");
        }

    }

    public boolean isUserExists(String userName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = " ";
            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase(userName)) {
                    System.out.println(reader);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fayl tapılmadı: " + fileName);
        } catch (IOException e) {
            System.out.println("Fayldan oxumaqda xəta baş verdi.");
        }
        return false;
    }
}
