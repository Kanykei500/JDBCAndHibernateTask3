package peaksoft;

import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserService service = new UserServiceImpl();
        while (true) {
            System.out.println("""
                    1.CREAT TABLE USERS
                    2.DROP TABLE USERS
                    3.SAVE USER
                    4.REMOVE USER BY ID
                    5.GET ALL USERS
                    6.CLEAN TABLE USERS
                    
                    write command:
                    """);
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    System.out.println(service.createUsersTable());
                    break;
                case 2:
                    System.out.println(service.dropUsersTable());
                    break;
                case 3:
                    System.out.println(service.saveUser("Kanykei", "Askarbekova", (byte) 19));
                    System.out.println(service.saveUser("Eliza", "Ashyrbaeva", (byte) 18));
                    System.out.println(service.saveUser("Nuriza ", "Muratova", (byte) 17));
                    System.out.println(service.saveUser("Saltanat ", "Nematill kyzy", (byte) 20));
                    break;
                case 4:
                    System.out.println(service.removeUserById(1));
                    break;
                case 5:
                    service.getAllUsers().forEach(System.out::println);
                    break;
                case 6:
                    System.out.println(service.cleanUsersTable());
                    break;


            }
        }
    }
}