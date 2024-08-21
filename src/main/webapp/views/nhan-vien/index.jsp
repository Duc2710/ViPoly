<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<!doctype html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Danh sách nhân viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            margin-top: 20px;
        }
        .table {
            border-radius: 8px;
            overflow: hidden;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        .table thead th {
            background-color: #007bff;
            color: white;
        }
        .table tbody tr:nth-child(odd) {
            background-color: #f2f2f2;
        }
        .table tbody tr:hover {
            background-color: #e9ecef;
        }
        .btn {
            border-radius: 5px;
        }
        .btn-success {
            background-color: #28a745;
            border-color: #28a745;
        }
        .btn-success:hover {
            background-color: #218838;
            border-color: #1e7e34;
        }
        .btn-warning {
            background-color: #ffc107;
            border-color: #ffc107;
        }
        .btn-warning:hover {
            background-color: #e0a800;
            border-color: #d39e00;
        }
        .btn-danger {
            background-color: #dc3545;
            border-color: #dc3545;
        }
        .btn-danger:hover {
            background-color: #c82333;
            border-color: #bd2130;
        }
    </style>
</head>
<body class="container">

<h1 class="text-center my-4">Danh sách nhân viên</h1>

<a href="/nhan-vien/create" class="btn btn-success mb-3"><i class="bi bi-plus-circle"></i> Thêm mới nhân viên</a>

<table class="table table-bordered table-striped table-hover">
    <thead>
    <tr style="text-align: center">
        <th>ID</th>
        <th>Mã nhân viên</th>
        <th>Tên</th>
        <th>Chức vụ</th>
        <th>Ngày sinh</th>
        <th>Số điện thoại</th>
        <th>Email</th>
        <th>Giới tính</th>
        <th>Địa chỉ</th>
        <th>Mật khẩu</th>
        <th>Trạng thái</th>
        <th colspan="2">Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${data}" var="nv">
        <tr>
            <td>${nv.id}</td>
            <td>${nv.maNhanvien}</td>
            <td>${nv.hoTen}</td>
            <td>${nv.getChucVuDescription()}</td>
            <td>${nv.ngaySinh}</td>
            <td>${nv.sdt}</td>
            <td>${nv.email}</td>
            <td>${nv.getGioiTinhDescription()}</td>
            <td>${nv.diaChi}</td>
            <td>${nv.matKhau}</td>
            <td>${nv.getTrangThaiDescription()}</td>
            <td>
                <a href="/nhan-vien/edit/${nv.id}" class="btn btn-warning"><i class="bi bi-pencil"></i> Sửa</a>
            </td>
            <td>
                <a href="/nhan-vien/delete/${nv.id}" class="btn btn-danger"><i class="bi bi-trash"></i> Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
