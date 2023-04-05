package com.fpt.poly.lab.controller;


import com.fpt.poly.lab.entity.MauSac;
import com.fpt.poly.lab.service.CommonService;
import com.fpt.poly.lab.service.impl.MauSacServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "MauSacServlet", value = {"/mau-sac/hien-thi", "/mau-sac/view-update", "/mau-sac/update", "/mau-sac/view-add", "/mau-sac/add", "/mau-sac/detail", "/mau-sac/delete"})
public class MauSacServlet extends HttpServlet {

    private final CommonService mauSacService = new MauSacServiceImpl();
    private List<MauSac> list = new ArrayList<MauSac>();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.equals("/mau-sac/hien-thi")) {
            this.hienThi(request, response);
        } else if (url.equals("/mau-sac/view-update")) {
            this.viewUpdate(request, response);

        } else if (url.equals("/mau-sac/view-add")) {
            this.viewAdd(request, response);

        } else if (url.equals("/mau-sac/delete")) {
            this.delete(request, response);

        } else if (url.equals("/mau-sac/detail")) {
            this.detail(request, response);

        } else {
            this.hienThi(request, response);

        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = mauSacService.getAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/view/MauSac/viewListTable.jsp").forward(request, response);
    }

    private MauSac flag;

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MauSac khachHang = (MauSac) mauSacService.getOne((request.getParameter("id")));
        flag = khachHang;
        request.setAttribute("value", khachHang);
        request.getRequestDispatcher("/view/MauSac/viewUpdate.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/view/MauSac/viewAdd.jsp");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        mauSacService.delete(mauSacService.getOne((request.getParameter("id"))));
        response.sendRedirect("/mau-sac/hien-thi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        MauSac khachHang = (MauSac) mauSacService.getOne((request.getParameter("id")));
        request.setAttribute("value", khachHang);
        request.getRequestDispatcher("/view/MauSac/viewDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.equals("/mau-sac/add")) {
            this.add(request, response);
        } else if (url.equals("/mau-sac/update")) {
            this.update(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        MauSac value = new MauSac(String.valueOf(UUID.randomUUID()), null, ten);
        mauSacService.add(value);
        response.sendRedirect("/mau-sac/hien-thi");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        MauSac value = new MauSac(flag.getId(), flag.getMa(), ten);
        mauSacService.update(value);
        response.sendRedirect("/mau-sac/hien-thi");
    }
}
