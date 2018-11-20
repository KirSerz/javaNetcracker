package com.company;

import javax.xml.stream.Location;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Inventory inventory=new Inventory();

        InteractiveObject interactiveObject1 = new InteractiveObject("обычная спиртовая горелка","горелка накрепко скрепляет ведро и цепь","горелка",inventory.item4);
        InteractiveObject interactiveObject2 = new InteractiveObject("спящий маг. Наверно всему виной тот виски","Волшебник просыпается и одаривая вас холодным, как вода в колодце, взгядом протягивает кристал что все время лежал под подушкой","маг",inventory.item6);
        InteractiveObject interactiveObject3 = new InteractiveObject("зеленая лягушка. не примечательна","лягушка с большой радостью пьет виски, возможно когда-то она была человеком","лягушка",inventory.item1);
        InteractiveObject interactiveObject4 = new InteractiveObject("глубокий колодец","Вы коекак вытаскиваете полное ведро воды. На ум приходят мысли о спортзале.","колодец",inventory.item5);

        ArrayList<InteractiveObject>  atticInteractiveObject1= new ArrayList<InteractiveObject>();
        atticInteractiveObject1.add(interactiveObject1);
        ArrayList<InteractiveObject>  roomInteractiveObject1= new ArrayList<InteractiveObject>();
        roomInteractiveObject1.add(interactiveObject2);
        ArrayList<InteractiveObject>  gardenInteractiveObject1= new ArrayList<InteractiveObject>();
        gardenInteractiveObject1.add(interactiveObject3);
        gardenInteractiveObject1.add(interactiveObject4);

        ArrayList<Item>  attic= new ArrayList<Item>();
        attic.add(inventory.item1);
        ArrayList<Item>  room= new ArrayList<Item>();
        room.add(inventory.item1);
        room.add(inventory.item2);
        ArrayList<Item>  garden= new ArrayList<Item>();
        garden.add(inventory.item1);
        garden.add(inventory.item1);

        Location location1=new Location("Чердак",gardenInteractiveObject1,attic,"вниз");
        Location location2=new Location("Комната",gardenInteractiveObject1,attic,"вверх/запад");
        Location location3=new Location("Сад",gardenInteractiveObject1,attic,"восток");

        Door door1=new Door(location2,"вниз");
        Door door2=new Door(location1,"вверх");
        Door door3=new Door(location3,"запад");
        Door door4=new Door(location2,"восток");

        Character character=new Character(location2);

    }

    public static class Location {
        private static String name;
        private static ArrayList items;
        private static String stateLocation;
        private static ArrayList interactiveObject;
        private static String door;
        Location(String name,ArrayList items,ArrayList interactiveObject,String door){
            name=name;
            items=items;
            interactiveObject=interactiveObject;
            door=door;
        }
        public static String getStateLocations(){
            String string = "Вы находитесь в "+name+"вас окружают:";
            return string;
        }
    }

    public static class InteractiveObject{
        private static String state;
        private static String changeState;
        private static String name;
        private static boolean toUse=false;
        private static Item contacteWith;

        InteractiveObject(String state,String changeState,String name,Item contacteWith){
            state=state;
            name=name;
            contacteWith=contacteWith;
        }
        public static void use(){
            System.out.println(state);
        }
        public static void changeState(Item item){
           if (toUse==false){
               if (item.equals(contacteWith)){
                toUse=true;
                state=changeState;
                System.out.println(state);
            }else System.out.println("действие не возымело эфекта");
           }else System.out.println("действие уже было совершенно");
        }
    }

    public static class Item{
        private static String description;
        private static String name;
        private static String crafringWith; //с чем соединяется
        private static String useItem; //на что вохдействует
        private static boolean takeItem;
        private static boolean crafring;

        Item(String description, String name,boolean crafting,String useItem, String crafringWith) {
            description = description;
            name = name;
            crafting = crafting;
            crafringWith=crafringWith;
            useItem = useItem;
            takeItem = false;
        }

        public static String useItem(Item item){
            String string="";
            return string;
        }
        public static String setState(){
            takeItem=false;
            String string="";
            return string;
        }
    }

    public static class Door {

        private static Location location ;
        private static String position;
        Door(Location location,String position){
        }
        public static Location openDoor(){
            String string="";
            return location;
        }
    }

    public static class Inventory {
        Item item1=new Item("односолодовый виски, полупустая бутылка","виски",false,"нельзя сотворить","" );
        Item item2=new Item("пустое ведро",                         "ведро",true,"цепь","цепь");
        Item item3=new Item("крепкая цепь",                         "цепь",true,"ведро","ведро");
        Item item4=new Item("цепь и ведро",                          "ведро",true,"горелка","");
        Item item5=new Item("ведро с цепью",                        "ведро",true,"колодец","");
        Item item6=new Item("ведро с водой",                        "ведро",false,"волшебник","");
    }

    public static class Character {
        private static Inventory inventory = new Inventory();
        private static Item hand;
        private static Location location;

        Character( Location location){
            location=location;
        }
        public static void openDoor(Location location){
            location=location;
        }
        public static void lookAround(){
            location.getStateLocations();
        }

        public static String useInventory(){
            String string="";
            return string;
        }
        public static String takeItem(){
            String string="";
            return string;
        }
    }


}
