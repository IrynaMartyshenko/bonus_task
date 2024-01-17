package csv_parser.src.main.java.com.iryna.utils.formatters;

import csv_parser.src.main.java.com.iryna.entities.Student;

public class WelcomeWithNameFormatter implements Formatter<Student> {
    @Override
    public String format(Student item) {
        return "Hello, I am " + item.getName();
    }
}
