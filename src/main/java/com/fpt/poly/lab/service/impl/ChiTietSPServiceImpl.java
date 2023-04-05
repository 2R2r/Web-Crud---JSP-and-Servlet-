package com.fpt.poly.lab.service.impl;


import com.fpt.poly.lab.entity.ChiTietSP;

import com.fpt.poly.lab.repository.ChiTietSPRepository;

import com.fpt.poly.lab.service.CommonService;

import java.util.List;

public class ChiTietSPServiceImpl implements CommonService<ChiTietSP> {
    private final ChiTietSPRepository repository = new ChiTietSPRepository();

    @Override
    public List<ChiTietSP> getAll() {
        return repository.getAll();
    }


    @Override
    public boolean add(ChiTietSP value) {
        return repository.add(value);
    }

    @Override
    public boolean update(ChiTietSP value) {
        return repository.update(value);
    }

    @Override
    public boolean delete(ChiTietSP value) {
        return repository.delete(value);
    }

    @Override
    public ChiTietSP getOne(String id) {
        return repository.getOne(id);
    }
}
