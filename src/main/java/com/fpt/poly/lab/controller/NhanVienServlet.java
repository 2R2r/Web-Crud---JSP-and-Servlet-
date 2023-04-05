package com.fpt.poly.lab.controller;


import com.fpt.poly.lab.entity.ChucVu;
import com.fpt.poly.lab.entity.CuaHang;
import com.fpt.poly.lab.entity.NhanVien;
import com.fpt.poly.lab.service.CommonService;
import com.fpt.poly.lab.service.impl.ChucVuServiceImpl;
import com.fpt.poly.lab.service.impl.CuaHangServiceImpl;
import com.fpt.poly.lab.service.impl.NhanVienServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NhanVienServlet", value = {"/nhan-vien/hien-thi", "/nhan-vien/view-update", "/nhan-vien/update", "/nhan-vien/view-add", "/nhan-vien/add", "/nhan-vien/detail", "/nhan-vien/delete"})
public class NhanVienServlet extends HttpServlet {

    private final CommonService nhanVienService = new NhanVienServiceImpl();
    private final CommonService cuaHangService = new CuaHangServiceImpl();
    private final CommonService chucVuService = new ChucVuServiceImpl();
    private List<NhanVien> list = new ArrayList<NhanVien>();
    private final List<ChucVu> listChucVu = chucVuService.getAll();
    private final List<CuaHang> listCuaHang = cuaHangService.getAll();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.equals("/nhan-vien/hien-thi")) {
            this.hienThi(request, response);
        } else if (url.equals("/nhan-vien/view-update")) {
            this.viewUpdate(request, response);

        } else if (url.equals("/nhan-vien/view-add")) {
            this.viewAdd(request, response);

        } else if (url.equals("/nhan-vien/delete")) {
            this.delete(request, response);

        } else if (url.equals("/nhan-vien/detail")) {
            this.detail(request, response);

        } else {
            this.hienThi(request, response);

        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = nhanVienService.getAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/view/NhanVien/viewListTable.jsp").forward(request, response);
    }

    private NhanVien flag;

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NhanVien value = (NhanVien) nhanVienService.getOne((request.getParameter("id")));
        flag = value;

        request.setAttribute("listChucVu", listChucVu);
        request.setAttribute("listCuaHang", listCuaHang);
        request.setAttribute("value", value);
        request.getRequestDispatcher("/view/NhanVien/viewUpdate.jsp").forward(request, response);

    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        request.setAttribute("listChucVu", listChucVu);
        request.setAttribute("listCuaHang", listCuaHang);

        request.getRequestDispatcher("/view/NhanVien/viewAdd.jsp").forward(request, response);

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        nhanVienService.delete(nhanVienService.getOne((request.getParameter("id"))));
        response.sendRedirect("/nhan-vien/hien-thi");

    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        NhanVien value = (NhanVien) nhanVienService.getOne((request.getParameter("id")));
        request.setAttribute("value", value);
        request.getRequestDispatcher("/view/NhanVien/viewDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.equals("/nhan-vien/add")) {
            this.add(request, response);
        } else if (url.equals("/nhan-vien/update")) {
            this.update(request, response);

        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String ngaySinh = request.getParameter("ngaySinh");
        String gioiTinh = request.getParameter("gioiTinh");
        String trangThai = request.getParameter("trangThai");
        String idCuaHang = request.getParameter("cuaHang");
        String idChucVu = request.getParameter("chucVu");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String matKhau = request.getParameter("matKhau");
        CuaHang cuaHang = (CuaHang) cuaHangService.getOne(idCuaHang);
        ChucVu chucVu = (ChucVu) cuaHangService.getOne(idChucVu);
        NhanVien value = new NhanVien(String.valueOf(UUID.randomUUID()), null, ten, tenDem, ho, gioiTinh, LocalDate.parse(ngaySinh), diaChi, sdt, matKhau, cuaHang, chucVu, Integer.parseInt(trangThai));
        if (!nhanVienService.add(value)) {
            String error = "Số điện thoại phải băt đầu từ số 0 và có 11 kí tự";
            request.setAttribute("error", error);
            request.setAttribute("value", value);
            request.setAttribute("listChucVu", listChucVu);
            request.setAttribute("listCuaHang", listCuaHang);
            request.getRequestDispatcher("/view/NhanVien/viewAdd.jsp").forward(request, response);
            return;
        } else {
            response.sendRedirect("/nhan-vien/hien-thi");

        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String gioiTinh = request.getParameter("gioiTinh");
        String trangThai = request.getParameter("trangThai");

        String ngaySinh = request.getParameter("ngaySinh");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String matKhau = request.getParameter("matKhau");
        String idCuaHang = request.getParameter("cuaHang");
        String idChucVu = request.getParameter("chucVu");
        CuaHang cuaHang = (CuaHang) cuaHangService.getOne(idCuaHang);
        ChucVu chucVu = (ChucVu) chucVuService.getOne(idChucVu);
        NhanVien value = new NhanVien(flag.getId(), flag.getMa(), ten, tenDem, ho, gioiTinh, LocalDate.parse(ngaySinh), diaChi, sdt, matKhau, cuaHang, chucVu, Integer.parseInt(trangThai));

        if (!nhanVienService.update(value)) {
            String error = "Số điện thoại phải băt đầu từ số 0 và có 11 kí tự";
            request.setAttribute("error", error);
            request.setAttribute("value", value);
            request.setAttribute("listChucVu", listChucVu);
            request.setAttribute("listCuaHang", listCuaHang);
            request.getRequestDispatcher("/view/NhanVien/viewUpdate.jsp").forward(request, response);
            return;
        } else {
            response.sendRedirect("/nhan-vien/hien-thi");
        }
    }
}
