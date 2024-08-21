package com.example.vipoly.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "KhuyenMai")
public class KhuyenMai {
    @Id
    @Column(name = "IDKhuyenMai", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Nationalized
    @Column(name = "Ma_KhuyenMai", length = 50)
    private String maKhuyenmai;

    @Column(name = "GiaTri")
    private Integer giaTri;

    @Column(name = "NgayBatDau")
    private LocalDate ngayBatDau;

    @Column(name = "NgayKetThuc")
    private LocalDate ngayKetThuc;

    @Column(name = "KieuGiamGia", precision = 18)
    private BigDecimal kieuGiamGia;

    @Column(name = "TrangThai")
    private Boolean trangThai;

}