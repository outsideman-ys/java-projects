import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("Bob");
        list.add("And");
        list.add("Opa");
        System.out.println(list);
        list.remove("And");
        System.out.println(list);
    }
}
