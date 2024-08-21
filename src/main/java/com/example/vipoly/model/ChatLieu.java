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
@Table(name = "ChatLieu")
public class ChatLieu {
    @Id
    @Column(name = "IDChatLieu", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "Ma_ChatLieu", length = 50)
    private String maChatlieu;

    @Size(max = 50)
    @Nationalized
    @Column(name = "TenChatLieu", length = 50)
    private String tenChatLieu;

    @Column(name = "TrangThai")
    private Boolean trangThai;

}