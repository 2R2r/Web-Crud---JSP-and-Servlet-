package com.fpt.poly.lab.controller;


import java.time.LocalDate;
import java.util.UUID;

import com.fpt.poly.lab.entity.KhachHang;
import com.fpt.poly.lab.service.CommonService;
import com.fpt.poly.lab.service.impl.KhachHangServiceImpl;
import com.fpt.poly.lab.util.validate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "KhachHangServlet", value = {"/khach-hang/hien-thi", "/khach-hang/view-update", "/khach-hang/update", "/khach-hang/view-add", "/khach-hang/add", "/khach-hang/detail", "/khach-hang/delete"})
public class KhachHangServlet extends HttpServlet {

    private CommonService khachHangService = new KhachHangServiceImpl();
    private List<KhachHang> list = new ArrayList<KhachHang>();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.equals("/khach-hang/hien-thi")) {
            this.hienThi(request, response);
        } else if (url.equals("/khach-hang/view-update")) {
            this.viewUpdate(request, response);

        } else if (url.equals("/khach-hang/view-add")) {
            this.viewAdd(request, response);

        } else if (url.equals("/khach-hang/delete")) {
            this.delete(request, response);

        } else if (url.equals("/khach-hang/detail")) {
            this.detail(request, response);

        } else {
            this.hienThi(request, response);

        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = khachHangService.getAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/view/KhachHang/viewListTable.jsp").forward(request, response);
    }

    private KhachHang flag;

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        KhachHang khachHang = (KhachHang) khachHangService.getOne((request.getParameter("id")));
        flag = khachHang;
        System.out.println(khachHang.getId());
        request.setAttribute("value", khachHang);
        request.getRequestDispatcher("/view/KhachHang/viewUpdate.jsp").forward(request, response);

    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/view/KhachHang/viewAdd.jsp");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        khachHangService.delete(khachHangService.getOne((request.getParameter("id"))));
        response.sendRedirect("/khach-hang/hien-thi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        KhachHang khachHang = (KhachHang) khachHangService.getOne((request.getParameter("id")));
        request.setAttribute("value", khachHang);
        request.getRequestDispatcher("/view/KhachHang/viewDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.equals("/khach-hang/add")) {
            this.add(request, response);
        } else if (url.equals("/khach-hang/update")) {
            this.update(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ngaySinh = request.getParameter("ngaySinh");
        System.out.println(ngaySinh);
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        String matKhau = request.getParameter("matKhau");
        KhachHang khachHang = new KhachHang(String.valueOf(UUID.randomUUID()), null, ten, tenDem, ho, LocalDate.parse(ngaySinh), sdt, diaChi, thanhPho, quocGia, matKhau);
        List<String> errors = validate.validateInput(khachHang);
        if (errors.isEmpty()) {
            khachHangService.add(khachHang);

            response.sendRedirect("/khach-hang/hien-thi");

        } else {
            request.setAttribute("errors", errors);
            request.setAttribute("value", khachHang);
            request.getRequestDispatcher("/view/KhachHang/viewAdd.jsp").forward(request, response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ma = request.getParameter("ma");
        String ngaySinh = request.getParameter("ngaySinh");
        String ten = request.getParameter("ten");
        String tenDem = request.getParameter("tenDem");
        String ho = request.getParameter("ho");
        String sdt = request.getParameter("sdt");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        String matKhau = request.getParameter("matKhau");
        KhachHang khachHang = new KhachHang(flag.getId(), ma, ten, tenDem, ho, LocalDate.parse(ngaySinh), sdt, diaChi, thanhPho, quocGia, matKhau);
        List<String> errors = validate.validateInput(khachHang);

        if (errors.isEmpty()) {
            khachHangService.update(khachHang);

            response.sendRedirect("/khach-hang/hien-thi");

        } else {
            request.setAttribute("errors", errors);
            request.setAttribute("value", khachHang);
            request.getRequestDispatcher("/view/KhachHang/viewUpdate.jsp").forward(request, response);
        }
    }
}
