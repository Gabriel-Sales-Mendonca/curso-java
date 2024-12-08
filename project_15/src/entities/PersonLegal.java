package entities;

public class PersonLegal extends Person {
    private Integer numberEmployees;

    public PersonLegal(String name, Double incomeAnual, Integer numberEmployees) {
        super(name, incomeAnual);
        this.numberEmployees = numberEmployees;
    }

    //inicio get e set
    public Integer getNumberEmployees() {
        return numberEmployees;
    }

    public void setNumberEmployees(Integer numberEmployees) {
        this.numberEmployees = numberEmployees;
    }
    //fim get e set

    public Double tax() {
        if(numberEmployees <= 10) {
            return incomeAnual * 0.16;
        }
        else {
            return incomeAnual * 0.14;
        }
    }
}
