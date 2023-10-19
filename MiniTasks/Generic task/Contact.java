public abstract class Contact {
    private final String name;
    
    Contact(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void print();
    public abstract void sendMessage();
    
    
}