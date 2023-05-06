package com.company.Client.Persons;

import com.company.Client.ScannerUtil.scannerUtil;
import com.company.Client.menu.menu;
import com.company.Server.Enums.GoodsType;
import com.company.Server.Enums.Sex;
import com.company.Server.Models.Goods;
import com.company.Server.Models.Users;
import com.company.Server.Service.Service;

public class User {
    public void userPage(Users users) throws NoSuchFieldException {
        do {
            System.out.println("User page");
            System.out.println("***");
            System.out.println("""
                    1. Show goods list
                    2. Show sales
                    3. Edit account
                    4. Delete account
                    5. Logout
                    """);
            String str = scannerUtil.scannerSTR.nextLine();
            boolean stop = false;
            if(str.equals("5")){
                break;
            }
            switch (str) {
                case "1" -> {
                    Service service = new Service();
                    int i = 0;
                    for (GoodsType goodsType : GoodsType.values()) {
                        System.out.println((i + 1) + ". " + goodsType);
                        ++i;
                    }
                    int type = scannerUtil.scannerNUM.nextInt();
                    System.out.println("***\nSelect goods type\n***");

                    int j = 0;
                    boolean empty=true;
                    for (Goods goods : service.showGoods(users)) {
                        if (goods.getGoodsType().equals(GoodsType.values()[type - 1])) {
                            System.out.println((j + 1) + ". " + service.showGoods(users).get(j) + ". " + goods);
                            empty=false;
                        }
                        ++j;
                    }
                    if(empty){
                        throw new NoSuchFieldException("It has not any goods");
                    }

                    boolean bought = service.buyGoods(users, service.showGoods(users).get(scannerUtil.scannerNUM.nextInt() - 1));
                    if (bought) {
                        System.out.println("Successfully bought");
                    } else {
                        System.out.println("Unsuccessfully bought !!!");
                    }
                }
                case "2" -> {
                    Service service = new Service();
                    for (Goods showSale : service.showSales(users)) {
                        System.out.println(showSale.getName()+", " + showSale.getPrice());
                    }
                }
                case "3" ->{
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
                                throw new IllegalArgumentException("O'lib ket");
                            }catch (IllegalArgumentException e){
                                e.printStackTrace();
                            }
                        }
                    }
                    boolean edited = service.editProfileSeller(users, firstName, lastName,
                            fatherName, phoneNumber, oldPassword, password,date,month,year , sex);
                    if(edited){
                        System.out.println("Edited");
                    }else {
                        System.out.println("Failed");
                    }
                }
                case "4" ->{
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
