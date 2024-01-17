package csv_parser.src.main.java.com.iryna;


import java.util.ArrayList;
import java.util.Collection;

import csv_parser.src.main.java.com.iryna.entities.Student;
import csv_parser.src.main.java.com.iryna.utils.filters.GroupFilter;
import csv_parser.src.main.java.com.iryna.utils.formatters.FormatterIterator;
import csv_parser.src.main.java.com.iryna.utils.formatters.NameSurnameFormatter;
import csv_parser.src.main.java.com.iryna.utils.formatters.WelcomeWithNameFormatter;
import csv_parser.src.main.java.com.iryna.utils.generators.StudentGenerator;

// Don't foget to validate data and use common sense for common rules like:
// 1. Student can't have negative age (like -25).
// 2. Student's name can't be empty or blank string, it must have some text value
// ...
// If provided data is not valid, throw IllegalArgumentException

class csv_parser {

    public static void main(String[] params) {
        CsvManager<Student> studentDatabase = new CsvManager<Student>("students.csv", new StudentGenerator());
        studentDatabase.clearAll(); // This method should remove all content of the csv file

        Collection<Student> students = new ArrayList<Student>() {
            {
                add(Student.create("Arnold", "Schwarzenegger", 50, "IA-33"));
                add(Student.create("Jimi", "Hendrix", 60, "IA-34"));
                add(Student.create("Johnny", "Depp", 60, "IA-31"));
                add(Student.create("Marshall", "Mathers", 51, "IA-32"));
            }
        };

        studentDatabase.add(Student.create("John", "Wick", 40, "IA-31"));
        studentDatabase.add(Student.create("Harry", "Potter", 25, "IA-32"));
        studentDatabase.addAll(students);

        // Here you will get students.csv file with all students mentioned above

        System.out.println("==== DISPLAY ALL STUDENTS ====");
        Collection<Student> studentsFromDb = studentDatabase.getAll();
        for (String formattedLine : FormatterIterator.create(studentsFromDb)) {
            System.out.println(formattedLine);
        }
        /* OUTPUT:
         * ==== DISPLAY ALL STUDENTS ====
           Student Wick 40 years old
           Student Potter 25 years old
           Student Schwarzenegger 50 years old
           Student Hendrix 60 years old
           Student Depp 60 years old
           Student Mathers 51 years old
         */

        System.out.println("\n==== DISPLAY STUDENTS BY FILTER ====");
        Collection<Student> filteredStudents = studentDatabase.filter(new GroupFilter("IA-31"));
        for (String formattedLine : FormatterIterator.create(filteredStudents, new WelcomeWithNameFormatter())){
            System.out.println(formattedLine);
        }
        /*
         * OUTPUT:
         * ==== DISPLAY STUDENTS BY FILTER ====
         * Hello, I am John
         * Hello, I am Johnny
         */

        System.out.println("\n==== DISPLAY STUDENT BY INDEX ====");
        Student secondStudent = studentDatabase.findByIndex(1);
        System.out.println(secondStudent.toString(new NameSurnameFormatter()));
        /*
         * ==== DISPLAY STUDENT BY INDEX ====
         * Harry Potter
         */
    }
}
