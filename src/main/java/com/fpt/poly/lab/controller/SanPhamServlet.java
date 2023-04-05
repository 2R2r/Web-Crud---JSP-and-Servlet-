package com.fpt.poly.lab.controller;


import com.fpt.poly.lab.entity.SanPham;
import com.fpt.poly.lab.service.CommonService;

import com.fpt.poly.lab.service.impl.SanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "SanPhamServlet", value = {"/san-pham/hien-thi", "/san-pham/view-update", "/san-pham/update", "/san-pham/view-add", "/san-pham/add", "/san-pham/detail", "/san-pham/delete"})
public class SanPhamServlet extends HttpServlet {

    private final CommonService service = new SanPhamServiceImpl();
    private List<SanPham> list = new ArrayList<SanPham>();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.equals("/san-pham/hien-thi")) {
            this.hienThi(request, response);
        } else if (url.equals("/san-pham/view-update")) {
            this.viewUpdate(request, response);

        } else if (url.equals("/san-pham/view-add")) {
            this.viewAdd(request, response);

        } else if (url.equals("/san-pham/delete")) {
            this.delete(request, response);

        } else if (url.equals("/san-pham/detail")) {
            this.detail(request, response);

        } else {
            this.hienThi(request, response);

        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = service.getAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/view/SanPham/viewListTable.jsp").forward(request, response);
    }

    private SanPham flag;

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SanPham khachHang = (SanPham) service.getOne((request.getParameter("id")));
        flag = khachHang;
        request.setAttribute("value", khachHang);
        request.getRequestDispatcher("/view/SanPham/viewUpdate.jsp").forward(request, response);

    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/view/SanPham/viewAdd.jsp");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.delete(service.getOne((request.getParameter("id"))));
        response.sendRedirect("/san-pham/hien-thi");

    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SanPham khachHang = (SanPham) service.getOne((request.getParameter("id")));
        request.setAttribute("value", khachHang);
        request.getRequestDispatcher("/view/SanPham/viewDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.equals("/san-pham/add")) {
            this.add(request, response);
        } else if (url.equals("/san-pham/update")) {
            this.update(request, response);

        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        SanPham value = new SanPham(String.valueOf(UUID.randomUUID()), null, ten);
        service.add(value);
        response.sendRedirect("/san-pham/hien-thi");


    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        SanPham value = new SanPham(flag.getId(), flag.getMa(), ten);
        service.update(value);
        response.sendRedirect("/san-pham/hien-thi");
    }
}
