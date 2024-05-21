package com.example.datn.dto;

import com.example.datn.entity.BienTheGiay;
import com.example.datn.entity.Giay;
import com.example.datn.entity.HoaDon;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

public class HoaDonChiTietDto {
    private int id;
    private HoaDon hoaDon;
    private BienTheGiay bienTheGiay;
    private int soLuong;
    private BigDecimal giaGoc;
    private BigDecimal gia;
    private int trangThai;
}
