package assignment1.items;

public class Snack extends StoreItem{
    private String type;
    private MyDate DOE;
    public Snack(double p, int h, String t, MyDate D) {
        super(p,h);
        this.type = t;
        this.DOE = D;
    }

    public String getType() {
        return this.type;
    }
    public MyDate getDOE() {
        return this.DOE;
    }

    public boolean equals(Object input) {
        if(input instanceof Snack) {
            Snack input2 = (Snack)input;
            if(this.getPrice() == input2.getPrice()) {
                if(this.getHappinessIndex() == input2.getHappinessIndex()) {
                    if(this.getType() == input2.getType()) {
                        if(input2.getDOE().equals(this.DOE)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean isExpired() {
        MyDate tdy = MyDate.today();
        if(DOE.getYear() > tdy.getYear()) {
            return false;
        }
        else if (DOE.getYear() < tdy.getYear()) {
            return true;
        }
        else if (DOE.getMonth() > tdy.getMonth()) {
            return false;
        }
        else if (DOE.getMonth() < tdy.getMonth()) {
            return true;
        }
        else if (DOE.getDay() <= tdy.getDay()) {
            return true;
        }
        return false;
    }

    public int getHappinessIndex() {
        if (isExpired()) {
            return (super.getHappinessIndex()) / 2;
        }
        return super.getHappinessIndex();
    }
}
