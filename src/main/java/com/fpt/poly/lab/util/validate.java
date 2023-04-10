package com.fpt.poly.lab.util;

import com.fpt.poly.lab.entity.ChiTietSP;
import com.fpt.poly.lab.entity.ChucVu;
import com.fpt.poly.lab.entity.CuaHang;
import com.fpt.poly.lab.entity.DongSP;
import com.fpt.poly.lab.entity.KhachHang;
import com.fpt.poly.lab.entity.MauSac;
import com.fpt.poly.lab.entity.NSX;
import com.fpt.poly.lab.entity.NhanVien;
import com.fpt.poly.lab.entity.SanPham;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class validate {
    public static List<String> validateInput(KhachHang khachHang) {
        List<String> errors = new ArrayList<>();

        if (khachHang.getTen() == null || khachHang.getTen().trim().isEmpty()) {
            errors.add("Tên không được để trống.");
        }

        if (khachHang.getTenDem() == null || khachHang.getTenDem().trim().isEmpty()) {
            errors.add("Tên đệm không được để trống.");
        }

        if (khachHang.getHo() == null || khachHang.getHo().trim().isEmpty()) {
            errors.add("Họ không được để trống.");
        }

        if (khachHang.getNgaySinh() == LocalDate.parse("0")) {
            errors.add("Ngày sinh không được để trống.");
        }

        if (khachHang.getSdt() == null || khachHang.getSdt().trim().isEmpty()) {
            errors.add("Số điện thoại không được để trống.");
        } else {
            if (khachHang.getSdt().length() != 11 || !khachHang.getSdt().matches("[0-9]+")) {
                errors.add("Số điện thoại phải bắt đầu từ số 0 và gồm 11 chữ số.");
            }
        }

        if (khachHang.getDiaChi() == null || khachHang.getDiaChi().trim().isEmpty()) {
            errors.add("Địa chỉ không được để trống.");
        }

        if (khachHang.getThanhPho() == null || khachHang.getThanhPho().trim().isEmpty()) {
            errors.add("Thành phố không được để trống.");
        }

        if (khachHang.getQuocGia() == null || khachHang.getQuocGia().trim().isEmpty()) {
            errors.add("Quốc gia không được để trống.");
        }

        if (khachHang.getMatKhau() == null || khachHang.getMatKhau().trim().isEmpty()) {
            errors.add("Mật khẩu không được để trống.");
        }

        return errors;
    }

    public static List<String> validateInput(ChiTietSP value) {
        List<String> errors = new ArrayList<>();


        if (value.getSanPham() == null) {
            errors.add("Sản phẩm không được bỏ trống");
        }

        if (value.getNsx() == null) {
            errors.add("Nhà sản xuất không được bỏ trống");
        }

        if (value.getMauSac() == null) {
            errors.add("Màu sắc không được bỏ trống");
        }

        if (value.getDongSP() == null) {
            errors.add("Dòng sản phẩm không được bỏ trống");
        }

        if (value.getNamBH() == null || value.getNamBH() == 0) {
            errors.add("Năm bảo hành phải là một số");
        }

        if (value.getMoTa() == null || value.getMoTa().trim().isEmpty()) {
            errors.add("Mô tả không được bỏ trống");
        }

        if (value.getSoLuongTon() == null || value.getSoLuongTon() == 0) {
            errors.add("Số lượng tồn phải là một số");

        }
        BigDecimal bd1 = new BigDecimal("0");

        if (value.getGiaNhap() == null || value.getGiaNhap().equals(bd1)) {
            errors.add("Giá nhập phải là một số");
        }

        if (value.getGiaBan() == null || value.getGiaBan().equals(bd1)) {
            errors.add("Giá bán phải là một số");
        }

        return errors;
    }

    public static List<String> validateInput(NhanVien value) {
        List<String> errors = new ArrayList<>();

        if (value.getTen() == null || value.getTen().trim().isEmpty()) {
            errors.add("Tên không được để trống");
        }

        if (value.getTenDem() == null || value.getTenDem().trim().isEmpty()) {
            errors.add("Tên đệm không được để trống");
        }

        if (value.getHo() == null || value.getHo().trim().isEmpty()) {
            errors.add("Họ không được để trống");
        }

        if (value.getGioiTinh() == null) {
            errors.add("Vui lòng chọn giới tính");
        }

        if (value.getTrangThai() == null || value.getTrangThai() == -1) {
            errors.add("Vui lòng chọn trạng thái");
        }

        if (value.getNgaySinh() == null ) {
            errors.add("Ngày sinh không được để trống");
        }

        if (value.getDiaChi() == null || value.getDiaChi().trim().isEmpty()) {
            errors.add("Địa chỉ không được để trống");
        }

        if (value.getSdt() == null || value.getSdt().trim().isEmpty()) {
            errors.add("Số điện thoại không được để trống.");
        } else {
            if (value.getSdt().length() != 11 || !value.getSdt().matches("[0-9]+")) {
                errors.add("Số điện thoại phải bắt đầu từ số 0 và gồm 11 chữ số.");
            }
        }

        if (value.getMatKhau() == null || value.getMatKhau().trim().isEmpty()) {
            errors.add("Mật khẩu không được để trống");
        }

        if (value.getCuaHang() == null) {
            errors.add("Vui lòng chọn cửa hàng");
        }

        if (value.getChucVu() == null) {
            errors.add("Vui lòng chọn chức vụ");
        }


        return errors;
    }

    public static String validateInput(ChucVu value) {
        String errors = null;

        if (value.getTen() == null || value.getTen().trim().isEmpty()) {
            errors = ("Tên không được để trống");
        }
        return errors;
    }


    public static String validateInput(SanPham value) {
        String errors = null;

        if (value.getTen() == null || value.getTen().trim().isEmpty()) {
            errors = ("Tên không được để trống");
        }
        return errors;
    }

    public static String validateInput(DongSP value) {
        String errors = null;

        if (value.getTen() == null || value.getTen().trim().isEmpty()) {
            errors = ("Tên không được để trống");
        }
        return errors;
    }

    public static String validateInput(NSX value) {
        String errors = null;

        if (value.getTen() == null || value.getTen().trim().isEmpty()) {
            errors = ("Tên không được để trống");
        }
        return errors;
    }

    public static String validateInput(MauSac value) {
        String errors = null;

        if (value.getTen() == null || value.getTen().trim().isEmpty()) {
            errors = ("Tên không được để trống");
        }
        return errors;
    }

    public static List<String> validateInput(CuaHang value) {
        List<String> errors = new ArrayList<>();

        if (value.getTen() == null || value.getTen().trim().isEmpty()) {
            errors.add("Tên không được để trống");
        }

        if (value.getDiaChi() == null || value.getDiaChi().trim().isEmpty()) {
            errors.add("Địa chỉ không được để trống");
        }

        if (value.getThanhPho() == null || value.getThanhPho().trim().isEmpty()) {
            errors.add("Thành phố không được để trống");
        }

        if (value.getQuocGia() == null || value.getQuocGia().trim().isEmpty()) {
            errors.add("Quốc gia không được để trống");
        }

        return errors;
    }


    // check số
    public static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static String checkNumericString(String str) {
        if (str == null || str.trim().isEmpty()) {
            return "0";
        } else if (isNumeric(str)) {
            return str;
        } else {
            return "0";
        }
    }

//
//    public boolean checkStringNull(String str) {
//        if (str == null || str.trim().equals(' ')) {
//          return true;
//        }
//    return false;
//    }

}
