package assignment1.items;

public class SnoozeJuice extends Drink{
    private double temp; //Celsius
    public static int HOT_COLD_BOOST;
    public SnoozeJuice(double p, int h, int n, double t) {
        super(p, h, n, false);
        this.temp = t;
    }
    public double getTemp() {
        return this.temp;
    }

    public boolean equals(Object input) {
        if(input instanceof SnoozeJuice input2) {
            if(Math.abs(input2.getPrice() - this.getPrice()) < 0.001) {
                if(input2.getBuzzy() == this.getBuzzy()) {
                    if(Math.abs(input2.getHappinessIndex() - this.getHappinessIndex()) < 0.001){
                        if(Math.abs(input2.getTemp() - this.getTemp()) < 0.001) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public int getHappinessIndex() {
        if(this.temp < 4 || this.temp > 65) {
            return 0;
        }
        MyDate tdy = new MyDate(1,2,3);
        tdy = MyDate.today();
        for(int index : MyDate.SUMMER_MONTHS) {
            if(index == tdy.getMonth()) {
                if(this.temp <= 10) {
                    return super.getHappinessIndex() + HOT_COLD_BOOST;
                }
            }
        }
        for(int index : MyDate.WINTER_MONTHS) {
            if(index == tdy.getMonth()) {
                if(55 <= this.temp && this.temp <= 65) {
                    return super.getHappinessIndex() + HOT_COLD_BOOST;
                }
            }
        }
        return super.getHappinessIndex();
    }

    public SnoozeJuice getPortion(int desired) {
        if(desired < this.getNumOfBottles()) {
            SnoozeJuice update = new SnoozeJuice(this.getPrice(), this.getHappinessIndex(), desired, this.getTemp());
            this.bottles -= desired;
            return update;
        }
        this.bottles = 0;
        return null;
    }
}
