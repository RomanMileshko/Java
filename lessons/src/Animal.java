public class Animal {
    private String name;
    static int countOfAnimal = 0;

    public Animal(String name) {
        this.name = name;
        countOfAnimal++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void swim(int len) {
    }

    void run(int len) {
    }

    public static int getCountOfAnimal() {
        return countOfAnimal;
    }

}
