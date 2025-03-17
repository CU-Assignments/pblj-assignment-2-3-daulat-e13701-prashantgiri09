import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', age=" + age + ", salary=" + salary + "}";
    }
}

public class EmployeeSorter {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 30, 50000));
        employees.add(new Employee("Bob", 25, 60000));
        employees.add(new Employee("Charlie", 35, 55000));

        // Sort by name
        employees.sort(Comparator.comparing(e -> e.name));
        System.out.println("Sorted by Name: " + employees);

        // Sort by age
        employees.sort(Comparator.comparingInt(e -> e.age));
        System.out.println("Sorted by Age: " + employees);

        // Sort by salary
        employees.sort(Comparator.comparingDouble(e -> e.salary));
        System.out.println("Sorted by Salary: " + employees);
    }
}
