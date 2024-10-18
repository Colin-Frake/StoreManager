package assignment1.items;

public abstract class Drink extends StoreItem{
    public static int MAX_PACK_SIZE;
    public static int BUZZY_HAPPINESS_BOOST;
    protected int bottles;
    private boolean isBuzzy;
    public Drink(double p, int h, int n, boolean b) {
        super(p, h);
        this.bottles = n;
        this.isBuzzy = b;
        if(n > MAX_PACK_SIZE){
            throw new IllegalArgumentException("More bottles than allowed");
        }
        if(n < 0){
            throw new IllegalArgumentException("Cannot have negative bottles");
        }
    }

    public int getNumOfBottles() {
        return this.bottles;
    }

    public boolean getBuzzy() {
        return this.isBuzzy;
    }

    public boolean equals(Object input) {
        if(input instanceof Drink) {
            Drink input2 = (Drink)input;
            if(Math.abs(input2.getPrice() - this.getPrice()) < 0.001) {
                if(Math.abs(input2.getHappinessIndex() - this.getHappinessIndex()) < 0.001) {
                    if(this.isBuzzy == input2.getBuzzy()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int getHappinessIndex() {
        if(isBuzzy) {
            return(super.getHappinessIndex() + BUZZY_HAPPINESS_BOOST);
        }
        return super.getHappinessIndex();
    }

    public boolean combine(Drink input) {
        if(this.equals(input)) {
            if(this.bottles == MAX_PACK_SIZE) {
                return false;
            }
            if(input.getNumOfBottles() + this.bottles <= MAX_PACK_SIZE) {
                this.bottles += input.getNumOfBottles();
                input.bottles = 0;
                return true;
            }
            input.bottles -= MAX_PACK_SIZE - this.bottles;
            this.bottles = MAX_PACK_SIZE;
            return true;
        }
        return false;
    }

    public abstract Drink getPortion(int input);
}
