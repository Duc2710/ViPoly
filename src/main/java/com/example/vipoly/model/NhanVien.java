package com.example.vipoly.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.time.LocalDate;
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDNhanVien", nullable = false)
    private Integer id;

    @NotBlank(message = "Mã nhân viên không được để trống")
    @Size(max = 50)
    @Column(name = "Ma_NhanVien", length = 50)
    private String maNhanvien;

    @NotBlank(message = "Tên nhân viên không được để trống")
    @Size(max = 50)
    @Nationalized
    @Column(name = "HoTen", length = 50)
    private String hoTen;

    @NotNull(message = "Chức vụ không được để trống")
    @Column(name = "ChucVu")
    private Boolean chucVu;

    @NotNull(message = "Ngày sinh không được để trống")
    @Past(message = "Ngày sinh phải là ngày trong quá khứ")
    @Column(name = "NgaySinh")
    private LocalDate ngaySinh;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Pattern(regexp = "^\\d{10}$", message = "Số điện thoại phải có 10 chữ số")
    @Column(name = "SDT", length = 10)
    private String sdt;

    @Email(message = "Email không hợp lệ")
    @NotBlank(message = "Email không được để trống")
    @Size(max = 50)
    @Nationalized
    @Column(name = "Email", length = 50)
    private String email;

    @NotNull(message = "Giới tính không được để trống")
    @Column(name = "GioiTinh")
    private Boolean gioiTinh;

    @Size(max = 50)
    @Nationalized
    @Column(name = "DiaChi", length = 50)
    private String diaChi;

    @Size(max = 32)
    @Nationalized
    @Column(name = "MatKhau", length = 32)
    private String matKhau;

    @NotNull(message = "Trạng thái không được để trống")
    @Column(name = "TrangThai")
    private Boolean trangThai;

    // Phương thức để lấy mô tả chức vụ
    public String getChucVuDescription() {
        return (chucVu != null && chucVu) ? "Quản lý" : "Nhân viên";
    }

    // Phương thức để lấy mô tả giới tính
    public String getGioiTinhDescription() {
        return (gioiTinh != null && gioiTinh) ? "Nam" : "Nữ";
    }

    // Phương thức để lấy mô tả trạng thái
    public String getTrangThaiDescription() {
        return (trangThai != null && trangThai) ? "Hoạt động" : "Ngừng hoạt động";
    }
}
