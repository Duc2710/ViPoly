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

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LoaiSanPham")
public class LoaiSanPham {
    @Id
    @Column(name = "IDLoaiSanPham", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "Ma_LoaiSanPham", length = 50)
    private String maLoaisanpham;

    @Size(max = 50)
    @Nationalized
    @Column(name = "TenLoaiSanPham", length = 50)
    private String tenLoaiSanPham;

    @Column(name = "TrangThai")
    private Boolean trangThai;

}