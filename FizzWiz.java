package assignment1.items;

public class FizzWiz extends Drink{
    public FizzWiz(double p, int h, int n) {
        super(p, h, n, true);
    }

    public boolean equals(Object input) {
        if(input instanceof FizzWiz) {
            FizzWiz input2 = (FizzWiz)input;
            if(input2.getPrice() == this.getPrice()) {
                if(input2.getHappinessIndex() == this.getHappinessIndex()) {
                    if(input2.getBuzzy() == this.getBuzzy()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public FizzWiz getPortion(int desired) {
        if(desired <= this.getNumOfBottles()) {
            FizzWiz update = new FizzWiz(this.getPrice(),this.getHappinessIndex(),desired);
            this.bottles -= desired;
            return update;
        }
        return null;
    }
}
