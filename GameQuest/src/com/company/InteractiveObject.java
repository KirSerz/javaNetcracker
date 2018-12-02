package com.company;

public class InteractiveObject{
    private   String state;
    private   String changeState;
    public String name;
    private  boolean isUse;
    private   String contacteWith;

    InteractiveObject(String state, String changeState, String name, String contacteWith){
        this.state=state;
        this.contacteWith=contacteWith;
        this.name=name;
        this.changeState=changeState;
        this.isUse=false;
    }

    public void getDiscription(){
        System.out.print(state);
    }

    public  boolean getIsUse() {
        return isUse;
    }

    public void toUse(){
        if (isUse){
            isUse=false ;}
        else
            isUse=true;
    }

    public String getName(){
        return name;
    }

    public void changeState(String item){
        if (!isUse){
            if (item.equals(contacteWith)){
                isUse=true;
                state=changeState;
                System.out.println(state);
            }else System.out.println("действие не возымело эфекта");
        }else System.out.println("действие уже было совершенно");
    }
}