package entities;

public class PersonPhysics extends Person {
    private Double spentWithHealth;

    public PersonPhysics(String name, Double incomeAnual, Double spentWithHealth) {
        super(name, incomeAnual);
        this.spentWithHealth = spentWithHealth;
    }

    //inicio get e set
    public Double getSpentWithHealth() {
        return spentWithHealth;
    }

    public void setSpentWithHealth(Double spentWithHealth) {
        this.spentWithHealth = spentWithHealth;
    }
    //fim get e set

    @Override
    public Double tax() {
        if(incomeAnual < 20000.00) {
            return (0.15 * incomeAnual) - (0.5 * spentWithHealth);
        }
        else {
            return (0.25 * incomeAnual) - (0.5 * spentWithHealth);
        }
    }

    @Override
    public String toString() {
        return name + ": $ "
                + String.format("%.2f", tax());
    }
}
