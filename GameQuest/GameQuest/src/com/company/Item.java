package com.company;

public class Item{

    private  String description;
    private String name;
    private boolean isCrafting;
    private String crafringWith; //с чем соединяется
    private String useItem; //на что вохдействует
    private boolean takeItem=false;
    private String resultCraft;

    Item(String description, String name,boolean crafting,String useItem, String crafringWith,String resultCraft) {
        this.description = description;
        this.name = name;
        this.isCrafting = crafting;
        this.crafringWith=crafringWith;
        this.useItem = useItem;
        this.resultCraft=resultCraft;
    }

    public String getName(){
        return name;
    }

    public boolean getCrafting() {
        return isCrafting;
    }

    public String getCrafringWith() {
        return crafringWith;
    }

    public String useItem(){
        changeState();
        return resultCraft;
    }

    public boolean getState(){
        return takeItem;
    }

    public void changeState(){
        if (takeItem){
            takeItem=false ;}
        else
            takeItem=true;
    }

    public void getDiscription(){
        System.out.print(description);
    }

    public boolean getTakeItem(){
        return takeItem;
    }

    public String getResultCraft() {
        return resultCraft;
    }
}