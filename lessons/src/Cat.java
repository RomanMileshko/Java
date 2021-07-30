public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }
    public void eat(Plate p) {
        satiety = p.decreaseFood(appetite);
    }

    public void info() {
        if (satiety) System.out.printf("The cat %s is full !!!%n", name);
        else System.out.printf("The cat %s is not full !!!%n", name);
    }

    public boolean getSatiety() {
        return satiety;
    }

    public boolean getHungry() {
        return !getSatiety();
    }

}
