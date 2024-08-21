package com.example.vipoly.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @Column(name = "IDHoaDon", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KhachHang")
    private KhachHang idKhachhang;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_NhanVien")
    private NhanVien idNhanvien;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_KhuyenMai")
    private KhuyenMai idKhuyenmai;

    @Size(max = 50)
    @Column(name = "Ma_HoaDon", length = 50)
    private String maHoadon;

    @Column(name = "TienSauGiamGia", precision = 18)
    private BigDecimal tienSauGiamGia;

    @Column(name = "ThanhTien", precision = 18)
    private BigDecimal thanhTien;

    @Column(name = "PhuongThucThanhToan")
    private Boolean phuongThucThanhToan;

    @Column(name = "NgayThanhToan")
    private LocalDate ngayThanhToan;

    @Column(name = "TrangThai")
    private Boolean trangThai;

}