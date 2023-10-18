public abstract class Pet {
    private final int pawsCount;

    Pet(int pawsCount) {
        this.pawsCount = pawsCount;
    }

    public abstract void sleep();
    public abstract void play();
    public abstract void giveVoice();

    public int getPawsCount() {
        return pawsCount;
    }
}
