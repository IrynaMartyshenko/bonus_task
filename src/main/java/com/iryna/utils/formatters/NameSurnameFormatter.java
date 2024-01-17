package csv_parser.src.main.java.com.iryna.utils.formatters;

import csv_parser.src.main.java.com.iryna.entities.Student;

public class NameSurnameFormatter implements Formatter<Student> {
    @Override
    public String format(Student item) {
        return item.getName() + " " + item.getSurname();
    }
}
