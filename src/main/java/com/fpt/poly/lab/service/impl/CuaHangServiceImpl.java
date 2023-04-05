package com.fpt.poly.lab.service.impl;


import com.fpt.poly.lab.entity.CuaHang;
import com.fpt.poly.lab.repository.CuaHangRepository;
import com.fpt.poly.lab.service.CommonService;

import java.util.List;

public class CuaHangServiceImpl implements CommonService<CuaHang> {
    private final CuaHangRepository repository = new CuaHangRepository();

    @Override
    public List<CuaHang> getAll() {
        return repository.getAll();
    }

    public String genMa() {
        int max = 0;
        List<CuaHang> listCheck = repository.getAll();
        for (CuaHang khachHang : listCheck) {
            String ma = khachHang.getMa().substring(2);
            int ma2 = Integer.parseInt(ma);
            if (ma2 > max) {
                max = ma2;
            }
        }
        return "CH" + (max + 1);
    }

    @Override
    public boolean add(CuaHang value) {
        value.setMa(genMa());
        return repository.add(value);
    }

    @Override
    public boolean update(CuaHang value) {
        return repository.update(value);

    }

    @Override
    public boolean delete(CuaHang value) {
        return repository.delete(value);
    }

    @Override
    public CuaHang getOne(String id) {
        return repository.getOne(id);
    }
}
