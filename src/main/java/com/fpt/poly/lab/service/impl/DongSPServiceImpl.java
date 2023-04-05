package com.fpt.poly.lab.service.impl;


import com.fpt.poly.lab.entity.DongSP;
import com.fpt.poly.lab.repository.DongSPRepository;
import com.fpt.poly.lab.service.CommonService;

import java.util.List;

public class DongSPServiceImpl implements CommonService<DongSP> {
    private final DongSPRepository repository = new DongSPRepository();

    @Override
    public List<DongSP> getAll() {
        return repository.getAll();
    }

    public String genMa() {
        int max = 0;
        List<DongSP> listCheck = repository.getAll();
        for (DongSP ob : listCheck) {
            String ma = ob.getMa().substring(6);
            int ma2 = Integer.parseInt(ma);
            if (ma2 > max) {
                max = ma2;
            }
        }
        return "DongSP" + (max + 1);
    }

    @Override
    public boolean add(DongSP value) {
        value.setMa(genMa());
        return repository.add(value);
    }

    @Override
    public boolean update(DongSP value) {
        return repository.update(value);

    }

    @Override
    public boolean delete(DongSP value) {
        return repository.delete(value);
    }

    @Override
    public DongSP getOne(String id) {
        return repository.getOne(id);
    }
}
