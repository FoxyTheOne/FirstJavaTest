package entities;

public class User {
    // Поля класса
    private final String firstName;
    private final String lastName;
    private final int age;

    // Конструкторы класса
    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}
