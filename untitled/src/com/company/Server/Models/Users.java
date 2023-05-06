package com.company.Server.Models;

//import com.company.Server.DTO.UsersDTO;
import com.company.Server.Enums.Roles;
import com.company.Server.Enums.Sex;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Users extends Goods {
    private String FirstName;
    private String LastName;
    private String FatherName;
    private String userName;
    private String phoneNumber;
    private String password;
    private LocalDate localDate;

    private Sex sex;

    private Roles roles=Roles.USER;
    final UUID uuid=UUID.randomUUID();
    private String id=String.valueOf(uuid);
    private final List<Goods> salesList = new ArrayList<Goods>();
    public String getId() {
        return id;
    }
    private boolean isExistent=true;

    public Users() {
    }

    public Users(String password, String firstName, String lastName, String userName, String fatherName,
                 String phoneNumber, int year,int month,int date, Sex sex) {
        this.FirstName = firstName;
        this.password = password;
        this.userName = userName;
        this.LastName = lastName;
        this.FatherName = fatherName;
        this.phoneNumber = phoneNumber;
        this.localDate = LocalDate.of(year,month,date);
        this.sex = sex;
    }

    @Override
    public void setExistent(boolean existent) {
        isExistent = existent;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public List<Goods> setSalesList(){
        return salesList;
    }
    public List<Goods> getSalesList() {
        return salesList;
    }

    public void addSalesList(Goods goods) {
        this.salesList.add(goods);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String fatherName) {
        FatherName = fatherName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getDate() {
        return this.localDate;
    }

    public void setDate(int date,int month, int year) {
        this.localDate = LocalDate.of(year,month,date);
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Users{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", FatherName='" + FatherName + '\'' +
                ", userName='" + userName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + "****" + '\'' +
                ", birthDate='" + localDate + '\'' +
                ", sex=" + sex +
                ", roles=" + roles +
                ", salesList=" + salesList +
                '}';
    }
}
