public class Spider extends Pet {

    Spider() {
        super(8);
    }

    @Override
    public void sleep() {
        System.out.println("пыспыс");
    }

    @Override
    public void play() {
        System.out.println("играю");
    }

    @Override
    public void giveVoice() {
        System.out.println("пс");
    }
}
