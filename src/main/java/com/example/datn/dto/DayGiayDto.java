package com.example.datn.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter

public class DayGiayDto {
    private int id;
    @NotBlank(message = "Ma is not mandatory")
    private String ma;
    @NotBlank(message = "ten is not mandatory")
    private String ten;
    @NotBlank(message = "MauSac is not mandatory")
    private String mauSac;
    private String moTa;
    private int trangThai;
    @NotBlank(message = "ngayTao is not mandatory")
    private Date ngayTao;
}
