package com.fpt.poly.lab.controller;


import com.fpt.poly.lab.entity.NSX;
import com.fpt.poly.lab.service.CommonService;
import com.fpt.poly.lab.service.impl.NSXServiceImpl;
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

@WebServlet(name = "NSXServlet", value = {"/nsx/hien-thi", "/nsx/view-update", "/nsx/update", "/nsx/view-add", "/nsx/add", "/nsx/detail", "/nsx/delete"})
public class NSXServlet extends HttpServlet {
    private CommonService service = new NSXServiceImpl();
    private List<NSX> list = new ArrayList<NSX>();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.equals("/nsx/hien-thi")) {
            this.hienThi(request, response);
        } else if (url.equals("/nsx/view-update")) {
            this.viewUpdate(request, response);

        } else if (url.equals("/nsx/view-add")) {
            this.viewAdd(request, response);

        } else if (url.equals("/nsx/delete")) {
            this.delete(request, response);

        } else if (url.equals("/nsx/detail")) {
            this.detail(request, response);

        } else {
            this.hienThi(request, response);

        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = service.getAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/view/NSX/viewListTable.jsp").forward(request, response);
    }

    private NSX flag;

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NSX khachHang = (NSX) service.getOne((request.getParameter("id")));
        flag = khachHang;
        request.setAttribute("value", khachHang);
        request.getRequestDispatcher("/view/NSX/viewUpdate.jsp").forward(request, response);

    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/view/NSX/viewAdd.jsp");
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.delete(service.getOne((request.getParameter("id"))));
        response.sendRedirect("/nsx/hien-thi");

    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        NSX khachHang = (NSX) service.getOne((request.getParameter("id")));
        request.setAttribute("value", khachHang);
        request.getRequestDispatcher("/view/NSX/viewDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.equals("/nsx/add")) {
            this.add(request, response);
        } else if (url.equals("/nsx/update")) {
            this.update(request, response);

        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        NSX value = new NSX(String.valueOf(UUID.randomUUID()), null, ten);
        String errors = validate.validateInput(value);

        if(errors == null) {
            service.add(value);
            response.sendRedirect("/nsx/hien-thi");
        } else {
            request.setAttribute("errors", errors);
            request.setAttribute("value", value);
            request.getRequestDispatcher("/view/NSX/viewAdd.jsp").forward(request, response);

        }


    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String ten = request.getParameter("ten");
        NSX value = new NSX(flag.getId(), flag.getMa(), ten);
        String errors = validate.validateInput(value);
        if(errors == null) {
            service.update(value);
            response.sendRedirect("/nsx/hien-thi");
        } else {
            request.setAttribute("errors", errors);
            request.setAttribute("value", value);
            request.getRequestDispatcher("/view/NSX/viewUpdate.jsp").forward(request, response);

        }
    }
}
