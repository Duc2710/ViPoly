package com.example.vipoly.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ChiTietSanPham")
public class ChiTietSanPham {
    @Id
    @Column(name = "IDChiTietSanPham", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SanPham")
    private SanPham idSanpham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MauSac")
    private MauSac idMausac;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ChatLieu")
    private ChatLieu idChatlieu;

    @Size(max = 50)
    @Column(name = "Ma_ChiTietSanPham", length = 50)
    private String maChitietsanpham;

    @Size(max = 50)
    @Nationalized
    @Column(name = "KhoaSanPham", length = 50)
    private String khoaSanPham;

    @Column(name = "SoLuong", precision = 18)
    private BigDecimal soLuong;

    @Column(name = "GiaNhap", precision = 18, scale = 2)
    private BigDecimal giaNhap;

    @Column(name = "GiaBan", precision = 18, scale = 2)
    private BigDecimal giaBan;

    @Column(name = "NgayNhap")
    private LocalDate ngayNhap;

    @Column(name = "TrangThai")
    private Boolean trangThai;

}