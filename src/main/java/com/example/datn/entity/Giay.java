package com.example.datn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "giay")
public class Giay implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_giay")
    private int id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "ngay_san_xuat")
    private Date ngaySanXuat;

    @ManyToOne()
    @JoinColumn(name = "id_chat_lieu")
    private ChatLieu chatLieu;

    @ManyToOne()
    @JoinColumn(name = "id_co_giay")
    private CoGiay coGiay;

    @ManyToOne()
    @JoinColumn(name = "id_day_giay")
    private DayGiay dayGiay;

    @ManyToOne()
    @JoinColumn(name = "id_de_giay")
    private DeGiay deGiay;

    @ManyToOne()
    @JoinColumn(name = "id_lot_giay")
    private LotGiay lotGiay;

    @ManyToOne()
    @JoinColumn(name = "id_mui_giay")
    private MuiGiay muiGiay;

    @ManyToOne()
    @JoinColumn(name = "id_thuong_hieu")
    private ThuongHieu thuongHieu;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "trang_thai", columnDefinition = " int default 0")
    private int trangThai;
}
