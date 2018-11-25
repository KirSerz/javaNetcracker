package com.company;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String action;
        boolean help=true;
        Item item1=new Item("односолодовый виски, полупустая бутылка","виски",false,"нельзя сотворить","" );
        Item item2=new Item("пустое ведро",                         "ведро",true,"цепь","цепь");
        Item item3=new Item("крепкая цепь",                         "цепь",true,"ведро","ведро");
        Item item4=new Item("цепь и ведро",                          "ведро",true,"горелка","");
        Item item5=new Item("ведро с цепью",                        "ведро",true,"колодец","");
        Item item6=new Item("ведро с водой",                        "ведро",false,"волшебник","");
        Item item0=new Item("сколько бы вы не искали в своих карманах предметы, внутри лишь пустота в которую не стоит подолгу смотреть",                        "пустота",false,"none","none");
        Inventory inventory=new Inventory(item1,item2,item3,item4,item5,item6,item0);

        InteractiveObject interactiveObject1 = new InteractiveObject("обычная спиртовая горелка","горелка накрепко скрепляет ведро и цепь","горелка",item4);
        InteractiveObject interactiveObject2 = new InteractiveObject("спящий маг. Наверно всему виной тот виски","Волшебник просыпается и одаривая вас холодным, как вода в колодце, взгядом протягивает кристал что все время лежал под подушкой","маг",item6);
        InteractiveObject interactiveObject3 = new InteractiveObject("зеленая лягушка. не примечательна","лягушка с большой радостью пьет виски, возможно когда-то она была человеком","лягушка",item1);
        InteractiveObject interactiveObject4 = new InteractiveObject("глубокий колодец","Вы коекак вытаскиваете полное ведро воды. На ум приходят мысли о спортзале.","колодец",item5);

        ArrayList<InteractiveObject> atticInteractiveObject1= new ArrayList<InteractiveObject>();
        atticInteractiveObject1.add(interactiveObject1);
        ArrayList<InteractiveObject>  roomInteractiveObject1= new ArrayList<InteractiveObject>();
        roomInteractiveObject1.add(interactiveObject2);
        ArrayList<InteractiveObject>  gardenInteractiveObject1= new ArrayList<InteractiveObject>();
        gardenInteractiveObject1.add(interactiveObject3);
        gardenInteractiveObject1.add(interactiveObject4);

        ArrayList<Item>  attic= new ArrayList<Item>();
        attic.add(item1);
        ArrayList<Item>  room= new ArrayList<Item>();
        room.add(item1);
        room.add(item2);
        ArrayList<Item>  garden= new ArrayList<Item>();
        garden.add(item2);
        garden.add(item3);

        Location location1=new Location("Чердак",attic,atticInteractiveObject1,"вниз");
        Location location2=new Location("Комната",room,roomInteractiveObject1,"вверх\nзапад");
        Location location3=new Location("Сад",garden,gardenInteractiveObject1,"восток");

        Door door1=new Door(location2,"вниз");
        Door door2=new Door(location1,"вверх");
        Door door3=new Door(location3,"запад");
        Door door4=new Door(location2,"восток");

        System.out.println("Туториал\nЗдравствуйте, эта игра - текстовый квест. вводя указанные команды на экране вы способны\n " +
                            "взаимодействовать с окружающим миром. Ваша цель - разбудить мага, празновавшего свое\n " +
                            "деньрождение в одиночестве. Сделайте все возможное! От вас зависит судьба этого мира");
        Character character=new Character(location2,inventory);
        Scanner input = new Scanner(System.in);
        while (true){

            System.out.println("Ваши действия?\n" +
                    "-> осмотреться   (осмотреться)\n" +
                    "-> изучить   (изучить ***)\n" +
                    "-> идти    (идти запад)\n" +
                    "-> поднять вещь    (поднять)\n" +
                    "-> использовать предмет    (использовать ***)\n" +
                    "-> заглянуть в инвентарь   (инвентарь)\n" +
                    "-> взять вещь из инвентаря (достать ***)");
            if (help==true) {
                System.out.println("  *введите в консоль желаемую команду пример(взять виски),чтобы скрыть/показать подсказку введите 'помощь'");
            }

            action = input.nextLine();

            if (action.equals("помощь")){
                System.out.print(action);
                if (help==true){
                    help=false;}
                else
                    help=true;
            }
            else if (action.equals("осмотреться")){
                character.lookAround();
            }
            else if (action.equals("поднять")){

            }
            else if (action.equals("использовать")){

            }
            else if (action.equals("инвентарь")){
                character.useInventory();
            }
            else if (action.equals("достать")){

            }

        }

    }
}
