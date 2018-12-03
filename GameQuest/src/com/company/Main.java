package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String tempString;
        String action;
        String[] imputString;
        Location location;
        boolean help=true;
        boolean isEndGame=false;
        Item item7=new Item("Магический кристалл невероятной силы",  "кристал",false,"кристал",null,null);
        Item item6=new Item("Ведро со студенной водой",             "ведро_с_водой",false,"волшебник","",item7.getName());
        Item item5=new Item("Ведро с приваренной цепью",            "ведро_с_цепью",true,"колодец","",item6.getName());
        Item item4=new Item("Ведро с хлипко намотанной цепью",      "цепь_и_ведро",true,"горелка","",item5.getName());
        Item item1=new Item("Односолодовый виски, полупустая бутылка","виски",false,"нельзя сотворить","", null);
        Item item2=new Item("Пустое ведро",                         "ведро",true,"цепь","цепь",item4.getName());
        Item item3=new Item("Крепкая цепь",                         "цепь",true,"ведро","ведро",item4.getName());


        ArrayList<Item> items=new ArrayList<Item>();
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);
        Inventory inventory=new Inventory(items);

        InteractiveObject interactiveObject1 = new InteractiveObject("обычная спиртовая горелка","горелка накрепко скрепляет ведро и цепь","горелка",item4.getName());
        InteractiveObject interactiveObject2 = new InteractiveObject("спящий волшебник. Наверно всему виной тот виски","Волшебник просыпается и одаривая вас холодным, как вода в колодце, взгядом протягивает кристал который все это время лежал под подушкой","волшебник",item6.getName());
        InteractiveObject interactiveObject3 = new InteractiveObject("зеленая лягушка. не примечательна","лягушка с большой радостью пьет виски, возможно когда-то она была человеком","лягушка",item1.getName());
        InteractiveObject interactiveObject4 = new InteractiveObject("глубокий колодец","Вы коекак вытаскиваете полное ведро воды. На ум приходят мысли о спортзале.","колодец",item5.getName());

        ArrayList<InteractiveObject> atticInteractiveObject= new ArrayList<InteractiveObject>();
        atticInteractiveObject.add(interactiveObject1);
        ArrayList<InteractiveObject>  roomInteractiveObject= new ArrayList<InteractiveObject>();
        roomInteractiveObject.add(interactiveObject2);
        ArrayList<InteractiveObject>  gardenInteractiveObject =new ArrayList<InteractiveObject>();
        gardenInteractiveObject.add(interactiveObject3);
        gardenInteractiveObject.add(interactiveObject4);

        List<String>  roomListItem= new ArrayList<String>();
        roomListItem.add(item1.getName());
        roomListItem.add(item2.getName());

        List<String>  atticListItem= new ArrayList<String>();

        List<String>  gardenListItem= new ArrayList<String>();
        gardenListItem.add(item3.getName());

        List<String>  listDoorOnAttic= new ArrayList<String>();
        listDoorOnAttic.add("вниз");
        List<String>  listDoorOnRoom= new ArrayList<String>();
        listDoorOnRoom.add("вверх");
        listDoorOnRoom.add("запад");
        List<String>  listDoorOnGarden= new ArrayList<String>();
        listDoorOnGarden.add("восток");

        Location atticLocation=new Location("Чердак",   atticListItem,  atticInteractiveObject, listDoorOnAttic);
        Location roomLocation=new Location("Комната",  roomListItem,   roomInteractiveObject,  listDoorOnRoom);
        Location gardenlocation=new Location("Сад",      gardenListItem, gardenInteractiveObject,listDoorOnGarden);
        Door door1=new Door( atticLocation ,"вверх");
        Door door2=new Door(roomLocation,"вниз");
        Door door3=new Door(gardenlocation,"запад");
        Door door4=new Door(roomLocation,"восток");

        System.out.println("\n\nЗдравствуйте, эта игра - текстовый квест. Вводя указанные команды на экране вы способны\n " +
                            "взаимодействовать с окружающим миром. Ваша цель - разбудить волшебника, празновавшего свое\n " +
                            "день рождение в полном одиночестве. Сделайте все возможное! От вас зависит судьба этого мира!\n");

        Character character=new Character(roomLocation,inventory);
        character.lookAround();
        Scanner input = new Scanner(System.in);
        while (!isEndGame){

            System.out.println("\nВаши действия?\n" +
                    "\t-> осмотреться   (осмотреться)\n" +
                    "\t-> изучить   (изучить ***)\n" +
                    "\t-> идти    (идти ***)\n" +
                    "\t-> взять  вещь    (взять ***)\n" +
                    "\t-> заглянуть в инвентарь   (инвентарь)\n" +
                    "\t-> достать вещь из инвентаря (достать ***)");
            if (help==true) {
                System.out.println("  *введите в консоль желаемую команду пример(взять виски), звездочки означают предмет с которым вы предположительно будете взаимодействовать," +
                        "\t\nчтобы скрыть/показать подсказку введите 'помощь'");
            } else System.out.println("\t-> вызвать подсказку (помощь)");
            System.out.print("\n\t->");
            action = input.nextLine();
            imputString=action.split("( )");
                        location=character.getlocation();
            if (imputString[0].equals("помощь")){
                if (help==true){
                    help=false;}
                else
                    help=true;
            }
            else if (imputString[0].equals("осмотреться")){
                character.lookAround();
            }
            else if (imputString[0].equals("взять")){
                if (imputString.length==1){
                    System.out.println("Нужно ввести значение");
                }else
                    character.takeItem(imputString[1]);
            }
            else if (imputString[0].equals("идти")){
                if (imputString.length==1){
                    System.out.println("Нужно ввести значение");
                }else {
                    if (location.searchDoor(imputString[1])) {
                        System.out.println(imputString[1]);
                        if (imputString[1].equals(door1.getPosition())) {
                            character.openDoor(door1.openDoor());
                        } else if (imputString[1].equals(door2.getPosition())) {
                            character.openDoor(door2.openDoor());
                        } else if (imputString[1].equals(door3.getPosition())) {
                            character.openDoor(door3.openDoor());
                        } else if (imputString[1].equals(door4.getPosition())) {
                            character.openDoor(door4.openDoor());
                        }
                        character.lookAround();
                    } else System.out.println("Вы не можете туда пойти.");
                }
            }
            else if (imputString[0].equals("инвентарь")){
                if (!character.showIndentory().equals("")){
                    System.out.println(character.showIndentory());
                }
                else System.out.println("\tИнвентарь пуст");
            }
            else if (imputString[0].equals("достать")){
                if (imputString.length==1){
                    System.out.println("Нужно ввести значение");
                }else{
                    if (inventory.searchItem(imputString[1])) {
                        System.out.println("\tВы берете в руки '"+imputString[1]+"'");
                        System.out.print("\tИспользовать '"+imputString[1]+"' на ");
                        System.out.print("\t-> ");
                        action = input.nextLine();
                        if(inventory.searchItem(action)){
                            if(inventory.setItem(action).getCrafting()){
                                if(imputString[1].equals(inventory.setItem(action).getCrafringWith())){
                                    tempString=inventory.setItem(action).useItem();
                                    inventory.takeItem(tempString);

                                    System.out.println("Вы сотворили '"+tempString+"'!");
                                    inventory.takeItem(imputString[1]);
                                }
                            }
                        }else if(location.searchInteractiveObject(action)){
                            if(location.useInteractiveObject(imputString[1],action)){
                                inventory.setItem(imputString[1]).changeState();
                                tempString=inventory.setItem(imputString[1]).getResultCraft();
                                inventory.takeItem(tempString);
                                inventory.takeItem(imputString[1]);
                                System.out.println("Вы сотворили '"+tempString+"'!");
                            }
                        }else {
                            System.out.println("\t'"+action+"' отсутствует");
                        }
                    } else  {System.out.println("\tУ вас нет'"+imputString[1]+"'");
                    }
                }
            }
            else if (imputString[0].equals("изучить")){
                if (imputString.length==1){
                    System.out.println("Нужно ввести значение");
                }else {
                    if (location.searchItem(imputString[1])||inventory.searchItem(imputString[1])) {
                        inventory.setItem(imputString[1]).getDiscription();
                    } else if (location.searchInteractiveObject(imputString[1])) {
                        location.setInteractiveObject(imputString[1]).getDiscription();
                    } else {
                        System.out.println("В " + location.getName() + " нет такова предмета");
                    }
                }
            }
        if (interactiveObject2.getIsUse())
            {
                isEndGame=true;
            }
        }System.out.println("Победа! Поздравляем!");
    }
}
