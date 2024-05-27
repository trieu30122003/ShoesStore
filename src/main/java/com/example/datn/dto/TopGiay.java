package com.example.datn.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter

public class TopGiay {
    private int id;
    private String ma;
    private String moTa;
    private Date ngaySanXuat;
    private int soLuong;
    private String ten;
    private int soLuongBanRa;
}
