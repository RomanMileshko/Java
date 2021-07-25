public class Cat extends Animal {
    static int countOfCat;
    int limitRun;
    int limitSwim;

    public Cat(String name, int limitRun) {
        super(name);
        this.limitRun = limitRun;
        this.limitSwim = 0;
        countOfCat++;
    }

    public Cat(String name, int limitRun, int limitSwim) {
        super(name);
        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
        countOfCat++;
    }

    @Override
    public void run(int len) {
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

    public static int getCountOfCat() {
        return countOfCat;
    }
}
