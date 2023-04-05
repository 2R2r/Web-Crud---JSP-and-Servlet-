package com.fpt.poly.lab.service.impl;


import com.fpt.poly.lab.entity.SanPham;
import com.fpt.poly.lab.repository.SanPhamRepository;
import com.fpt.poly.lab.service.CommonService;

import java.util.List;

public class SanPhamServiceImpl implements CommonService<SanPham> {
    private final SanPhamRepository repository = new SanPhamRepository();

    @Override
    public List<SanPham> getAll() {
        return repository.getAll();
    }

    public String genMa() {
        int max = 0;
        List<SanPham> listCheck = repository.getAll();
        for (SanPham ob : listCheck) {
            String ma = ob.getMa().substring(2);
            int ma2 = Integer.parseInt(ma);
            if (ma2 > max) {
                max = ma2;
            }
        }
        return "SP" + (max + 1);
    }

    @Override
    public boolean add(SanPham value) {
        value.setMa(genMa());
        return repository.add(value);
    }

    @Override
    public boolean update(SanPham value) {
        return repository.update(value);

    }

    @Override
    public boolean delete(SanPham value) {
        return repository.delete(value);
    }

    @Override
    public SanPham getOne(String id) {
        return repository.getOne(id);
    }
}
