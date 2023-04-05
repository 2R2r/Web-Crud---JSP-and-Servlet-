package com.fpt.poly.lab.service.impl;


import com.fpt.poly.lab.entity.ChucVu;
import com.fpt.poly.lab.repository.ChucVuRepository;
import com.fpt.poly.lab.service.CommonService;

import java.util.List;

public class ChucVuServiceImpl implements CommonService<ChucVu> {
    private final ChucVuRepository repository = new ChucVuRepository();

    @Override
    public List<ChucVu> getAll() {
        return repository.getAll();
    }

    public String genMa() {
        int max = 0;
        List<ChucVu> listCheck = repository.getAll();
        for (ChucVu ob : listCheck) {
            String ma = ob.getMa().substring(2);
            int ma2 = Integer.parseInt(ma);
            if (ma2 > max) {
                max = ma2;
            }
        }
        return "CV" + (max + 1);
    }

    @Override
    public boolean add(ChucVu value) {
        value.setMa(genMa());
        return repository.add(value);
    }

    @Override
    public boolean update(ChucVu value) {
        return repository.update(value);

    }

    @Override
    public boolean delete(ChucVu value) {
        return repository.delete(value);
    }

    @Override
    public ChucVu getOne(String id) {
        return repository.getOne(id);
    }
}
