package com.example.vipoly.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SanPham")
public class SanPham {
    @Id
    @Column(name = "IDSanPham", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IDLoaiSanPham")
    private LoaiSanPham iDLoaiSanPham;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ThuongHieu")
    private ThuongHieu idThuonghieu;

    @Size(max = 50)
    @Column(name = "Ma_SanPham", length = 50)
    private String maSanpham;

    @Size(max = 50)
    @Nationalized
    @Column(name = "KieuDang", length = 50)
    private String kieuDang;

    @Size(max = 100)
    @Nationalized
    @Column(name = "TenSanPham", length = 100)
    private String tenSanPham;

    @Size(max = 200)
    @Column(name = "Url_Anh", length = 200)
    private String urlAnh;

    @Column(name = "TrangThai")
    private Boolean trangThai;

}