package com.fpt.poly.lab.controller;


import com.fpt.poly.lab.entity.ChucVu;
import com.fpt.poly.lab.service.CommonService;
import com.fpt.poly.lab.service.impl.ChucVuServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChucVuServlet", value = {"/chuc-vu/hien-thi", "/chuc-vu/view-update", "/chuc-vu/update", "/chuc-vu/view-add", "/chuc-vu/add", "/chuc-vu/detail", "/chuc-vu/delete"})
public class ChucVuServlet extends HttpServlet {

    private final CommonService chucVuService = new ChucVuServiceImpl();
    private List<ChucVu> list = new ArrayList<ChucVu>();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.equals("/chuc-vu/hien-thi")) {
            this.hienThi(request, response);
        } else if (url.equals("/chuc-vu/view-update")) {
            this.viewUpdate(request, response);

        } else if (url.equals("/chuc-vu/view-add")) {
            this.viewAdd(request, response);

        } else if (url.equals("/chuc-vu/delete")) {
            this.delete(request, response);

        } else if (url.equals("/chuc-vu/detail")) {
            this.detail(request, response);

        } else {
            this.hienThi(request, response);

        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = chucVuService.getAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/view/ChucVu/viewListTable.jsp").forward(request, response);
    }

    private ChucVu flag;

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChucVu khachHang = (ChucVu) chucVuService.getOne((request.getParameter("id")));
        flag = khachHang;
        request.setAttribute("value", khachHang);
        request.getRequestDispatcher("/view/ChucVu/viewUpdate.jsp").forward(request, response);

    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/view/ChucVu/viewAdd.jsp");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        chucVuService.delete(chucVuService.getOne((request.getParameter("id"))));
        response.sendRedirect("/chuc-vu/hien-thi");

    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ChucVu khachHang = (ChucVu) chucVuService.getOne((request.getParameter("id")));
        request.setAttribute("value", khachHang);
        request.getRequestDispatcher("/view/ChucVu/viewDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.equals("/chuc-vu/add")) {
            this.add(request, response);
        } else if (url.equals("/chuc-vu/update")) {
            this.update(request, response);

        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        ChucVu value = new ChucVu(String.valueOf(UUID.randomUUID()), null, ten);
        chucVuService.add(value);
        response.sendRedirect("/chuc-vu/hien-thi");

    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        ChucVu value = new ChucVu(flag.getId(), flag.getMa(), ten);
        chucVuService.update(value);
        response.sendRedirect("/chuc-vu/hien-thi");
    }
}
