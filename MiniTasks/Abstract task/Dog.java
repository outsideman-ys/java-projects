public class Dog extends Pet {

    Dog() {
        super(4);
    }

    @Override
    public void sleep() {
        System.out.println("гавгав");
    }

    public void bringStick() {
        System.out.println("Несу палку");
    }

    @Override
    public void play() {
        System.out.println("играю");
    }

    @Override
    public void giveVoice() {
        System.out.println("гав");
    }
}
