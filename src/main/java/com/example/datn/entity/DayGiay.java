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
@Table(name = "day_giay")
public class DayGiay implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_day_giay")
    private int id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "mau_sac")
    private String mauSac;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "trang_thai", columnDefinition = " int default 0")
    private int trangThai;

    @Column(name = "ngay_tao")
    private Date ngayTao;
}
