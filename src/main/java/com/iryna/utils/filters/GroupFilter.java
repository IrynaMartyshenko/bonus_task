package csv_parser.src.main.java.com.iryna.utils.filters;

import java.util.function.Predicate;

import csv_parser.src.main.java.com.iryna.entities.Student;

public class GroupFilter implements Predicate<Student> {
    private String group;

    public GroupFilter(String group) {
        this.group = group;
    }

    @Override
    public boolean test(Student t) {
        return t.getGroup().equals(group);
    }
}
