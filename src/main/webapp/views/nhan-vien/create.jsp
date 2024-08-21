<%@page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thêm mới nhân viên</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <style>
        .form-container {
            max-width: 800px;
            margin: auto;
            padding: 2rem;
            border: 1px solid #d1d1d1;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        .form-container h1 {
            margin-bottom: 1.5rem;
        }
        .form-group {
            margin-bottom: 1.5rem;
        }
        .form-group label {
            font-weight: bold;
        }
        .form-group input[type="radio"] {
            margin-right: 0.5rem;
        }
        .form-group input[type="text"], .form-group input[type="email"], .form-group input[type="date"], .form-group input[type="number"] {
            width: 100%;
        }
        .btn-submit {
            background-color: #007bff;
            color: #fff;
            border: none;
            padding: 0.5rem 1.5rem;
            font-size: 1rem;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn-submit:hover {
            background-color: #0056b3;
        }
        .btn-back {
            background-color: #6c757d;
            color: #fff;
            border: none;
            padding: 0.5rem 1.5rem;
            font-size: 1rem;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn-back:hover {
            background-color: #5a6268;
        }
        .error {
            color: red;
            font-size: 0.875rem;
        }
    </style>
</head>
<body class="container">
<h1 class="text-center mt-4 mb-4">Thêm mới nhân viên</h1>
<div class="form-container">
    <form action="/nhan-vien/store" method="post">
        <div class="form-group">
            <label for="maNhanVien">Mã Nhân Viên:</label>
            <input type="text" id="maNhanVien" name="maNhanvien" value="${maNhanVienMoi}" readonly class="form-control"/>
        </div>

        <div class="form-group">
            <label for="hoTen">Tên nhân viên:</label>
            <input type="text" id="hoTen" name="hoTen" class="form-control" required/>
            <c:if test="${not empty errorMap['hoTen']}">
                <div class="error">${errorMap['hoTen']}</div>
            </c:if>
        </div>

        <div class="form-group">
            <label>Chức vụ:</label>
            <div>
                <input type="radio" id="chucVuQuanLy" name="chucVu" value="true" required/>
                <label for="chucVuQuanLy">Quản lý</label>
                <input type="radio" id="chucVuNhanVien" name="chucVu" value="false"/>
                <label for="chucVuNhanVien">Nhân viên</label>
            </div>
            <c:if test="${not empty errorMap['chucVu']}">
                <div class="error">${errorMap['chucVu']}</div>
            </c:if>
        </div>

        <div class="form-group">
            <label for="ngaySinh">Ngày sinh:</label>
            <input type="date" id="ngaySinh" name="ngaySinh" class="form-control" required/>
            <c:if test="${not empty errorMap['ngaySinh']}">
                <div class="error">${errorMap['ngaySinh']}</div>
            </c:if>
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" class="form-control" required/>
            <c:if test="${not empty errorMap['email']}">
                <div class="error">${errorMap['email']}</div>
            </c:if>
        </div>

        <div class="form-group">
            <label for="sdt">Số điện thoại:</label>
            <input type="number" id="sdt" name="sdt" class="form-control" required min="100000000" max="999999999"/>
            <c:if test="${not empty errorMap['sdt']}">
                <div class="error">${errorMap['sdt']}</div>
            </c:if>
        </div>

        <div class="form-group">
            <label>Giới tính:</label>
            <div>
                <input type="radio" id="gioiTinhNam" name="gioiTinh" value="true" required/>
                <label for="gioiTinhNam">Nam</label>
                <input type="radio" id="gioiTinhNu" name="gioiTinh" value="false"/>
                <label for="gioiTinhNu">Nữ</label>
            </div>
            <c:if test="${not empty errorMap['gioiTinh']}">
                <div class="error">${errorMap['gioiTinh']}</div>
            </c:if>
        </div>

        <div class="form-group">
            <label for="diaChi">Địa chỉ:</label>
            <input type="text" id="diaChi" name="diaChi" class="form-control"/>
        </div>

        <div class="form-group">
            <label for="matKhau">Mật khẩu:</label>
            <input type="text" id="matKhau" name="matKhau" class="form-control" required/>
            <c:if test="${not empty errorMap['matKhau']}">
                <div class="error">${errorMap['matKhau']}</div>
            </c:if>
        </div>

        <div class="form-group">
            <label>Trạng thái:</label>
            <div>
                <input type="radio" id="trangThaiHoatDong" name="trangThai" value="1" required/>
                <label for="trangThaiHoatDong">Đang hoạt động</label>
                <input type="radio" id="trangThaiNgungHoatDong" name="trangThai" value="0"/>
                <label for="trangThaiNgungHoatDong">Ngừng hoạt động</label>
            </div>
            <c:if test="${not empty errorMap['trangThai']}">
                <div class="error">${errorMap['trangThai']}</div>
            </c:if>
        </div>

        <div class="form-group text-center">
            <button type="submit" class="btn-submit">Thêm</button>
            <a href="/nhan-vien/hien-thi" class="btn-back">Quay lại</a>
        </div>
    </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
