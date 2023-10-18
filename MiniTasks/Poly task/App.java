import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("Вас приветствует виртуальная АТС!");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваш номер телефона:");
        String number = scanner.next();
        System.out.println("Введите номер пользователя, которому хотите позвонить:");
        String friendNumber = scanner.next();
        System.out.println("Выберите вашу модель телефона, 1 - стационарный телефон, 2 - мобильный телефон, 3 - смартфон:");
        int type = scanner.nextInt();

        if (type < 1 || type > 3) {
            System.out.println("Введена неверная модель телефона");
            scanner.close();
            return;
        }
        scanner.close();
        Phone phone = getPhone(type, number);
        phone.makeCall(friendNumber);
        if(phone instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) phone;
            smartphone.makeCall(friendNumber, "WhatsApp");
            smartphone.sendEmail("y.smirnov@gmail.com", "Hello world");
            smartphone.sendSms(friendNumber, "Hi world");
        } else if(phone instanceof MobilePhone) {
            MobilePhone mobile = (MobilePhone) phone;
            mobile.sendSms(friendNumber, "Hi world");
            //mobile.sendEmail("y.smirnov@gmail.com", "Hello world");
        }
    }

    public static Phone getPhone(int type, String number) {
        if (type == 1) {
            return new CellularPhone(number);
        } else if (type == 2) {
            return new MobilePhone(number);
        } else {
            return new Smartphone(number);
        }
    }

}