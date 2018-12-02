package com.company;
import java.util.*;

public class Inventory {

    private ArrayList<Item> items;
    private Item buffIntem;
    private  Item temp;

    Inventory(ArrayList items) {
        this.items = items;
    }

    public ArrayList getItems(){
        return items;

    }

//    выводит инвентарь на экран
    public String showInventory(){
        String string="У вас есть:";
        for (Item itemIter : items) {
            if (itemIter.getTakeItem()){
                string+="\t"+itemIter.getName()+"\n";
                }
        }
        return string;
    }

    // возвращает предмет по имени
    public Item setItem(String name){
        if (searchItem(name)) {
            for (int i = 0; i < items.size(); i++) {
                temp = (Item) items.get(i);
                if (temp.getName().equals(name)) {
                    return temp;
                }
            }
        }else{
            System.out.println("Здесь такова предмета нет");
        }
            return buffIntem;
    }

//      меняет состояние предмета
    public void takeItem(String name){
        Item item=setItem(name);
        item.changeState();
    }

//    поиск предмета в инвентаре
    public boolean searchItem(String name){
        for (int i = 0; i < items.size(); i++) {
            temp = (Item) items.get(i);
            if (temp.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void craft(String name1, String name2){
        for (Item itemIter : items) {
            if (itemIter.getName()==name1){
                itemIter.getTakeItem();
            }else if ( itemIter.getName()==name2){
                itemIter.getTakeItem();
            }
        }
    }
}
