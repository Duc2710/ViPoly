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
@Table(name = "ThuongHieu")
public class ThuongHieu {
    @Id
    @Column(name = "IDThuongHieu", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "Ma_ThuongHieu", length = 50)
    private String maThuonghieu;

    @Size(max = 50)
    @Nationalized
    @Column(name = "TenThuongHieu", length = 50)
    private String tenThuongHieu;

    @Column(name = "TrangThai")
    private Boolean trangThai;

}