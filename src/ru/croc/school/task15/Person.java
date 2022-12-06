package ru.croc.school.task15;

import ru.croc.school.task13.Film;

import java.util.Objects;

public class Person{

    private String fullName;
    private int age;

    Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public String getFullName() {
        return this.fullName;
    }

    public int getAge() {
        return this.age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Person))
            return false;

        Person person = (Person) obj;
        return this.fullName.equals(person.getFullName()) &&
                this.age == person.getAge();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.fullName, this.age);
    }

    @Override
    public String toString() {
        return this.fullName + " (" + this.age + ")";
    }
}
