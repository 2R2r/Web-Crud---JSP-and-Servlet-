package com.fpt.poly.lab.service.impl;

import com.fpt.poly.lab.entity.KhachHang;
import com.fpt.poly.lab.repository.KhachHangRepository;
import com.fpt.poly.lab.service.CommonService;

import java.util.List;

public class KhachHangServiceImpl implements CommonService<KhachHang> {
    private KhachHangRepository repository =new KhachHangRepository();

    @Override
    public List<KhachHang> getAll() {
        return repository.getAll();
    }

    public int genMa(){
        int max = 0 ;
        List<KhachHang> listCheck = repository.getAll();
        for (KhachHang khachHang : listCheck) {
            String ma = khachHang.getMa().substring(2);
            int ma2 = Integer.parseInt(ma);
            if (ma2 > max) {
                max = ma2;
            }
        }
        return (max + 1);
    }
    @Override
    public boolean add(KhachHang value) {
        value.setMa("KH" + String.valueOf(genMa()));
        if (!value.getSdt().startsWith("0") || value.getSdt().length() != 11) {
            return false;
        }else {
            return  repository.add(value);
        }
    }

    @Override
    public boolean update(KhachHang value) {
        if (!value.getSdt().startsWith("0") || value.getSdt().length() != 11) {
            return false;
        }else {
            return  repository.update(value);
        }
    }

    @Override
    public boolean delete(KhachHang value) {
        return repository.delete(value);
    }

    @Override
    public KhachHang getOne(String id) {
        return repository.getOne(id);
    }
}
