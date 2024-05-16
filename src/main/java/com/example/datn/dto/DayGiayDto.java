package com.example.datn.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter

public class DayGiayDto {
    private int id;
    private String ma;
    private String ten;
    private String mauSac;
    private String moTa;
    private int trangThai;
    private Date ngayTao;
}
