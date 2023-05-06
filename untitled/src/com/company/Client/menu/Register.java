package com.company.Client.menu;

import com.company.Server.Database.database;
import com.company.Server.Enums.Sex;
import com.company.Server.Models.Users;
import com.company.Server.Service.Service;
import jdk.jshell.execution.Util;
import com.company.Client.ScannerUtil.scannerUtil;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.Stack;

public class Register {
    public void registerPage() {
        System.out.println("Register page");
        System.out.println("***");
        Users users = new Users();
        System.out.println("Input first name");
        users.setFirstName(scannerUtil.scannerSTR.nextLine());

        System.out.println("Input last name");
        users.setLastName(scannerUtil.scannerSTR.nextLine());

        System.out.println("Input father name");
        users.setFatherName(scannerUtil.scannerSTR.nextLine());

        Service service = new Service();
        System.out.println("Input username");
        String userName = scannerUtil.scannerSTR.nextLine();
        while (!service.checkUserName(userName)) {
            userName = scannerUtil.scannerSTR.nextLine();
        }
        users.setUserName(userName);


        System.out.println("Input year");
        int year = scannerUtil.scannerNUM.nextInt();

        System.out.println("Input month");
        int month = scannerUtil.scannerNUM.nextInt();

        System.out.println("Input date");
        int date = scannerUtil.scannerNUM.nextInt();

        users.setDate(date,month,year);

        System.out.println("Input phone number");
        System.out.print("+998");
        scannerUtil.scannerSTR=new Scanner(System.in);
        String phoneNumber = scannerUtil.scannerSTR.nextLine();
        if (phoneNumber.matches("[0-9]{9}")) {
            users.setPhoneNumber("+998"+phoneNumber);
        }else {
            System.out.println("Error");
        }

        System.out.println("""
                Select sex
                1. Man
                2. Woman
                """);
        switch (scannerUtil.scannerSTR.nextLine()){
            case "1" -> users.setSex(Sex.MAN);
            case "2" -> users.setSex(Sex.WOMAN);
            default -> System.out.println("Wrong");
        }

        System.out.println("Input password");
        users.setPassword(scannerUtil.scannerSTR.nextLine());
        database.USERS.add(users);
    }
}
