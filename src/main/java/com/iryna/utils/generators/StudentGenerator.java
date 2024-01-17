package csv_parser.src.main.java.com.iryna.utils.generators;

import csv_parser.src.main.java.com.iryna.entities.Student;

public class StudentGenerator implements ObjectGenerator<Student> {
    private static final String[] NAMES = {"Ivan", "Petro", "Stepan", "Oleg", "Vasyl", "Oleksandr", "Olena", "Iryna", "Anna", "Maria"};
    private static final String[] SURNAMES = {"Ivanov", "Petrov", "Stepanov", "Olegov", "Vasyliev", "Oleksandrov", "Olenov", "Irynov", "Annenov", "Marianov"};
    private static final String[] GROUPS = {"IA-31", "IA-32", "IA-33", "IA-34"};

    @Override
    public Student generate() {
        String name = NAMES[(int) (Math.random() * NAMES.length)];
        String surname = SURNAMES[(int) (Math.random() * SURNAMES.length)];
        String group = GROUPS[(int) (Math.random() * GROUPS.length)];
        int age = (int) (Math.random() * 100);
        return Student.create(name, surname, age, group);
    }
}
  
