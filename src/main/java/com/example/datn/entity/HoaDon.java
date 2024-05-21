package com.example.datn.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="hoa_don")
public class HoaDon implements Serializable {

//    private static final long serialVersionUID = 5313493413859894403L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hoa_don")
    private long id;

    @Column(name = "ma_hoa_don")
    private String ma;

    @ManyToOne
    @JoinColumn(name = "id_khach_hang")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "id_nhan_vien")
    private NhanVien nhanVien;

//    @Column(name = "create_date")
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreationTimestamp
//    private Timestamp createDate;
//
//    @Column(name = "update_date")
//    @Temporal(TemporalType.TIMESTAMP)
//    @UpdateTimestamp
//    private Timestamp updateDate;

    @Column(name = "ngay_thanh_toan")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp ngayThanhToan;

    @Column(name = "ngay_giao")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp ngayGiao;

    @Column(name = "dia_chi", length = 255, nullable = false)
    private String diaChi;

//    @Pattern(regexp = "^(0|\\+\\d{2})\\d{9}$")
    @Column(name = "sdt", length = 20)
    private String sdt;

    @Column(name = "phi_van_chuyen", precision = 10, scale = 0)
    private BigDecimal phiVanChuyen;

    @Column(name = "mo_ta", length = 255)
    private String moTa;

    @Column(name = "kieu_thanh_toan")
    private Integer kieuThanhToan;

    @Column(name = "payment_amount")
    private BigDecimal paymentAmount;
//
//    @Column(name = "shipe_fee")
//    private BigDecimal shipeFee;


    @Column(name = "trang_thai", columnDefinition = " int default 0")
    private int trangThai;

}
