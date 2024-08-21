package com.example.vipoly.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "HoaDonChiTiet")
public class HoaDonChiTiet {
    @Id
    @Column(name = "IDHoaDonChiTiet", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_HoaDon")
    private HoaDon idHoadon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ChiTietSanPham")
    private ChiTietSanPham idChitietsanpham;

    @Size(max = 50)
    @Column(name = "Ma_HoaDonChiTiet", length = 50)
    private String maHoadonchitiet;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia", precision = 18)
    private BigDecimal donGia;

    @Column(name = "TrangThai")
    private Boolean trangThai;

}