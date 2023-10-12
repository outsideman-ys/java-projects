public class MountainHare {

    // добавьте переменные и конструктор
    private int age;
    private double weight;
    private int jumpLength;
    private static String color;

    MountainHare(int age, double weight, int jumpLength) {
        this.age = age;
        this.weight = weight;
        this.jumpLength = jumpLength;
    }

    public static void SetColor(String newColor) {
        color = newColor;
    }

    @Override
    public String toString() {
        return "Заяц-беляк: " +
            "age=" + age +
            ", weight=" + weight +
            ", jumpLength=" + jumpLength +
            ", color=" + color +
            '.';
    }
}