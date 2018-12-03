package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Location {
    private String name;
    private List listItems;
    private ArrayList interactiveObjects;
    private List doors;
    private   String temp;
    private   InteractiveObject temp2;
    private   InteractiveObject interactiveObject0;
    private   String nameItem;

    Location(String name ,List listItems, ArrayList interactiveObjects,
             List doors){
        this.name=name;
        this.listItems=listItems;
        this.interactiveObjects=interactiveObjects;
        this.doors=doors;
    }

    public String getName(){
        return name;
    }

    public void getListItem(){
        System.out.println(listItems);
    }

    public String getStateLocations(){
        String string = "Вы находитесь в " + name + " вас окружают:\n";;
        for (int i = 0; i < listItems.size(); i++) {
            temp = (String) listItems.get(i);
            string+="\t"+temp+"\n";
        }
        for (int i = 0; i < interactiveObjects.size(); i++) {
            temp2= (InteractiveObject) interactiveObjects.get(i);
            string+="\t"+(temp2.getName())+"\n";
        }
        string+="Положение дверей:\n";
        for (int i = 0; i < doors.size(); i++) {
            string+="\t"+(String)doors.get(i)+"\n";
        }
        return string.toString();
    }

    // возвращает объект предмет по имени
    public String setItem(String name){
        for (int i = 0; i < listItems.size(); i++) {
            temp = (String)listItems.get(i);
            if (temp.equals(name)) {
                nameItem=temp;
            }
        }
        return nameItem;
    }

    //      удаляем предмет из локации
    public void takeItem(String name){
        Iterator<String> iter = listItems.iterator();
        while (iter.hasNext()) {
            String s = iter.next();
            if (s.equals(name)) {
                iter.remove();
                System.out.println("Вы подняли '"+name+"'");
            }
        }
    }

    //    поиск предмета на локации
    public boolean searchItem(String name){
        for (int i = 0; i < listItems.size(); i++) {
            temp = (String) listItems.get(i);
            if (temp.equals(name)) {
                System.out.println("Предмет "+name+" находится на локации");
                return true;
            }
        }
        return false;
    }

    // возвращает интерактивый предмет по имени
    public InteractiveObject setInteractiveObject(String name){
            for (int i = 0; i < interactiveObjects.size(); i++) {
                temp2 = (InteractiveObject) interactiveObjects.get(i);
                if (temp2.getName().equals(name)) {
                    interactiveObject0=temp2;
                }
            }
        return interactiveObject0;
    }

    //      меняет состояние интерактивного предмета
    public boolean useInteractiveObject(String itemName,String interactiveObjectName){
        InteractiveObject interactiveObject=setInteractiveObject(interactiveObjectName);
        interactiveObject.changeState(itemName);
        return interactiveObject.getIsUse();
    }

    //    поиск интерактивного предмета на локации
    public boolean searchInteractiveObject(String name){
        for (int i = 0; i < interactiveObjects.size(); i++) {
            temp2 = (InteractiveObject) interactiveObjects.get(i);
            if (temp2.getName().equals(name)) {
                System.out.println("Предмет "+name+" находится на локации");
                return true;
            }
        }
        System.out.println("Здесь такова предмета нет");
        return false;
    }

    public boolean searchDoor(String positionDoor){
        for (int i = 0; i < doors.size(); i++) {
            temp = (String) doors.get(i);
            if (temp.equals(positionDoor)) {
                return true;
            }
        }
        return false;
    }
}

//    Item item6=new Item("ведро со студенной водой",             "ведро с водой",false,"волшебник","",null);
//    Item item5=new Item("ведро с приваренной цепью",            "ведро с цепью",true,"колодец","",null);
//    Item item4=new Item("ведро с хлипко намотанной цепью",      "цепь и ведро",true,"горелка","",null);
//    Item item1=new Item("односолодовый виски, полупустая бутылка","виски",false,"нельзя сотворить","", null);
//    Item item2=new Item("пустое ведро",                         "ведро",true,"цепь","цепь",item4.getName());
//    Item item3=new Item("крепкая цепь",                         "цепь",true,"ведро","ведро",item4.getName());
//    Item item0=new Item("сколько бы вы не искали в своих карманах предметы, внутри лишь пустота в которую не стоит подолгу смотреть","пустота",false,null,null,null);