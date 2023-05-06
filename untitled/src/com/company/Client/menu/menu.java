package com.company.Client.menu;
import com.company.Client.ScannerUtil.scannerUtil;
import com.company.Server.Enums.GoodsType;
import com.company.Server.Enums.Roles;
import com.company.Server.Models.Goods;
import com.company.Server.Models.Users;
import com.company.Server.Service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.company.Server.Database.database.*;

public class menu {
    public static void main(String[] args) {

           USERS.add(users1);
           users1.setRoles(Roles.ADMIN);
           USERS.add(users2);
           users2.setRoles(Roles.SUPER_ADMIN);
           USERS.add(users3);
           users3.setRoles(Roles.USER);
           USERS.add(users5);
           Goods goods = new Goods();
           goods.setName("Laptop");
           goods.setGoodsType(GoodsType.ELECTRONICS);
           goods.setQuantity(4);
           goods.setPrice(400);

           Goods goods1 = new Goods();
           goods1.setGoodsType(GoodsType.BOOKS);
           goods1.setName("Java");
           goods1.setQuantity(4);
           goods1.setPrice(4);
           ALL.add(goods);
           ALL.add(goods1);
           users5.setRoles(Roles.SELLER);
        do{
            for (Users user : USERS) {
                System.out.println(user.getFirstName()+", "+user.getLastName()+", "+user.getRoles()+
                        ", "+user.getUserName()+", "+user.getPassword());
            }
            System.out.println();
            try {
                mainMenu();
            }catch (Exception e){
                e.printStackTrace();
            }
            scannerUtil.scannerSTR.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n");
        }while (true);
    }

    public static void mainMenu() throws NoSuchFieldException {
        System.out.println("""
                1. Login
                2. Register
                """);
        switch (scannerUtil.scannerSTR.nextLine()){
            case "1" -> {
                Login login = new Login();
                System.out.println("Input id");
                String id = scannerUtil.scannerSTR.nextLine();
                System.out.println("***\nInput password");
                String password = scannerUtil.scannerSTR.nextLine();
                if(login.loginPage(id, password)){

                }else {
                    System.out.println("Login unsuccessfully");
                }
            }
            case "2" ->{
                Register register = new Register();
                register.registerPage();
            }
        }
    }
}
