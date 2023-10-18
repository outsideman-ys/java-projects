public class Smartphone extends MobilePhone {

    Smartphone(String number) {
        super(number);
    }

    public final void sendEmail(String email, String messageText) {
        System.out.println("Напишем другу сообщение " + messageText + " по email " + email);
    }

    public final void makeCall(String number, String appName) {
        System.out.println("Звоним через " + appName + " на номер " + number);
    }
}