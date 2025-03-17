import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " (" + marks + "%)";
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 82),
                new Student("Bob", 74),
                new Student("Charlie", 90),
                new Student("David", 65),
                new Student("Eve", 78)
        );

        // Filter students scoring above 75%, sort by marks, and collect names
        List<String> topStudents = students.stream()
                .filter(s -> s.marks > 75)
                .sorted(Comparator.comparingDouble(s -> s.marks))
                .map(s -> s.name)
                .collect(Collectors.toList());

        // Display result
        System.out.println("Students scoring above 75% sorted by marks: " + topStudents);
    }
}