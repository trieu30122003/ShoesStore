package com.example.datn.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter

public class KhachHangDto {
    private int id;
    private String ma;
    private String ho;
    private String ten;
    private String email;
    private int gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String sdt;
    private int trangThai;
}
