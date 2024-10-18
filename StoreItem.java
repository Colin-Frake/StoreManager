package assignment1.items;

public abstract class StoreItem {
    private double price;
    private int happiness;
    String errMsg = "Invalid input";
    public StoreItem(double p, int h) {
        this.price = p;
        this.happiness = h;
        if(p < 0 || h < 0) {
            throw new IllegalArgumentException(errMsg);
        }
    }

    public final double getPrice() {
        return this.price;
    }

    public int getHappinessIndex() {
        return this.happiness;
    }

    public boolean equals(Object input) {
        if(input instanceof StoreItem input2) {
            if(Math.abs(this.price - input2.getPrice()) < 0.001) {
                if(Math.abs(this.happiness - input2.getHappinessIndex()) < 0.001) {
                    return true;
                }
            }
        }

        return false;
    }
}
