public class HomeWorkApp {

    public static void main(String[] args) {

        Cat[] cats = {
                new Cat("Barsik", 5),
                new Cat("Murzik", 7),
                new Cat("Tishka", 4),
                new Cat("Ryzik", 8)
        };

        Plate plate = new Plate(20);
        plate.info();

//  Кормим всех котов
        for (Cat cat: cats) {
            cat.eat(plate);
            cat.info();
            plate.info();
        }
        System.out.println("---------------------");

//  добавляем еду в тарелку
        plate.increaseFood(10);
        plate.info();

//  Кормим только голодных котов
        for (Cat cat: cats) {
            if (cat.getHungry()) {
                cat.eat(plate);
                cat.info();
                plate.info();
            }
        }
    }
}