package com.example.datn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="gio_hang")
public class GioHang implements Serializable {

//    private static final long serialVersionUID = 5313493413859894403L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gio_hang")
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_giay")
    private Giay giay;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang")
    private KhachHang khachHang;

//    @Column(name = "create_date")
//    private Date createDate;
//
//    @Column(name = "update_date")
//    private Date updateDate;

    @Column(name = "trang_thai", columnDefinition = " int default 0")
    private int trangThai;

}
