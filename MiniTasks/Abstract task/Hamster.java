public class Hamster extends Pet {

    Hamster() {
        super(4);
    }

    @Override
    public void sleep() {
        System.out.println("хомхом");
    }

    @Override
    public void play() {
        System.out.println("играю");
    }

    @Override
    public void giveVoice() {
        System.out.println("хом");
    }

    public void hideFood() {
        System.out.println("прячу еду");
    }
}
