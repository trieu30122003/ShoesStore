package com.example.datn.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter

public class NhanVienDto {
    private int id;
    @NotBlank(message = "Ma is not mandatory")
    private String ma;
    @NotBlank(message = "ho is not mandatory")
    private String ho;
    @NotBlank(message = "ten is not mandatory")
    private String ten;
    @NotBlank(message = "gioiTinh is not mandatory")
    private int gioiTinh;
    @NotBlank(message = "ngaySinh is not mandatory")
    private Date ngaySinh;
    @NotBlank(message = "diaChi is not mandatory")
    private String diaChi;
    @NotBlank(message = "email is not mandatory")
    private String email;
    @NotBlank(message = "sdt is not mandatory")
    private String sdt;
    private String encryptedPassword;
    private int trangThai;
}
