import java.util.Scanner;

public class App {
    public static void main(String[] args) {
       ContactBook<Contact> contactBook = new ContactBook<>();
       Scanner scanner = new Scanner(System.in);
       while (true) {
            PrintMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                AddStudent(contactBook);
            } else if (command == 2) {
                AddCoworker(contactBook);
            } else if (command == 3) {
                AddRelative(contactBook);
            } else if (command == 4) {
                Congratulate(contactBook);
            } else if (command == 5) {
                scanner.close();
                break;
            } else {
                System.out.println("Плохой ввод, попробуйте еще");
            }
       }
    }

    public static void PrintMenu() {
        System.out.println("Введите тип контакта: \n" +
                            "1 - Одногруппник\n2 - Коллега\n" +
                            "3 - Родственник\n4 - Поздравить кого-то\n" +
                            "5 - Выйти");
    }

    public static void Congratulate(ContactBook<Contact> contactBook) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        contactBook.congratulate(name);
    }
    

    public static void AddStudent(ContactBook<Contact> contactBook) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите соц сеть: ");
        String social = scanner.nextLine();
        System.out.println("Введите имя пользователя: ");
        String userName = scanner.nextLine();
        SocialContact socialContact = new SocialContact(name, social, userName);
        contactBook.addContact(socialContact);
        //scanner.close();
    }

    public static void AddCoworker(ContactBook<Contact> contactBook) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите имейл: ");
        String email = scanner.nextLine();
        Email emailContact = new Email(name, email);
        contactBook.addContact(emailContact);
        //scanner.close();
    }

    public static void AddRelative(ContactBook<Contact> contactBook) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите город: ");
        String city = scanner.nextLine();
        System.out.println("Введите адрес: ");
        String address = scanner.nextLine();
        Address addressContact = new Address(name, city, address);
        contactBook.addContact(addressContact);
        //scanner.close();
    }
}