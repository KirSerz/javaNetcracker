package com.company;

public class Item{
    private  String description;
    private String name;
    private String crafringWith; //с чем соединяется
    private String useItem; //на что вохдействует
    private boolean takeItem;
    private boolean crafring;

    Item(String description, String name,boolean crafting,String useItem, String crafringWith) {
        this.description = description;
        this.name = name;
        crafting = crafting;
        this.crafringWith=crafringWith;
        this.useItem = useItem;
        takeItem = false;
    }

    public String getName(){
        return name;
    }

    public String useItem(Item item){
        String string="";
        return string;
    }
    public String setState(){
        takeItem=false;
        String string="";
        return string;
    }
    public void getDiscription(){
        System.out.print(description);
    }
    public boolean getTakeItem(){
        return takeItem;
    }
}