package com.fpt.poly.lab.controller;


import com.fpt.poly.lab.entity.CuaHang;
import com.fpt.poly.lab.service.CommonService;
import com.fpt.poly.lab.service.impl.CuaHangServiceImpl;
import com.fpt.poly.lab.util.validate;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "CuaHangServlet", value = {"/cua-hang/hien-thi", "/cua-hang/view-update", "/cua-hang/update", "/cua-hang/view-add", "/cua-hang/add", "/cua-hang/detail", "/cua-hang/delete"})
public class CuaHangServlet extends HttpServlet {
    private CommonService cuaHangService = new CuaHangServiceImpl();
    private List<CuaHang> list = new ArrayList<CuaHang>();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.equals("/cua-hang/hien-thi")) {
            this.hienThi(request, response);
        } else if (url.equals("/cua-hang/view-update")) {
            this.viewUpdate(request, response);

        } else if (url.equals("/cua-hang/view-add")) {
            this.viewAdd(request, response);

        } else if (url.equals("/cua-hang/delete")) {
            this.delete(request, response);

        } else if (url.equals("/cua-hang/detail")) {
            this.detail(request, response);

        } else {
            this.hienThi(request, response);

        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = cuaHangService.getAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/view/CuaHang/viewListTable.jsp").forward(request, response);
    }

    private CuaHang flag;

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CuaHang khachHang = (CuaHang) cuaHangService.getOne((request.getParameter("id")));
        flag = khachHang;
        request.setAttribute("value", khachHang);
        request.getRequestDispatcher("/view/CuaHang/viewUpdate.jsp").forward(request, response);

    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/view/CuaHang/viewAdd.jsp");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        cuaHangService.delete(cuaHangService.getOne((request.getParameter("id"))));
        response.sendRedirect("/cua-hang/hien-thi");

    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CuaHang khachHang = (CuaHang) cuaHangService.getOne((request.getParameter("id")));
        request.setAttribute("value", khachHang);
        request.getRequestDispatcher("/view/CuaHang/viewDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.equals("/cua-hang/add")) {
            this.add(request, response);
        } else if (url.equals("/cua-hang/update")) {
            this.update(request, response);

        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        CuaHang value = new CuaHang(String.valueOf(UUID.randomUUID()), null, ten, diaChi, thanhPho, quocGia);
        List<String> errors = validate.validateInput(value);

        if (errors.isEmpty()) {
            cuaHangService.add(value);
            response.sendRedirect("/cua-hang/hien-thi");
        } else {
            request.setAttribute("errors", errors);
            request.setAttribute("value", value);
            request.getRequestDispatcher("/view/CuaHang/viewAdd.jsp").forward(request,response);
        }

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        String diaChi = request.getParameter("diaChi");
        String thanhPho = request.getParameter("thanhPho");
        String quocGia = request.getParameter("quocGia");
        CuaHang value = new CuaHang(flag.getId(), flag.getMa(), ten, diaChi, thanhPho, quocGia);
        List<String> errors = validate.validateInput(value);

        if (errors.isEmpty()) {
            cuaHangService.update(value);
            response.sendRedirect("/cua-hang/hien-thi");
        } else {
            request.setAttribute("errors", errors);
            request.setAttribute("value", value);
            request.getRequestDispatcher("/view/CuaHang/viewUpdate.jsp").forward(request,response);

        }
    }
}
