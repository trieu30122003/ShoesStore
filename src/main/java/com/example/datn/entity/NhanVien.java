package com.example.datn.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name="nhan_vien")
public class NhanVien implements Serializable {

    private static final long serialVersionUID = 5313493413859894403L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nhan_vien")
    private long id;

    @Column(name = "ho", length = 50, nullable = false)
    private String ho;

    @Column(name = "ten", length = 50, nullable = false)
    private String ten;

    @Column(name = "gioi_tinh", nullable = false)
    private int gioiTinh;

    @Column(name = "ngay_sinh", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "email", length = 120, nullable = false)
    private String email;

    @Column(name = "sdt", length = 20, nullable = false)
    private String sdt;

    @Column(name = "encrypted_password", length = 255, nullable = false)
    private String encryptedPassword;

//    @Lob
//    @Column(name = "image")
//    private Blob image;

    @Column(name = "ma_nhan_vien", length = 255, nullable = false)
    private String ma;

    @Column(name = "trang_thai", columnDefinition = " int default 0")
    private int trangThai;




}
