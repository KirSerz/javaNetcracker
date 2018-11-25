package com.company;
import java.util.*;

public class Inventory {
    private ArrayList<Item> items;
    private Item item0;
    private static Item temp;

    Inventory(Item item1,Item item2,Item item3, Item item4,Item item5,Item item6,Item item0) {
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        item0=item0;
}
    public void showInventory(){
        ListIterator<Item> itemIter = items.listIterator();
        while(itemIter.hasNext()){
            if (itemIter.next().getTakeItem()){
                System.out.println(itemIter.next());
                }
        }
    }
    private boolean searchItem(String name){
        for (int i = 0; i < items.size(); i++) {
            temp = (Item) items.get(i);
            if (temp.getName() == item0.getName()) {
                return true;
            }
        }
        return false;
    }

    public Item setItem(String name){
        if (searchItem(name)) {
            for (int i = 0; i < items.size(); i++) {
                temp = (Item) items.get(i);
                if (temp.getName() == name) {
                    return temp;
                }
            }
        }
    return item0;
    }
}
