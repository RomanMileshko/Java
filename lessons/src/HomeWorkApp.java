public class HomeWorkApp {

    public static void main(String[] args) {
        Person[] persArray = new Person[5];

        persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "89231231213", 30000, 30);
        persArray[1] = new Person("Petrov Petrov", "Intern", "ppetrov@mailbox.com", "89231231214", 10000, 22);
        persArray[2] = new Person("Sidorov Sidor", "Driver", "sisidor@mailbox.com", "89231231215", 15000, 42);
        persArray[3] = new Person("Volk Valery", "Manager", "vvolk@mailbox.com", "89231231216", 20000, 26);
        persArray[4] = new Person("Lisitsa Lisa", "Accountant", "lisitsa@mailbox.com", "89231231217", 30000, 45);

        for (int i = 0; i < persArray.length; i++)
            if (persArray[i].getAge() > 40) persArray[i].printInfo();
    }
}