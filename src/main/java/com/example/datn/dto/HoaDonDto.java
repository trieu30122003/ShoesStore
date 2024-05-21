package com.example.datn.dto;

import com.example.datn.entity.KhachHang;
import com.example.datn.entity.NhanVien;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter

public class HoaDonDto {
    private int id;
    private String ma;
    private KhachHang khachHang;
    private NhanVien nhanVien;
    private Timestamp ngayThanhToan;
    private String diaChi;
    private String sdt;
    private BigDecimal phiVanChuyen;
    private String moTa;
    private Integer kieuThanhToan;
    private BigDecimal paymentAmount;
    private int trangThai;

}
