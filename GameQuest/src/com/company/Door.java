package com.company;

public class Door {

    private  Location location ;
    private  String position;

    Door(Location location,String position){
        this.location=location;
        this.position=position;
    }

    public Location openDoor(){
        String string="Вы перешли в "+ location.getName();
        return location;
    }

    public String getPosition(){
        return position;
    }
}