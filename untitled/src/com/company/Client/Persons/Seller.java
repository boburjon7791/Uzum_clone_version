package com.company.Client.Persons;

import com.company.Client.ScannerUtil.scannerUtil;
import com.company.Client.menu.menu;
import com.company.Server.Enums.GoodsType;
import com.company.Server.Enums.Sex;
import com.company.Server.Models.Goods;
import com.company.Server.Models.Users;
import com.company.Server.Service.Service;

import java.util.List;

public class Seller {
    public void sellerPage(Users users) throws IllegalArgumentException {
        do {
            System.out.println("Seller page");
            System.out.println("***");
            System.out.println("""
                    1. Create goods
                    2. Edit goods
                    3. Delete goods
                    4. View goods
                    5. Edit profile
                    6. Delete profile
                    7. Logout
                    """);
            System.out.println("***");
            String str = scannerUtil.scannerSTR.nextLine();
            if(str.equals("7")){
                break;
            }
            boolean stop = false;
            switch (str) {
                case "1" -> {
                    Goods goods = new Goods();

                    System.out.println("Input name");
                    goods.setName(scannerUtil.scannerSTR.nextLine());

                    System.out.println("Input price");
                    goods.setPrice(scannerUtil.scannerNUM.nextDouble());

                    System.out.println("Input quantity");
                    goods.setQuantity(scannerUtil.scannerNUM.nextDouble());

                    System.out.println("Select type");
                    int i = 0;
                    for (; i < GoodsType.values().length; i++) {
                        System.out.println((i + 1) + "." + GoodsType.values()[i]);
                    }
                    int type = scannerUtil.scannerNUM.nextInt();
                    goods.setGoodsType(GoodsType.values()[type - 1]);

                    System.out.println("Input comment");
                    goods.setComments(scannerUtil.scannerSTR.nextLine());

                    Service service = new Service();
                    boolean addedGood = service.createGoods(users, goods);
                    if(addedGood){
                        System.out.println("Good added");
                    }else{
                        System.out.println("Failed to add");
                    }
                }
                case "2" -> {
                    Service service = new Service();
                    Goods oldGoods = new Goods();
                    Goods newGoods = new Goods();
                    List<Goods> goodsList = service.showGoods(users);
                    for (int i = 0; i < goodsList.size(); i++) {
                        System.out.println((i + 1) + ". " + goodsList.get(i));
                    }
                    oldGoods = goodsList.get(scannerUtil.scannerNUM.nextInt());
                    System.out.println("Input name");
                    newGoods.setName(scannerUtil.scannerSTR.nextLine());
                    System.out.println("Input price");
                    newGoods.setPrice(scannerUtil.scannerNUM.nextDouble());
                    System.out.println("Select type");

                    for (int i = 0; i < GoodsType.values().length; i++) {
                        System.out.println((i) + "." + GoodsType.values()[i]);
                    }
                    int type;
                    type = scannerUtil.scannerNUM.nextInt();
                    newGoods.setGoodsType(GoodsType.values()[type]);
                    System.out.println("Input color");
                    newGoods.setColor(scannerUtil.scannerSTR.nextLine());
                    System.out.println("Input quantity");
                    newGoods.setQuantity(scannerUtil.scannerSTR.nextDouble());
                    System.out.println("Input comment");
                    newGoods.setComments(scannerUtil.scannerSTR.nextLine());
                    System.out.println("Input about good");
                    newGoods.setAboutGood(scannerUtil.scannerSTR.nextLine());


                    if (service.editGoods(users, oldGoods, newGoods)) {
                        System.out.println("Successfully updated");
                    } else {
                        System.out.println("Wrong");
                    }

                }
                case "3" -> {
                    Service service = new Service();
                    List<Goods> goods = service.showGoods(users);
                    System.out.println("Select good");
                    for (int i = 0; i < goods.size(); i++) {
                        System.out.println(i+". "+goods.get(i));
                    }
                    int selectedGood = scannerUtil.scannerNUM.nextInt();
                    boolean deleted = service.deleteGoods(users, goods.get(selectedGood));
                    if(deleted){
                        System.out.printf("%s successfully deleted\n",goods.get(selectedGood).getName());
                    }else {
                        System.out.println("Failure");
                    }
                }
                case "4" -> {
                    Service service = new Service();
                    List<Goods> goods = service.showGoods(users);
                    if(goods.isEmpty()){
                        System.out.println("No goods");
                    }else {
                        for (int i = 0; i < goods.size(); i++) {
                            System.out.println(i + ". " + goods.get(i).getName());
                        }
                    }
                }
                case "5" -> {
                    Service service = new Service();
                    System.out.println("Your old first name is "+users.getFirstName());
                    String firstName = scannerUtil.scannerSTR.nextLine();

                    System.out.println("Your old last name is "+users.getLastName());
                    String lastName = scannerUtil.scannerSTR.nextLine();

                    System.out.println("Your old father name is "+users.getFatherName());
                    String fatherName = scannerUtil.scannerSTR.nextLine();

                    System.out.println("Your old phone number is "+users.getPhoneNumber());
                    String phoneNumber = scannerUtil.scannerSTR.nextLine();

                    System.out.println("Input old password");
                    String oldPassword = scannerUtil.scannerSTR.nextLine();

                    System.out.println("Input new password");
                    String password = scannerUtil.scannerSTR.nextLine();

                    System.out.println("Your old birthday is "+users.getDate());
                    System.out.println("Input year");
                    int year = scannerUtil.scannerNUM.nextInt();

                    System.out.println("Input month");
                    int month = scannerUtil.scannerNUM.nextInt();

                    System.out.println("Input date");
                    int date = scannerUtil.scannerNUM.nextInt();


                    System.out.println("Your old sex is "+users.getSex());
                    System.out.println("Select");
                    System.out.println("M\nN");
                    Sex sex = null;
                    String select = scannerUtil.scannerSTR.nextLine();
                    switch (select){
                        case "M"-> {
                            sex = Sex.MAN;
                        }
                        case "F"-> {
                            sex = Sex.WOMAN;
                        }default -> {
                            try {
                                throw new IllegalArgumentException("Bu kuningdan o'lganing yaxshi edi");
                            }catch (IllegalArgumentException e){
                                e.printStackTrace();
                            }
                        }
                    }
                    boolean edited = service.editProfileSeller(users, firstName, lastName,
                            fatherName, phoneNumber, oldPassword, password,date,month,year, sex);
                    if(edited){
                        System.out.println("Edited");
                    }else {
                        System.out.println("Failed");
                    }
                }
                case "6" -> {
                    Service service = new Service();
                    System.out.println("Input your password");
                    String password = scannerUtil.scannerSTR.nextLine();
                    System.out.println("Really want you to delete your profile?");
                    boolean confirmation = false;
                    System.out.println("1. Yes\n2. No");
                    int status = scannerUtil.scannerNUM.nextInt();
                    switch (status) {
                        case 1 ->{
                            confirmation = true;
                        }
                        case 2 ->{
                            confirmation = false;
                        }
                    }
                    if(!confirmation){
                        continue;
                    }
                    Boolean deletedMyProfile = service.deleteMyProfile(users, password, confirmation);
                    if (deletedMyProfile) {
                        System.out.println("Deleted");
                        stop = true;
                    }else {
                        System.out.println("Failed to delete");
                    }
                }
            }
            if(stop){
                break;
            }
        }while (true);
    }
}
