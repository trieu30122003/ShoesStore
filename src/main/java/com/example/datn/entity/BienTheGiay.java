package com.example.datn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bien_the_giay")
public class BienTheGiay implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bien_the_giay")
    private int id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "gia_ban")
    private BigDecimal giaBan;

    @Column(name = "gia_nhap")
    private BigDecimal giaNhap;

    @Column(name = "hinh_anh")
    private String hinhAnh;

    @Column(name = "so_luong")
    private int soLuong;

    @Column(name = "trang_thai", columnDefinition = " int default 0")
    private int trangThai;

    @ManyToOne()
    @JoinColumn(name = "id_kich_thuoc")
    private KichThuoc kichThuoc;

    @ManyToOne()
    @JoinColumn(name = "id_mau_sac")
    private MauSac mauSac;

    @ManyToOne()
    @JoinColumn(name = "id_giay")
    private Giay giay;
}
