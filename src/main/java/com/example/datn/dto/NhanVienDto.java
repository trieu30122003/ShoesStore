package com.example.datn.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter

public class NhanVienDto {
    private int id;
    private String ma;
    private String ho;
    private String ten;
    private int gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String email;
    private String sdt;
    private String encryptedPassword;
    private int trangThai;
}
