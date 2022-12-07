package com.example.CozDes.service;

import com.example.CozDes.dao.GoodDao;
import com.example.CozDes.dao.IGoodDao;
import com.example.CozDes.po.Goodbean;

import java.util.List;

public class GoodService implements IGoodService {
    private IGoodDao gdao;

    public GoodService() {
        gdao=new GoodDao();
    }

    @Override
    public List<Goodbean> getAllGoods() {
        return gdao.getGoods();
    }

    @Override
    public List<Goodbean> getAllGoods(String name) {
        return gdao.getGoods(name);
    }

    @Override
    public Goodbean getGood(String url) {
        return gdao.getGood(url);
    }

    @Override
    public Goodbean getGood(int id) {
        return gdao.getGood(id);
    }

}
