package csv_parser.src.main.java.com.iryna.entities;

import csv_parser.src.main.java.com.iryna.CsvSerializable;
import csv_parser.src.main.java.com.iryna.utils.formatters.Formatter;

public class Student implements CsvSerializable {
    private String name;
    private String surname;
    private String group;
    private int age;

    private Student(String name, String surname, int age, String group) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.group = group;
    }

    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static Student create(String name, String surname, int age, String group) {
        if (age < 0) {
            throw new IllegalArgumentException("Age can't be negative");
        }

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }

        if (surname == null || surname.trim().isEmpty()) {
            throw new IllegalArgumentException("Surname can't be empty");
        }

        if (group == null || group.trim().isEmpty()) {
            throw new IllegalArgumentException("Group can't be empty");
        }

        return new Student(name, surname, age, group);
    }

    @Override
    public String serializeToString() {
        return String.format("%s,%s,%d,%s", name, surname, age, group);
    }

    @Override
    public void deserialize(String text) {
        String[] parts = text.split(",");
        name = parts[0];
        surname = parts[1];
        age = Integer.parseInt(parts[2]);
        group = parts[3];
    }

    @Override
    public String toString() {
        return String.format("Student %s %d years old", name, age);
    }

    public String toString(Formatter<Student> formatter) {
        return formatter.format(this);
    }
}
