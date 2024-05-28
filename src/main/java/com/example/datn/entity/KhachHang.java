package com.example.datn.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="khach_hang")
public class KhachHang implements Serializable {

//    private static final long serialVersionUID = 5313493413859894403L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_khach_hang")
    private long id;
//
//    @Column(name = "email_verification_status")
//    private boolean emailVerificationStatus;

    @Column(name = "ho", length = 50)
    private String ho;

    @Column(name = "ten", length = 50)
    private String ten;

    @Column(name = "email", length = 120)
    private String email;

//    @Column(name = "email_verification_token", length = 255)
//    private String emailVerificationToken;
//
//    @Column(name = "encrypted_password", length = 255)
//    private String encryptedPassword;

    @Column(name = "gioi_tinh")
    private int gioiTinh;

    @Column(name = "ngay_sinh")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "sdt", length = 20)
    private String sdt;

    @Column(name = "ma_kh", length = 255)
    private String ma;

    @Column(name = "trang_thai", columnDefinition = " int default 0")
    private int trangThai;

}
