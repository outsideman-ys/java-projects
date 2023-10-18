public class Cat extends Pet {

    Cat() {
        super(4);
    }

    @Override
    public void sleep() {
        System.out.println("Мурмур");
    }

    @Override
    public void play() {
        System.out.println("играю");
    }

    @Override
    public void giveVoice() {
        System.out.println("мяу");
    }

    public void catchMouse() {
        System.out.println("ловлю мышь");
    }
}
