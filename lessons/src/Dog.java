public class Dog extends Animal {
    static int countOfDog;
    int limitRun;
    int limitSwim;

    public Dog(String name, int limitRun) {
        super(name);
        this.limitRun = limitRun;
        this.limitSwim = 0;
        countOfDog++;
    }

    public Dog(String name, int limitRun, int limitSwim) {
        super(name);
        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
        countOfDog++;
    }

    @Override
    void run(int len) {
        int dist;
        if (len > limitRun) dist = limitRun; else dist = len;
        System.out.printf("%s (%s) пробежал %d метров из %d.%n", getName(), this, dist, len);
    }

    @Override
    void swim(int len) {
        int dist;
        if (limitSwim != 0) {
            if (len > limitSwim) dist = limitSwim;
            else dist = len;
            System.out.printf("%s (%s) проплыл %d метров из %d.%n", getName(), this, dist, len);
        } else
            System.out.printf("%s (%s) не умеет плавать.%n", getName(), this);
    }

    public static int getCountOfDog() {
        return countOfDog;
    }
}
