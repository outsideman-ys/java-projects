import java.util.ArrayList;

public class ContactBook<T extends Contact> {
    private ArrayList<T> contacts = new ArrayList<T>();

    public void addContact(T contact) {
        contacts.add(contact);
    }

    public void printList() {
        for (T contact : contacts) {
            System.out.println("Имя: " + contact.getName());
            contact.print();
        }   
    }

    public void congratulate(String name) {
        boolean contactPresented = false;
        for (T contact : contacts) {
            if(name.equals(contact.getName())) {
                System.out.println("Поздравим с Новым годом ваш контакт из записной книжки: " + name);
                contact.sendMessage();
                contactPresented = true;
            }
        }
        if (!contactPresented) {
            System.out.println("Не найден контакт с указанным именем.");
        }
    }

}