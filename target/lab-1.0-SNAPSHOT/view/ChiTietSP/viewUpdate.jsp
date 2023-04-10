<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img th:src="@{/images/logo.png}" src="../static/images/logo.png"  width="auto" height="40"
                 class="d-inline-block align-top" alt=""/>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
</nav>
<div class="container">
    <form action="/chi-tiet-san-pham/update" method="post" >
        <div class="row">
            <div class="col-sm-5">

                <label for="sanPham">Sản phẩm:</label>
                <select id="sanPham" name="sanPham"  class="form-select">
                    <option value="" disabled selected>-- Chọn sản phẩm --</option>
                    <C:forEach items="${listSanPham}" var="sanPham">
                        <option value="${sanPham.id}" ${sanPham.id == value.sanPham.id ? 'selected' : ''}>${sanPham.ten}</option>
                    </C:forEach>
                </select>
                <br>
                <span class="text-danger">${errors.contains('Sản phẩm không được bỏ trống') ? 'Sản phẩm không được bỏ trống' : ''}</span>
                <br>

                <label for="nsx">Nhà sản xuất:</label>
                <select id="nsx" name="nsx"  class="form-select">
                    <option value="" disabled selected>-- Chọn nhà sản xuất --</option>
                    <C:forEach items="${listNSX}" var="nsx">
                        <option value="${nsx.id}" ${nsx.id == value.nsx.id ? 'selected' : ''}>${nsx.ten}</option>
                    </C:forEach>
                </select>
                <br>
                <span class="text-danger">${errors.contains('Nhà sản xuất không được bỏ trống') ? 'Nhà sản xuất không được bỏ trống' : ''}</span>
                <br>


                <label for="mauSac">Màu sắc:</label>
                <select id="mauSac" name="mauSac"  class="form-select">
                    <option value="" disabled selected>-- Chọn màu sắc --</option>
                    <C:forEach items="${listMauSac}" var="mauSac">
                        <option value="${mauSac.id}" ${mauSac.id == value.mauSac.id ? 'selected' : ''}>${mauSac.ten}</option>
                    </C:forEach>
                </select>
                <br>
                <span class="text-danger">${errors.contains('Màu sắc không được bỏ trống') ? 'Màu sắc không được bỏ trống' : ''}</span>
                <br>

                <label for="dongSP">Dòng sản phẩm:</label>
                <select id="dongSP" name="dongSP"  class="form-select">
                    <option value="" disabled selected>-- Chọn dòng sản phẩm --</option>
                    <C:forEach items="${listDongSP}" var="dongSP">
                        <option value="${dongSP.id}" ${dongSP.id == value.dongSP.id ? 'selected' : ''}>${dongSP.ten}</option>
                    </C:forEach>
                </select>
                <br>
                <span class="text-danger">${errors.contains('Dòng sản phẩm không được bỏ trống') ? 'Dòng sản phẩm không được bỏ trống' : ''}</span>
                <br>


                <div class="form-group">
                    <label >Năm bảo hành</label>
                    <input type="text" name="namBH" class="form-control"  value="${value.namBH}">
                    <span class="text-danger">${errors.contains('Năm bảo hành phải là một số') ? 'Năm bảo hành phải là một số' : ''}</span>

                </div>

                <div class="form-group">
                    <label >Mô tả</label>
                    <input type="text" class="form-control"  value="${value.moTa}" name="moTa">
                    <span class="text-danger">${errors.contains('Mô tả không được bỏ trống') ? 'Mô tả không được bỏ trống' : ''}</span>

                </div>
                <div class="form-group">
                    <label >Số lượng tồn</label>
                    <input type="text" class="form-control"  value="${value.soLuongTon}" name="soLuongTon">
                    <span class="text-danger">${errors.contains('Số lượng tồn phải là một số') ? 'Số lượng tồn phải là một số' : ''}</span>

                </div>

                <div class="form-group">
                    <label >Giá nhập</label>
                    <input type="text" class="form-control"  value="${value.giaNhap}" name="giaNhap">
                    <span class="text-danger">${errors.contains('Giá nhập phải là một số') ? 'Giá nhập phải là một số' : ''}</span>

                </div>
                <div class="form-group">
                    <label >Giá bán</label>
                    <input type="text" class="form-control"  value="${value.giaBan}" name="giaBan">
                    <span class="text-danger">${errors.contains('Giá bán phải là một số') ? 'Giá bán phải là một số' : ''}</span>

                </div>

                <button type="submit" class="btn btn-primary">Update</button>

            </div>

        </div>
    </form>
</div>


<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>

</body>
</html>