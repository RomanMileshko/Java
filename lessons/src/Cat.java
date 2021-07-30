public class Cat {
    private final String name;
    private final int appetite;
    private boolean isFull;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isFull = false;
    }
    public void eat(Plate p) {
        if (!isFull) isFull = p.decreaseFood(appetite);
    }

    public void info() {
        if (isFull) System.out.printf("The cat %s is full !!!%n", name);
        else System.out.printf("The cat %s is not full !!!%n", name);
    }

}
