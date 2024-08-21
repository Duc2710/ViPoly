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
@Table(name = "MauSac")
public class MauSac {
    @Id
    @Column(name = "IDMauSac", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "Ma_MauSac", length = 50)
    private String maMausac;

    @Size(max = 50)
    @Nationalized
    @Column(name = "TenMauSac", length = 50)
    private String tenMauSac;

    @Column(name = "TrangThai")
    private Boolean trangThai;

}