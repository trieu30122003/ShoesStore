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
@Table(name = "hashTag_chi_tiet")
public class HashTagChiTiet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hashTag_chi_tiet")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "id_hashTag")
    private HashTag hashTag;

    @ManyToOne()
    @JoinColumn(name = "id_giay")
    private Giay giay;

    @Column(name = "ngay_tao")
    private Date ngayTao;

}
