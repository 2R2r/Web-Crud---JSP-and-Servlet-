package com.fpt.poly.lab.service.impl;


import com.fpt.poly.lab.entity.MauSac;
import com.fpt.poly.lab.repository.MauSacRepository;
import com.fpt.poly.lab.service.CommonService;

import java.util.List;

public class MauSacServiceImpl implements CommonService<MauSac> {
    private final MauSacRepository repository = new MauSacRepository();

    @Override
    public List<MauSac> getAll() {
        return repository.getAll();
    }

    public String genMa() {
        int max = 0;
        List<MauSac> listCheck = repository.getAll();
        for (MauSac ob : listCheck) {
            String ma = ob.getMa().substring(2);
            int ma2 = Integer.parseInt(ma);
            if (ma2 > max) {
                max = ma2;
            }
        }
        return "MS" + (max + 1);
    }

    @Override
    public boolean add(MauSac value) {
        value.setMa(genMa());
        return repository.add(value);
    }

    @Override
    public boolean update(MauSac value) {
        return repository.update(value);

    }

    @Override
    public boolean delete(MauSac value) {
        return repository.delete(value);
    }

    @Override
    public MauSac getOne(String id) {
        return repository.getOne(id);
    }
}
