package com.company.Client.Persons;

import com.company.Client.ScannerUtil.scannerUtil;
import com.company.Client.menu.menu;
import com.company.Server.Enums.Roles;
import com.company.Server.Enums.Sex;
import com.company.Server.Models.Goods;
import com.company.Server.Models.Users;
import com.company.Server.Service.Service;

import java.time.LocalDate;
import java.util.List;

public class Super_Admin {
    public void superAdminPage(Users admin) {
        do {
            System.out.println("Super admin page");
            System.out.println("***");
            System.out.println("""
                    1. Show users
                    2. Delete users
                    3. Set admin role
                    4. Set user role
                    5. Set super admin role
                    6. Delete goods
                    7. Change account
                    8. Delete account
                    9. Logout
                    """);
            System.out.println("***");

            String str = scannerUtil.scannerSTR.nextLine();
            boolean stop = false;
            if(str.equals("9")){
                break;
            }
            switch (str){
                case "1" ->{
                    Service service = new Service();
                    for (Object users : service.showUsers(admin)) {
                        System.out.println(users);
                    }
                }
                case "2" ->{
                    Service service = new Service();
                    List<Users> usersList = service.showUsers(admin);
                    for (int i = 0; i < usersList.size(); i++) {
                        System.out.println(i+". "+usersList.get(i));
                    }
                    int selected=0;
                    try {
                        selected = scannerUtil.scannerNUM.nextInt();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    boolean deleted = service.deleteUsers(admin, usersList.get(selected));
                    if(deleted){
                        System.out.println("Deleted");
                    }else {
                        System.out.println("Failed");
                    }
                }
                case "3" ->{
                    Service service = new Service();
                    List<Users> usersList = service.showUsers(admin);
                    for (int i = 0; i < usersList.size(); i++) {
                        System.out.println(i+". "+usersList.get(i));
                    }
                    System.out.println("***");
                    System.out.println("Select");
                    int selected=0;
                    try {
                        selected = scannerUtil.scannerNUM.nextInt();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    boolean setAdminRole = service.setAdminRole(admin, usersList.get(selected));
                    if(setAdminRole){
                        System.out.println("Success");
                    }else {
                        System.out.println("Failed");
                    }
                }
                case "4" ->{
                    Service service = new Service();
                    List<Users> usersList = service.showUsers(admin);
                    for (int i = 0; i < usersList.size(); i++) {
                        System.out.println(i+". "+usersList.get(i));
                    }
                    System.out.println("***");
                    System.out.println("Select");
                    int selected=0;
                    try {
                        selected = scannerUtil.scannerNUM.nextInt();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    boolean setUserRole = service.setUserRole(admin, usersList.get(selected));
                    if(setUserRole){
                        System.out.println("Success");
                    }else {
                        System.out.println("Failed");
                    }
                }
                case "5" ->{
                    Service service = new Service();
                    List<Users> usersList = service.showUsers(admin);
                    int i = 0;
                    for (Users users : usersList) {
                        System.out.println(i+". "+users);i++;
                    }
                    System.out.println("Select");
                    int selected = scannerUtil.scannerNUM.nextInt();
                    System.out.println("""
                            Attention!
                            After your account be deleted,
                            this user can be super admin
                            ----------------------------
                            Are you confirm your account removing?
                            1. Yes
                            2. No
                            """);
                    try {
                        switch (scannerUtil.scannerNUM.nextInt()) {
                            case 1 -> {
                                Boolean deleted = service.setSuperAdmin(admin, usersList.get(selected));
                                if (deleted == null) {
                                    System.out.println("You has not access");
                                }
                                if (Boolean.TRUE.equals(deleted)) {
                                    System.out.println("Success");
                                    stop = true;
                                } else {
                                    System.out.println("Something error");
                                }
                            }
                            case 2 -> System.out.println("Operation failed");
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
                case "6"->{
                    Service service = new Service();
                    List<Goods> goodsList = service.showGoods(admin);
                    for (int i = 0; i < goodsList.size(); i++) {
                        System.out.println(i+". "+goodsList.get(i));
                    }
                    int selected=0;
                    try {
                        selected = scannerUtil.scannerNUM.nextInt();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    boolean deleted = service.deleteGoods(admin, goodsList.get(selected));
                    if(deleted){
                        System.out.println("Deleted");
                    }else {
                        System.out.println("Failed");
                    }
                }
                case "7" ->{
                    Service service = new Service();
                    System.out.println("Your old first name is "+admin.getFirstName());
                    String firstName = scannerUtil.scannerSTR.nextLine();

                    System.out.println("Your old last name is "+admin.getLastName());
                    String lastName = scannerUtil.scannerSTR.nextLine();

                    System.out.println("Your old father name is "+admin.getFatherName());
                    String fatherName = scannerUtil.scannerSTR.nextLine();

                    System.out.println("Your old phone number is "+admin.getPhoneNumber());
                    String phoneNumber = scannerUtil.scannerSTR.nextLine();

                    System.out.println("Input old password");
                    String oldPassword = scannerUtil.scannerSTR.nextLine();

                    System.out.println("Input new password");
                    String password = scannerUtil.scannerSTR.nextLine();
                    int year = 0;
                    int month = 0;
                    int date = 0;
                    try {
                        System.out.println("Your old birthday is " + admin.getDate());
                        System.out.println("Input year");
                        year = scannerUtil.scannerNUM.nextInt();

                        System.out.println("Input month");
                        month = scannerUtil.scannerNUM.nextInt();

                        System.out.println("Input date");
                        date = scannerUtil.scannerNUM.nextInt();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("Your old sex is "+admin.getSex());
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
                    boolean edited = service.editProfileSeller(admin, firstName, lastName,
                            fatherName, phoneNumber, oldPassword, password,date,month,year , sex);
                    if(edited){
                        System.out.println("Edited");
                    }else {
                        System.out.println("Failed");
                    }
                }
                case "8" ->{
                    Service service = new Service();
                    System.out.println("Input password");
                    String password = scannerUtil.scannerSTR.nextLine();

                    System.out.println("Really want you to delete your profile?");
                    boolean confirmation = false;
                    System.out.println("1. Yes\n2. No");
                    try {
                        int status = scannerUtil.scannerNUM.nextInt();
                        switch (status) {
                            case 1 -> {
                                confirmation = true;
                            }
                            case 2 -> {
                                confirmation = false;
                            }
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    if(!confirmation){
                        continue;
                    }
                    Boolean deletedMyProfile = service.deleteMyProfile(admin, password, confirmation);
                    if(deletedMyProfile){
                        System.out.println("Deleted");
                        stop = true;
                    }else {
                        System.out.println("Failed");
                    }
                }
            }
            if(stop){
                break;
            }
        }while (true);
    }
}
