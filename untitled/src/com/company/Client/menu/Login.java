package com.company.Client.menu;

import com.company.Client.Persons.Admin;
import com.company.Client.Persons.Seller;
import com.company.Client.Persons.Super_Admin;
import com.company.Client.Persons.User;
import com.company.Server.Models.Users;
import com.company.Server.Service.Service;

import static com.company.Server.Database.database.*;
import static com.company.Server.Enums.Roles.*;

public class Login {

    public boolean loginPage(String userName, String password) throws NoSuchFieldException {
        Users users = Service.loginCheck(userName,password);
        if(users == null){
            return false;
        }
            switch (users.getRoles()) {

                case ADMIN -> {
                    Admin admin = new Admin();
                    admin.adminPage(users);
                }
                case USER -> {
                    User user = new User();
                    user.userPage(users);
                }
                case SELLER -> {
                    Seller seller = new Seller();
                    seller.sellerPage(users);
                }
                case SUPER_ADMIN -> {
                    Super_Admin superAdmin = new Super_Admin();
                    superAdmin.superAdminPage(users);
                }
            }
            return true;
        }
}
