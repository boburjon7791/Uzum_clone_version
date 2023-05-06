package com.company.Server.Database;

//import com.company.Server.DTO.UsersDTO;
import com.company.Server.Enums.Roles;
import com.company.Server.Enums.Sex;
import com.company.Server.Models.Goods;
import com.company.Server.Models.Users;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface database {
    public List<Users> USERS = new ArrayList<>();
    public Users users2 = new Users("acer2525","Buvamatova","Gulnora",
            "guli","Olimjon qizi","+998991388671",
            1971,03,11,Sex.WOMAN);//super admin
    public Users users3 = new Users("bobur7761","Soliyev","Boburjon",
            "sayfullo","Sayfillojon o'g'li","+998999057761",
            1967,11,05,Sex.MAN);//user

    public Users users1 = new Users("bobur2115","Soliyev","Boburjon",
            "bobur","Sayfillojon o'g'li","+998932552280",
            2001,05,11,Sex.MAN);//admin
    public Users users5 = new Users("1234","Alyev","Toshmat","tosh","Ahmad o'g'li","+998991234567",
            2000,05,19,Sex.MAN);//seller
    public List<Goods> ALL = new ArrayList<>();
    public List<Object> DELETED = new ArrayList<>();
}
