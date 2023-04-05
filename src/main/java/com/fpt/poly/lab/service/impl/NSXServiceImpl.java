package com.fpt.poly.lab.service.impl;


import com.fpt.poly.lab.entity.NSX;
import com.fpt.poly.lab.repository.NSXRepository;
import com.fpt.poly.lab.service.CommonService;

import java.util.List;

public class NSXServiceImpl implements CommonService<NSX> {
    private final NSXRepository repository = new NSXRepository();

    @Override
    public List<NSX> getAll() {
        return repository.getAll();
    }

    public String genMa() {
        int max = 0;
        List<NSX> listCheck = repository.getAll();
        for (NSX ob : listCheck) {
            String ma = ob.getMa().substring(3);
            int ma2 = Integer.parseInt(ma);
            if (ma2 > max) {
                max = ma2;
            }
        }
        return "NSX" + (max + 1);
    }

    @Override
    public boolean add(NSX value) {
        value.setMa(genMa());
        return repository.add(value);
    }

    @Override
    public boolean update(NSX value) {
        return repository.update(value);

    }

    @Override
    public boolean delete(NSX value) {
        return repository.delete(value);
    }

    @Override
    public NSX getOne(String id) {
        return repository.getOne(id);
    }
}
