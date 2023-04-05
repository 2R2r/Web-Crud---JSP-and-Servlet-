package com.fpt.poly.lab.service.impl;


import com.fpt.poly.lab.entity.NhanVien;
import com.fpt.poly.lab.repository.NhanVienRepository;
import com.fpt.poly.lab.service.CommonService;

import java.util.List;

public class NhanVienServiceImpl implements CommonService<NhanVien> {
    private final NhanVienRepository repository = new NhanVienRepository();

    @Override
    public List<NhanVien> getAll() {
        return repository.getAll();
    }

    public int genMa() {
        int max = 0;
        List<NhanVien> listCheck = repository.getAll();
        for (NhanVien nhanVien : listCheck) {
            String ma = nhanVien.getMa().substring(2);
            int ma2 = Integer.parseInt(ma);
            if (ma2 > max) {
                max = ma2;
            }
        }
        return (max + 1);
    }

    @Override
    public boolean add(NhanVien value) {
        value.setMa("NV" + genMa());
        if (!value.getSdt().startsWith("0") || value.getSdt().length() != 11) {
            return false;
        } else {
            return repository.add(value);
        }
    }

    @Override
    public boolean update(NhanVien value) {
        if (!value.getSdt().startsWith("0") || value.getSdt().length() != 11) {
            return false;
        } else {
            return repository.update(value);
        }
    }

    @Override
    public boolean delete(NhanVien value) {
        return repository.delete(value);
    }

    @Override
    public NhanVien getOne(String id) {
        return repository.getOne(id);
    }
}
