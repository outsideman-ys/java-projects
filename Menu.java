import java.util.Scanner;

public class Menu {
    private static int input = 0;

    public static void printMenu() {
        System.out.print("What do you want?\n 0 - exit\n 1 - input steps\n 2 - print month's status\n 3 - change goal\n");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextInt();
        while(input != 0) {
            
        }
        scanner.close();
    }

}
