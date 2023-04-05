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
<nav class="navbar navbar-expand-lg navbar-light bg-light" >
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img th:src="@{/images/logo.png}"  src="../static/images/logo.png" width="auto" height="40" class="d-inline-block align-top" alt=""/>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

    </div>
</nav>
<div class="jumbotron text-center">
    <h1 class="display-4">Welcome back, Home</h1>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 pt-3" >
            <div class="card" style="background-color:white;">
                <div class="card-body">
                    <h4 class="card-title">Khách hàng</h4>
                    <a href="/khach-hang/hien-thi"  class="card-link btn btn-primary">Quản lý</a>

                </div>
            </div>
        </div>
        <div class="col-sm-3 pt-3" >
            <div class="card" style="background-color:white;">
                <div class="card-body">
                    <h4 class="card-title">Chi Tiết sản phẩm</h4>
                    <a href="/chi-tiet-san-pham/hien-thi" class="card-link btn btn-primary">Quản lý</a>

                </div>
            </div>
        </div>


        <div class="col-sm-3 pt-3" >
            <div class="card" style="background-color:white;">
                <div class="card-body">
                    <h4 class="card-title">Sản phẩm</h4>
                    <a href="/san-pham/hien-thi"  class="card-link btn btn-primary">Quản lý</a>

                </div>
            </div>
        </div>
        <div class="col-sm-3 pt-3" >
            <div class="card" style="background-color:white;">
                <div class="card-body">
                    <h4 class="card-title">Dòng sản phẩm</h4>
                    <a href="/dong-sp/hien-thi" class="card-link btn btn-primary">Quản lý</a>

                </div>
            </div>
        </div>

        <div class="col-sm-3 pt-3" >
            <div class="card" style="background-color:white;">
                <div class="card-body">
                    <h4 class="card-title">NSX</h4>
                    <a href="/nsx/hien-thi"  class="card-link btn btn-primary">Quản lý</a>

                </div>
            </div>
        </div>
        <div class="col-sm-3 pt-3" >
            <div class="card" style="background-color:white;">
                <div class="card-body">
                    <h4 class="card-title">Màu sắc</h4>
                    <a href="/mau-sac/hien-thi" class="card-link btn btn-primary">Quản lý</a>

                </div>
            </div>
        </div>

        <div class="col-sm-3 pt-3" >
            <div class="card" style="background-color:white;">
                <div class="card-body">
                    <h4 class="card-title">Nhân viên</h4>
                    <a href="/nhan-vien/hien-thi"  class="card-link btn btn-primary">Quản lý</a>

                </div>
            </div>
        </div>
        <div class="col-sm-3 pt-3" >
            <div class="card" style="background-color:white;">
                <div class="card-body">
                    <h4 class="card-title">Cửa hàng</h4>
                    <a href="/cua-hang/hien-thi" class="card-link btn btn-primary">Quản lý</a>

                </div>
            </div>
        </div>

        <div class="col-sm-3 pt-3" >
            <div class="card" style="background-color:white;">
                <div class="card-body">
                    <h4 class="card-title">Chức vụ</h4>
                    <a href="/chuc-vu/hien-thi"  class="card-link btn btn-primary">Quản lý</a>

                </div>
            </div>
        </div>


    </div>
</div>



<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>