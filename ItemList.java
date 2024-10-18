package assignment1;
import assignment1.items.StoreItem;

public class ItemList {
    private StoreItem[] items;
    public ItemList() {
        items = new StoreItem[0];
    }

    public int getSize() {
        return items.length;
    }

    public StoreItem[] getAllItems() {
        return items;
    }

    public void addItem(StoreItem input) {
        StoreItem[] temporary = new StoreItem[items.length + 1];
        for(int i = 0; i < items.length; i++) {
            temporary[i] = items[i];
        }
        temporary[temporary.length - 1] = input;
        items = temporary;
    }

    public StoreItem removeItem(StoreItem input) {
        StoreItem temp = input;
        for(int i = 0; i < items.length; i++) {
            if(items[i].equals(input)) {
                temp=items[i];
                StoreItem[] temporary = new StoreItem[items.length - 1];

                for(int j = 0; j < items.length - 1; j++){
                    if(j < i){
                        temporary[j] = items[j];
                    }
                    else{
                        temporary[j] = items[j + 1];
                    }
                }
                items = temporary;
                return temp;
            }
        }
        return null;
    }

    public StoreItem[] findEqualItems(StoreItem input) {
        StoreItem[] tracker = new StoreItem[0];
        for (StoreItem index : items) {
            if(index.equals(input)) {
                StoreItem[] temporary = new StoreItem[tracker.length + 1];
                for(int i = 0; i < tracker.length; i++) {
                    temporary[i] = tracker[i];
                }
                if(tracker.length == 0) {
                    temporary[0] = index;
                }
                else {
                    temporary[tracker.length - 1] = index;
                }
                tracker = temporary;

            }
        }
        return tracker;
    }
}
