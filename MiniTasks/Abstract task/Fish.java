public class Fish extends Pet {

    Fish() {
        super(2);
    }

    @Override
    public void sleep() {
        System.out.println("Бульбуль");
    }

    @Override
    public void play() {
        System.out.println("играю");
    }

    @Override
    public void giveVoice() {
        System.out.println("буль");
    }
}
