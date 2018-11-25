package com.company;

import java.util.ArrayList;
import java.util.ListIterator;

public class Location {
    private String name;
    private ArrayList items;
    private String stateLocation;
    private ArrayList interactiveObject;
    private String door;
    private  Item temp;
    private  InteractiveObject temp2;


    Location(String name,ArrayList items,ArrayList interactiveObject,String door){
        this.name=name;
        this.items=items;
        this.interactiveObject=interactiveObject;
        this.door=door;
    }

    public String getStateLocations(){
        String string = "Вы находитесь в " + name + " вас окружают:\n";;
//        while(itemIter.hasNext()) {
//            temp=itemIter.next();
//            System.out.println(itemIter.next().getName());
//            if (itemIter.next().getTakeItem()) {
//                string.append(itemIter.next().name()).append("\n");
//            }
//        }

        for (int i = 0; i < items.size(); i++) {
            temp = (Item)items.get(i);
            string+=(temp.getName())+"\n";
        }

        for (int i = 0; i < interactiveObject.size(); i++) {
            temp2= (InteractiveObject) interactiveObject.get(i);
            string+=(temp2.getName())+"\n";
        }

        string+= door;
//        ListIterator<ArrayList> interactiveIter = interactiveObject.listIterator();
//        while(interactiveIter.hasNext()) {
//            System.out.println(interactiveIter.next());
//            if (interactiveIter.next().toUse()) {
//                string.append(interactiveIter.next().getName()).append("\n");
//            }
//        }

//        ListIterator<Door> door = door.listIterator();
//        while(door.hasNext()) {
//            string += door.next().getPosition() + '\n';
//        }
        return string.toString();

    }
}

