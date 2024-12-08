

public class Employee {
    public String name;
    public double grossSalary, tax;

    public double netSalary() {
        return grossSalary - tax;
    }

    public void increaseSalary(double percentage) {
        grossSalary += (percentage / 100) * grossSalary;
    }

    public String toString() {
        return String.format("%s, $ %.2f%n", name, netSalary());
    }
}
