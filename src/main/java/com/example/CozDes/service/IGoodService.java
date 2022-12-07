package com.example.CozDes.service;

import com.example.CozDes.po.Goodbean;

import java.util.List;

public interface IGoodService {
    List<Goodbean> getAllGoods();
    List<Goodbean> getAllGoods(String name);
    Goodbean getGood(String url);
    Goodbean getGood(int id);
}
