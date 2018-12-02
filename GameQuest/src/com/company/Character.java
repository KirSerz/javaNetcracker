package com.company;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

public class Character {
    private Inventory inventory;
    private Location location;

    Character( Location location,Inventory inventory){
        this.location = location;
        this.inventory= inventory;
    }

    public void openDoor(Location newLocation){
        System.out.println("Вы вошли в "+newLocation.getName());
        location=newLocation;
    }

    public void lookAround(){
        System.out.println(location.getStateLocations());
    }

    public void takeItem(String name){

        inventory.takeItem(name);
        location.takeItem(location.setItem(name));

    }

    public String showIndentory(){
        String string;
        string=inventory.showInventory();
        return string;
        }

    public Location getlocation(){
        return location;
    }
}
