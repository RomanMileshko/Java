public class HomeWorkApp {

    public static void main(String[] args) {

        Animal[] animals = {
                new Dog("Бобик", 500, 10),
                new Dog("Шарик", 500, 10),
                new Dog("Тузик", 500, 10),
//                Барсик не умеет плавать !
                new Cat("Барсик", 200),
                new Cat("Мурзик", 200, 5)
        };

//        Забег команды на 500
        for (Animal animal : animals) {
            animal.run(150);
        }
        System.out.println();

//        Заплыв команды на 5
        for (Animal animal : animals) {
            animal.swim(5);
        }
        System.out.println();

//        Забег команды на 250
        for (Animal animal : animals) {
            animal.run(250);
        }
        System.out.println();

//        Заплыв команды на 15
        for (Animal animal : animals) {
            animal.swim(15);
        }
        System.out.println();

        System.out.println("Количество животных: " + Animal.getCountOfAnimal());
        System.out.println("Количество собак: " + Dog.getCountOfDog());
        System.out.println("Количество котов: " + Cat.getCountOfCat());
    }


}