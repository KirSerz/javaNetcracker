package com.company;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

public class Character {
    private Inventory inventory;
    private static Item hand;
    private Location location;

    Character( Location location,Inventory inventory){
        this.location = location;
        this.inventory= inventory;
    }

    public void openDoor(Location location){
        location=location;
    }

    public void lookAround(){
        System.out.println(location.getStateLocations());
    }

    public void useInventory(){
        inventory.showInventory();

    }
    public String takeItem(){
        String string="";
        return string;
    }
    public void showIndentory(){
        inventory.showInventory();
        }
}
