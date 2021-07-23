public class Person {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private double salary;
    private int age;


    public Person(String fullName, String position, String email, String phone, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public void printInfo() {
        System.out.printf("ФИО:      %20s %n", this.fullName);
        System.out.printf("Должность:%20s %n", this.position);
        System.out.printf("Email:    %20s %n", this.email);
        System.out.printf("Телефон:  %20s %n", this.phone);
        System.out.printf("Зарплата: %20.2f %n", this.salary);
        System.out.printf("Возраст:  %20d %n%n", this.age);
    }
}
