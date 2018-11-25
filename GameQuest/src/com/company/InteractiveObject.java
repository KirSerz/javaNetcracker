package com.company;

public class InteractiveObject{
    private  static String state;
    private  static String changeState;
    public String name;
    private static boolean toUse;
    private  static Item contacteWith;

    InteractiveObject(String state, String changeState, String name, Item contacteWith){
        this.state=state;
        this.contacteWith=contacteWith;
        this.name=name;
        this.changeState=changeState;
        this.toUse=false;
    }

    public static void use(){
        System.out.println(state);
    }
    public boolean toUse(){
        return toUse;
    }
    public String getName(){
        return name;
    }

    public static void changeState(Item item){
        if (!toUse){
            if (item.equals(contacteWith)){
                toUse=true;
                state=changeState;
                System.out.println(state);
            }else System.out.println("действие не возымело эфекта");
        }else System.out.println("действие уже было совершенно");
    }
}