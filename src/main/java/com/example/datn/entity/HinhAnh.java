package com.example.datn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "hinh_anh")
public class HinhAnh implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hinh_anh")
    private int id;

    @Column(name = "base64_img", columnDefinition = "TEXT")
    private String base64Img;

    @Column(name = "uu_tien")
    private int uuTien;

    @ManyToOne()
    @JoinColumn(name = "id_giay")
    private Giay giay;

}
