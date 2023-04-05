package com.fpt.poly.lab.controller;


import com.fpt.poly.lab.entity.DongSP;
import com.fpt.poly.lab.service.CommonService;
import com.fpt.poly.lab.service.impl.DongSPServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "DongSPServlet", value = {"/dong-sp/hien-thi", "/dong-sp/view-update", "/dong-sp/update", "/dong-sp/view-add", "/dong-sp/add", "/dong-sp/detail", "/dong-sp/delete"})
public class DongSPServlet extends HttpServlet {

    private final CommonService dongSPService = new DongSPServiceImpl();
    private List<DongSP> list = new ArrayList<DongSP>();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.equals("/dong-sp/hien-thi")) {
            this.hienThi(request, response);
        } else if (url.equals("/dong-sp/view-update")) {
            this.viewUpdate(request, response);

        } else if (url.equals("/dong-sp/view-add")) {
            this.viewAdd(request, response);

        } else if (url.equals("/dong-sp/delete")) {
            this.delete(request, response);

        } else if (url.equals("/dong-sp/detail")) {
            this.detail(request, response);

        } else {
            this.hienThi(request, response);

        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = dongSPService.getAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/view/DongSP/viewListTable.jsp").forward(request, response);
    }

    private DongSP flag;

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DongSP khachHang = (DongSP) dongSPService.getOne((request.getParameter("id")));
        flag = khachHang;
        request.setAttribute("value", khachHang);
        request.getRequestDispatcher("/view/DongSP/viewUpdate.jsp").forward(request, response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/view/DongSP/viewAdd.jsp");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        dongSPService.delete(dongSPService.getOne((request.getParameter("id"))));
        response.sendRedirect("/dong-sp/hien-thi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DongSP khachHang = (DongSP) dongSPService.getOne((request.getParameter("id")));
        request.setAttribute("value", khachHang);
        request.getRequestDispatcher("/view/DongSP/viewDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.equals("/dong-sp/add")) {
            this.add(request, response);
        } else if (url.equals("/dong-sp/update")) {
            this.update(request, response);

        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        DongSP value = new DongSP(String.valueOf(UUID.randomUUID()), null, ten);
        dongSPService.add(value);
        response.sendRedirect("/dong-sp/hien-thi");

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        DongSP value = new DongSP(flag.getId(), flag.getMa(), ten);
        dongSPService.update(value);
        response.sendRedirect("/dong-sp/hien-thi");
    }
}
