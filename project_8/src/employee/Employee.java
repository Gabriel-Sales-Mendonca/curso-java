package employee;

public class Employee {
    private int id;
    private String name;
    private double salary;

    // inicio get e set
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    // fim get e set


    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void increaseSalary(double percentage) {
        double newSalary = getSalary() + (percentage / 100 * getSalary());
        setSalary(newSalary);
    }
}
