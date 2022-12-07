package com.example.CozDes.dao;

import com.example.CozDes.po.Goodbean;

import java.util.List;

public interface IGoodDao {
    public List<Goodbean> getGoods();
    public List<Goodbean> getGoods(String name);
    public Goodbean getGood(String url);
    public Goodbean getGood(int id);
}
