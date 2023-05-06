package com.company.Server.Service;

import com.company.Client.Persons.User;
import com.company.Server.Database.database;
import com.company.Server.Enums.GoodsType;
import com.company.Server.Enums.Roles;
import com.company.Server.Enums.Sex;
import com.company.Server.Models.Goods;
import com.company.Server.Models.Users;

import java.util.ArrayList;
import java.util.List;

import static com.company.Server.Database.database.*;

public class Service {
    database database = new database() {
        @Override
        public int hashCode() {
            return super.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return super.toString();
        }
    };

    public static Users loginCheck(String userName, String password) {
        if (userName == null && password == null) {
            return null;
        }
        Users users = new Users();
        boolean check=false;
        for (Users user : USERS) {
            if(user.getUserName().equals(userName) && user.getPassword().equals(password)){
                users = user;
                check=true;break;
            }
        }
        if(!check){
            return null;
        }
        return users;
    }

    //for admins
    public Boolean setSuperAdmin(Users superAdmin,Users admin){
        if(superAdmin == null){
            return false;
        }
        if(admin == null){
            return false;
        }
        if(!superAdmin.getRoles().equals(Roles.SUPER_ADMIN)){
            return null;
        }
        if(admin.getRoles().equals(Roles.SUPER_ADMIN)){
            return false;
        }
        admin.setRoles(Roles.SUPER_ADMIN);
        DELETED.add(superAdmin);
        USERS.remove(superAdmin);

        return true;
    }
    public List<Users> showUsers(Users admin){
        if(!(admin.getRoles().equals(Roles.ADMIN)
                || admin.getRoles().equals(Roles.SUPER_ADMIN))){
            return null;
        }
        return USERS;
    }
    public List<Goods> showGoods(Users anyUser) {
        return ALL;
    }
    public boolean deleteUsers(Users admin,Users users){
        if(!(admin.getRoles().equals(Roles.ADMIN) || admin.getRoles().equals(Roles.SUPER_ADMIN))){
            return false;
        }
        boolean finded=false;
        for (Users user : USERS) {
            if(user.equals(users)){
                finded = true;
                break;
            }
        }
        if(!finded){
            return false;
        }
        DELETED.add(users);
        USERS.remove(users);
        return true;
    }
    public boolean setAdminRole(Users admin,Users users){
        if(!(admin.getRoles().equals(Roles.ADMIN)||admin.getRoles().equals(Roles.SUPER_ADMIN))){
            return false;
        }

        for (Users user : USERS) {
            if(user.equals(users)){
                users = user;
            }
        }
        if(users.getRoles().equals(Roles.ADMIN)
                || users.getRoles().equals(Roles.SUPER_ADMIN)){
            return false;
        }

        users.setRoles(Roles.ADMIN);
        return true;
    }
    public boolean setUserRole(Users admin,Users user){
        if(!admin.getRoles().equals(Roles.SUPER_ADMIN)){
            return false;
        }
        Users admin2 = new Users();

        for (Users users : USERS) {
            if(users.equals(user)){
                user = users;
            }
        }
        if(user.getRoles().equals(Roles.USER)){
            return false;
        }

        user.setRoles(Roles.USER);
        return true;
    }
    public boolean deleteGoods(Users admin,Goods goods){
        if(admin.getRoles().equals(Roles.USER)){
            return false;
        }
        boolean finded =false;
        for (Goods goods1 : ALL) {
            if(goods1.equals(goods)){
                finded = true;
                break;
            }
        }
        if (!finded){
            return false;
        }
        if(!goods.isExistent()){
            return false;
        }
        DELETED.add(goods);
        goods.setExistent(false);
        ALL.remove(goods);
        return true;
    }
    //for seller
    public boolean createGoods(Users seller,Goods goods){
        if (seller == null) {
            return false;
        }
        if(!seller.getRoles().equals(Roles.SELLER)){
            return false;
        }

        if (goods == null) {
            return false;
        }
        ALL.add(goods);
        return true;
    }
    public boolean editProfileSeller(Users user, String firstName, String lastName, String fatherName,
                                     String phoneNumber,String oldPassword, String password, int date,int month,int year, Sex sex){
        if(user == null){
            return false;
        }

        if(!oldPassword.equals(user.getPassword())){
            return false;
        }
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setFatherName(fatherName);
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);
        user.setDate(date,month,year);
        user.setSex(sex);
        return true;
    }
    public boolean editGoods(Users seller, Goods oldGoods,Goods newGoods){
        if(seller == null){
            return false;
        }
        if(oldGoods == null){
            return false;
        }
        if(!seller.getRoles().equals(Roles.SELLER)){
            return false;
        }
        oldGoods.setName(newGoods.getName());
        oldGoods.setPrice(newGoods.getPrice());
        oldGoods.setAboutGood(newGoods.getAboutGood());
        oldGoods.setColor(newGoods.getColor());
        oldGoods.setExistent(newGoods.isExistent());
        oldGoods.setQuantity(newGoods.getQuantity());
        oldGoods.setGoodsType(newGoods.getGoodsType());
        return true;
    }
    public boolean deleteGoodsSeller(Users seller,String id){
        if (seller == null) {
            return false;
        }
        if (!seller.getRoles().equals(Roles.SELLER)){
            return false;
        }
        boolean finded = false;
        Goods goods = new Goods();
        for (Goods goods1 : ALL) {
            if(goods1.getId().equals(id)){
                finded = true;
                goods = goods1;
                break;
            }
        }
        if (!finded){
            return false;
        }
        DELETED.add(goods);
        goods.setExistent(false);
        ALL.remove(goods);
        return true;
    }
    //for users
    public boolean editProfileUsers(Users users,String firstName,String lastName,String fatherName,
                                    String phoneNumber, String password, String birthday, Sex sex){
        if(users == null){
            return false;
        }
        if(!users.getRoles().equals(Roles.USER)){
            return false;
        }
        users.setFirstName(firstName);
        users.setLastName(lastName);
        users.setFatherName(fatherName);
        users.setPhoneNumber(phoneNumber);
        users.setPassword(password);
//        users.setBirthDate(birthday);
        users.setSex(sex);
        return true;
    }

    public boolean buyGoods(Users users,Goods goods){
        if (users == null && goods == null) {
            return false;
        }
        if(!users.getRoles().equals(Roles.USER)){
            return false;
        }
        if(!goods.isExistent()){
            return false;
        }
        users.addSalesList(goods);
        return true;
    }

    public List<Goods> showSales(Users users) {
        return users.getSalesList();
    }

    public boolean checkUserName(String userName) {
        for (Users users : USERS) {
            if(users.getUserName().equals(userName)){
                return false;
            }
        }
        return true;
    }

    public Boolean deleteMyProfile(Users users, String password, boolean confirmation) {
        if(users == null){
            return null;
        }
        if(!users.getPassword().equals(password)){
            return false;
        }
        if(!confirmation){
            return false;
        }
        DELETED.add(users);
        USERS.remove(users);
        return true;
    }

    public List<Object> removedList(Users admin) {
        if(admin==null){
            return null;
        }
        if(!(admin.getRoles().equals(Roles.ADMIN)||admin.getRoles().equals(Roles.SUPER_ADMIN))){
            return null;
        }
        return DELETED;
    }
}
