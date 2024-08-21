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

import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    @Column(name = "IDKhachHang", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Nationalized
    @Column(name = "TenKhachHang", length = 50)
    private String tenKhachHang;

    @Size(max = 50)
    @Nationalized
    @Column(name = "SDT", length = 50)
    private String sdt;

    @Column(name = "NgaySinh")
    private LocalDate ngaySinh;

    @Size(max = 50)
    @Nationalized
    @Column(name = "Email", length = 50)
    private String email;

    @Size(max = 50)
    @Nationalized
    @Column(name = "DiaChi", length = 50)
    private String diaChi;

    @Column(name = "TrangThai")
    private Boolean trangThai;

}