package entities;

public class ImportedProduct extends Product {
    private Double customsFee;
    
    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    //inicio get e set
    public Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }
    //fim get e set


    public Double totalPrice() {
        return customsFee + price;
    }

    @Override
    public String priceTag() {
        return name + " $ " + String.format("%.2f", totalPrice())
                + " (Customs fee: $ " + String.format("%.2f", customsFee) + ")";
    }
}
