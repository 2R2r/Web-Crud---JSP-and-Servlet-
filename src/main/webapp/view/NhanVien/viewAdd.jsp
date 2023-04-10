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
            <img th:src="@{/images/logo.png}" src="../static/images/logo.png" width="auto" height="40"
                 class="d-inline-block align-top" alt=""/>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
</nav>
<div class="container">
    <form action="/nhan-vien/add" method="post">
        <div class="row">
            <div class="col-sm-5">
                <div class="form-group">
                    <label>Tên</label>
                    <input type="text" name="ten" class="form-control" value="${value.ten}">
                    <span class="text-danger">${errors.contains('Tên không được để trống') ? 'Tên không được để trống' : ''}</span>
                </div>
                <div class="form-group">
                    <label>Tên Đệm</label>
                    <input type="text" class="form-control" value="${value.tenDem}" name="tenDem">
                    <span class="text-danger">${errors.contains('Tên đệm không được để trống') ? 'Tên đệm không được để trống' : ''}</span>
                </div>
                <div class="form-group">
                    <label>Họ</label>
                    <input type="text" class="form-control" value="${value.ho}" name="ho">
                    <span class="text-danger">${errors.contains('Họ không được để trống') ? 'Họ không được để trống' : ''}</span>
                </div>
                <div class="form-group">
                    <br>

                    <label>Giới tính</label>
                    <br>

                    Nam
                    <input type="radio" value="Nam" ${value.gioiTinh == 'Nam' ? 'checked' : ''} name="gioiTinh">
                    Nữ
                    <input type="radio" value="Nữ" ${value.gioiTinh == 'Nữ' ? 'checked' : ''} name="gioiTinh">
                    <br>
                    <span class="text-danger">${errors.contains('Vui lòng chọn giới tính') ? 'Vui lòng chọn giới tính' : ''}</span>

                    <br>
                </div>
                <div class="form-group">
                    <label>Ngày sinh</label>
                    <input type="date" class="form-control" required value="${value.ngaySinh}" name="ngaySinh">
                    <span class="text-danger">${errors.contains('Ngày sinh không được để trống.') ? 'Ngày sinh không được để trống.' : ''}</span>
                </div>
                <div class="form-group">
                    <label>Địa chỉ</label>
                    <input type="text" class="form-control" value="${value.diaChi}" name="diaChi">
                    <span class="text-danger">${errors.contains('Địa chỉ không được để trống') ? 'Địa chỉ không được để trống' : ''}</span>
                </div>
                <div class="form-group">
                    <label>SDT</label>
                    <input type="text" class="form-control" value="${value.sdt}" name="sdt">
                    <span class="text-danger">${errors.contains('Số điện thoại phải bắt đầu từ số 0 và gồm 11 chữ số.') ? 'Số điện thoại phải bắt đầu từ số 0 và gồm 11 chữ số.' : ''}</span>
                    <span class="text-danger">${errors.contains('Số điện thoại không được để trống.') ? 'Số điện thoại không được để trống.' : ''}</span>
                </div>

                <div class="form-group">
                    <label>Mật khẩu</label>
                    <input type="password" class="form-control" value="${value.matKhau}" name="matKhau">
                    <span class="text-danger">${errors.contains('Mật khẩu không được để trống') ? 'Mật khẩu không được để trống' : ''}</span>
                </div>

                <label for="cuaHang">Cửa hàng:</label>
                <select id="cuaHang" name="cuaHang" class="form-select">
                    <option value="" disabled selected>-- Chọn cửa hàng --</option>
                    <C:forEach items="${listCuaHang}" var="cuaHang">
                        <option value="${cuaHang.id}" ${cuaHang.id == value.cuaHang.id ? 'selected="true"' : ''}>${cuaHang.ten}</option>
                    </C:forEach>
                </select><br>
                <span class="text-danger">${errors.contains('Vui lòng chọn cửa hàng') ? 'Vui lòng chọn cửa hàng' : ''}</span>

                <br>
                <label for="chucVu">Chức vụ:</label>
                <select id="chucVu" name="chucVu" class="form-select">
                    <option value="" disabled selected>-- Chọn chức vụ --</option>
                    <C:forEach items="${listChucVu}" var="chucVu">
                        <option value="${chucVu.id}" ${chucVu.id == value.chucVu.id ? 'selected="true"' : ''}>${chucVu.ten}</option>
                    </C:forEach>
                </select><br>
                <span class="text-danger">${errors.contains('Vui lòng chọn chức vụ') ? 'Vui lòng chọn chức vụ' : ''}</span>

                <br>


                <div class="form-group">
                    <br>
                    <label>Trạng thái</label>
                    <br>
                    Nghỉ
                    <input type="radio" value="0" ${value.trangThai == '0' ? 'checked' : ''} name="trangThai">
                    Hoạt động
                    <input type="radio" value="1" ${value.trangThai == '1' ? 'checked' : ''} name="trangThai">
                    <br>
                    <span class="text-danger">${errors.contains('Vui lòng chọn trạng thái') ? 'Vui lòng chọn trạng thái' : ''}</span>
                    <br>

                </div>
                <button type="submit" class="btn btn-primary">Add</button>


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