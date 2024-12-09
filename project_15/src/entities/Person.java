package entities;

public abstract class Person {
    protected String name;
    protected Double incomeAnual;

    public Person(String name, Double incomeAnual) {
        this.name = name;
        this.incomeAnual = incomeAnual;
    }

    //inicio get e set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getIncomeAnual() {
        return incomeAnual;
    }

    public void setIncomeAnual(Double incomeAnual) {
        this.incomeAnual = incomeAnual;
    }
    //fim get e set

    public abstract Double tax();
}
