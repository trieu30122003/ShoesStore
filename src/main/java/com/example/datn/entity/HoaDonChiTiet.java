package com.example.datn.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="hoa_don_chi_tiet")
public class HoaDonChiTiet implements Serializable {

//    private static final long serialVersionUID = 5313493413859894403L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hdct")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_hoa_don")
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "id_bien_the_giay")
    private BienTheGiay bienTheGiay;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "gia_goc")
    private BigDecimal giaGoc;

    @Column(name = "gia")
    private BigDecimal gia;

//    @Column(name = "create_date")
//    private Date createDate;
//
//    @Column(name = "update_time")
//    private Date updateTime;

    @Column(name = "trang_thai", columnDefinition = " int default 0")
    private int trangThai;


}
