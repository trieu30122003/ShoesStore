package com.example.datn.dto;

import com.example.datn.entity.Giay;
import com.example.datn.entity.KichThuoc;
import com.example.datn.entity.MauSac;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

public class BienTheGiayDto {
    private int id;
    private String ma;
    private BigDecimal giaBan;
    private BigDecimal giaNhap;
    private String hinhAnh;
    private int soLuong;
    private int trangThai;
    private KichThuoc kichThuoc;
    private MauSac mauSac;
    private Giay giay;
}
