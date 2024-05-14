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
@Table(name = "de_giay")
public class DeGiay implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_de_giay")
    private int id;

    @Column(name = "ma")
    private String ma;

    @Column(name = "ten")
    private String ten;

    @Column(name = "mau_sac")
    private String mauSac;

    @Column(name = "chat_lieu")
    private String chatLieu;

    @Column(name = "mo_ta")
    private String moTa;

    @Column(name = "trang_thai", columnDefinition = " int default 0")
    private int trangThai;
}
