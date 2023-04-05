package com.fpt.poly.lab.controller;


import com.fpt.poly.lab.entity.ChiTietSP;
import com.fpt.poly.lab.entity.DongSP;
import com.fpt.poly.lab.entity.MauSac;
import com.fpt.poly.lab.entity.NSX;
import com.fpt.poly.lab.entity.SanPham;
import com.fpt.poly.lab.service.CommonService;
import com.fpt.poly.lab.service.impl.ChiTietSPServiceImpl;

import com.fpt.poly.lab.service.impl.DongSPServiceImpl;
import com.fpt.poly.lab.service.impl.MauSacServiceImpl;
import com.fpt.poly.lab.service.impl.NSXServiceImpl;
import com.fpt.poly.lab.service.impl.SanPhamServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChiTietSPServlet", value = {"/chi-tiet-san-pham/hien-thi", "/chi-tiet-san-pham/view-update", "/chi-tiet-san-pham/update", "/chi-tiet-san-pham/view-add", "/chi-tiet-san-pham/add", "/chi-tiet-san-pham/detail", "/chi-tiet-san-pham/delete"})
public class ChiTietSPServlet extends HttpServlet {

    private final CommonService chiTietSPService = new ChiTietSPServiceImpl();
    private final CommonService mauSacService = new MauSacServiceImpl();
    private final CommonService dongSPService = new DongSPServiceImpl();
    private final CommonService sanPhamService = new SanPhamServiceImpl();
    private final CommonService nsxService = new NSXServiceImpl();

    private List<ChiTietSP> list = new ArrayList<ChiTietSP>();

    List<MauSac> listMauSac = mauSacService.getAll();
    List<DongSP> listDongSP = dongSPService.getAll();
    List<SanPham> listSanPham = sanPhamService.getAll();
    List<NSX> listNSX = nsxService.getAll();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.equals("/chi-tiet-san-pham/hien-thi")) {
            this.hienThi(request, response);
        } else if (url.equals("/chi-tiet-san-pham/view-update")) {
            this.viewUpdate(request, response);

        } else if (url.equals("/chi-tiet-san-pham/view-add")) {
            this.viewAdd(request, response);

        } else if (url.equals("/chi-tiet-san-pham/delete")) {
            this.delete(request, response);

        } else if (url.equals("/chi-tiet-san-pham/detail")) {
            this.detail(request, response);

        } else {
            this.hienThi(request, response);

        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        list = chiTietSPService.getAll();
        request.setAttribute("list", list);
        request.getRequestDispatcher("/view/ChiTietSP/viewListTable.jsp").forward(request, response);
    }

    private ChiTietSP flag;

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ChiTietSP value = (ChiTietSP) chiTietSPService.getOne((request.getParameter("id")));
        flag = value;

        request.setAttribute("listMauSac", listMauSac);
        request.setAttribute("listDongSP", listDongSP);
        request.setAttribute("listSanPham", listSanPham);
        request.setAttribute("listNSX", listNSX);
        request.setAttribute("value", value);
        request.getRequestDispatcher("/view/ChiTietSP/viewUpdate.jsp").forward(request, response);

    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.setAttribute("listMauSac", listMauSac);
        request.setAttribute("listDongSP", listDongSP);
        request.setAttribute("listSanPham", listSanPham);
        request.setAttribute("listNSX", listNSX);

        request.getRequestDispatcher("/view/ChiTietSP/viewAdd.jsp").forward(request, response);

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        chiTietSPService.delete(chiTietSPService.getOne((request.getParameter("id"))));
        response.sendRedirect("/chi-tiet-san-pham/hien-thi");

    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ChiTietSP value = (ChiTietSP) chiTietSPService.getOne((request.getParameter("id")));
        request.setAttribute("value", value);
        System.out.println(value.toString());
        request.getRequestDispatcher("/view/ChiTietSP/viewDetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.equals("/chi-tiet-san-pham/add")) {
            this.add(request, response);
        } else if (url.equals("/chi-tiet-san-pham/update")) {
            this.update(request, response);

        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        String namBH = request.getParameter("namBH");
        String moTa = request.getParameter("moTa");
        String soLuongTon = request.getParameter("soLuongTon");
        String giaNhap = request.getParameter("giaNhap");
        String giaBan = request.getParameter("giaBan");
        MauSac mauSac = (MauSac) mauSacService.getOne(request.getParameter("mauSac"));
        DongSP dongSP = (DongSP) dongSPService.getOne(request.getParameter("dongSP"));
        SanPham sanPham = (SanPham) sanPhamService.getOne(request.getParameter("sanPham"));
        NSX nsx = (NSX) nsxService.getOne(request.getParameter("nsx"));
        ChiTietSP value = new ChiTietSP(String.valueOf(UUID.randomUUID()), sanPham, nsx, mauSac, dongSP, Integer.parseInt(namBH), moTa, Integer.parseInt(soLuongTon), BigDecimal.valueOf(Long.valueOf(giaNhap)), BigDecimal.valueOf(Long.valueOf(giaBan)));
        chiTietSPService.add(value);
        response.sendRedirect("/chi-tiet-san-pham/hien-thi");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String namBH = request.getParameter("namBH");
        String moTa = request.getParameter("moTa");
        String soLuongTon = request.getParameter("soLuongTon");
        String giaNhap = request.getParameter("giaNhap");
        String giaBan = request.getParameter("giaBan");
        MauSac mauSac = (MauSac) mauSacService.getOne(request.getParameter("mauSac"));
        DongSP dongSP = (DongSP) dongSPService.getOne(request.getParameter("dongSP"));
        SanPham sanPham = (SanPham) sanPhamService.getOne(request.getParameter("sanPham"));
        NSX nsx = (NSX) nsxService.getOne(request.getParameter("nsx"));
        ChiTietSP value = new ChiTietSP(flag.getId(), sanPham, nsx, mauSac, dongSP, Integer.parseInt(namBH), moTa, Integer.parseInt(soLuongTon), BigDecimal.valueOf(Long.valueOf(giaNhap)), BigDecimal.valueOf(Long.valueOf(giaBan)));
        chiTietSPService.update(value);
        response.sendRedirect("/chi-tiet-san-pham/hien-thi");
    }
}
