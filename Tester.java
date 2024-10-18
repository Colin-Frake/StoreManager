package assignment1;

import assignment1.items.SnoozeJuice;
import assignment1.items.FizzWizz;
import assignment1.items.Snack;
import assignment1.items.MyDate;
import assignment1.items.Drink;
import assignment1.items.StoreItem;

public class Tester {
	public static void main(String[] args) {
		ItemList test = new ItemList();
		Drink.MAX_PACK_SIZE = 6;
		SnoozeJuice drink1 = new SnoozeJuice(2,50,3,15);
		FizzWizz drink2 = new FizzWizz(5,75,3);
		test.addItem(drink1);
		test.addItem(drink2);		

		SnoozeJuice drink3 = new SnoozeJuice(2,50,4,15);
		SnoozeJuice drink4 = new SnoozeJuice(2,50,4,15);
		Drink[] test1 = {drink3, drink4};

		Store test0 = new Store(test);
		/** 
		drink3.combine(drink4);
		System.out.println("Drink 3: " + drink3.getNumOfBottles());
		System.out.println("Drink 4: " + drink4.getNumOfBottles());
		**/
		
		test0.refillDrinkInventory(test1);
		ItemList output = test0.getItems();
		StoreItem[] output2 = output.getAllItems();
		for(StoreItem index : output2){
			if(index instanceof Drink){
				Drink output3 = (Drink)index;
				System.out.println("Item type: " + index.getClass() + " Number of bottles: " + output3.getNumOfBottles());
			}
			
		}
		
		
	}
}
