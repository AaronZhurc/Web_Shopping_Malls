package com.example.CozDes.service;

import com.example.CozDes.dao.IUserDao;
import com.example.CozDes.dao.UserDao;
import com.example.CozDes.po.Userbean;

public class UserService implements IUserService{
    private IUserDao udao;
    public UserService() {
        udao=new UserDao();
    }
    @Override
    public Userbean checkUser(String phone, String password) {
        return udao.selectBysome(phone, password);
    }

    @Override
    public boolean regisUser(Userbean user) {
        return udao.addUser(user);
    }

    @Override
    public Userbean findUserByPhone(String phone) {
        return udao.findByPhone(phone);
    }
}
