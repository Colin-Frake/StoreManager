package assignment1;
import assignment1.items.*;

public class Store {
    private ItemList items;
    private double revenue;
    public Store(ItemList input) {
        this.items = input;
        this.revenue = 0;
    }

    public double getRevenue() {
        return this.revenue;
    }
    public ItemList getItems() {
        return items;
    }

    public void cleanUp() {
        ItemList temp = new ItemList();
        for(int i = 0; i < items.getSize(); i++) {
            if(items.getAllItems()[i] instanceof Snack) {
                Snack index = (Snack)items.getAllItems()[i];
                if(!index.isExpired()) {
                    temp.addItem(items.getAllItems()[i]);
                }
            }
        }
        items = temp;
    }

    public int completeSale(ItemList input) {
        int happiness_counter = 0;
        StoreItem[] input2 = input.getAllItems();
        for(StoreItem index : input2){
            if (index instanceof SnoozeJuice temp){
                for(StoreItem index2 : items.getAllItems()){
                    if (index2 instanceof SnoozeJuice temp2){
                        if(temp.equals(temp2)){
                            if (temp2.getNumOfBottles() >= temp.getNumOfBottles()) {
                                // Normal sale for requested quantity
                                revenue += temp.getNumOfBottles() * index.getPrice();
                                happiness_counter += temp.getNumOfBottles() * temp.getHappinessIndex();
                                temp2.getPortion(temp.getNumOfBottles()); // reduce stock by requested amount

                            } else {
                                // Partial sale for available quantity
                                revenue += temp2.getNumOfBottles() * index.getPrice();
                                happiness_counter += temp2.getNumOfBottles() * temp2.getHappinessIndex();
                                //temp2 = null;
                                items.removeItem(temp2);
                                //temp2.getPortion(temp.getNumOfBottles());
                            }
                        }
                        if(temp2.getNumOfBottles() == 0){
                            index2 = null;
                            items.removeItem(index2);
                        }
                    }
                }
            }
            if (index instanceof FizzWiz temp){
                for(StoreItem index2 : items.getAllItems()){
                    if(index2 instanceof FizzWiz temp2){
                        if(temp.equals(temp2)){
                            if (temp2.getNumOfBottles() >= temp.getNumOfBottles()) {
                                // Normal sale for requested quantity
                                revenue += temp.getNumOfBottles() * index.getPrice();
                                happiness_counter += temp.getNumOfBottles() * temp.getHappinessIndex();
                                temp2.getPortion(temp.getNumOfBottles()); // reduce stock by requested amount

                            } else {
                                // Partial sale for available quantity
                                revenue += temp2.getNumOfBottles() * index.getPrice();
                                happiness_counter += temp2.getNumOfBottles() * temp2.getHappinessIndex();
                                //temp2 = null;
                                items.removeItem(temp2);
                                //temp2.getPortion(temp.getNumOfBottles());
                            }
                        }
                        if(temp2.getNumOfBottles() == 0){
                            index2 = null;
                            items.removeItem(index2);
                        }
                    }
                }
            }
            if (index instanceof Snack temp){
                for(StoreItem index2 : items.getAllItems() ){
                    if(index.equals(index2)){
                        revenue += index.getPrice();
                        happiness_counter += index2.getHappinessIndex();
                        items.removeItem(index2);
                    }
                }
            }
        }
        return happiness_counter;
    }

    public void refillDrinkInventory(Drink[] input){
        //First condense input, cramming all the bottles into as few
        //maxed out drinks as possible

        for(int i = 0; i < input.length; i++){
            //Get rid of drinks with 0 bottles
            if(input[i].getNumOfBottles() == 0){
                Drink[] temp = new Drink[input.length - 1];
                for(int z = 0; z < i; z++){
                    temp[z] = input[z];
                }
                for(int z = i + 1; z < input.length; z++){
                    temp[z - 1] = input[z];
                }
                input = temp;
            }

            for(int j = i + 1; j < input.length; j++){
                input[i].combine(input[j]);
            }
        }

        //Combines all Drinks in store with condensed input
        for (StoreItem index : items.getAllItems()){
            if (index instanceof Drink temp){
                for(int i = 0; i < input.length; i++){
                    /**
                    if (input[i].getNumOfBottles() == 0){
                        Drink[] temp2 = new Drink[input.length - 1];
                        for(int z = 0; z < i; z++){
                            temp2[z] = input[z];
                        }
                        for(int z = i + 1; z < input.length; z++) {
                            temp2[z - 1] = input[z];
                        }

                        input = temp2;
                    }
                     **/
                    if (temp.equals(input[i])){
                        temp.combine(input[i]);
                    }
                }

            }
        }

        //Deals with leftover drinks in input
        //Recondense input
        for(int i = 0; i < input.length; i++){
            //Get rid of drinks with 0 bottles
            if(input[i].getNumOfBottles() == 0){
                Drink[] temp = new Drink[input.length - 1];
                System.arraycopy(input, 0, temp, 0, i);
                if (input.length - (i + 1) >= 0)
                    System.arraycopy(input, i + 1, temp, i + 1 - 1, input.length - (i + 1));
                input = temp;
            }
            for(int j = i + 1; j < input.length - 1; j++){
                if(input[i].equals(input[j])){
                    input[i].combine(input[j]);
                }
            }

        }
        //Add condensed input to Drink array
        //for()
        for(Drink index : input){
            items.addItem(index);
        }
    }
}
