package com.example.datn.filter;

import com.example.datn.entity.Giay;
import com.example.datn.entity.KichThuoc;
import com.example.datn.entity.MauSac;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class FilterBienThe {
    private BigDecimal giaBanMin;
    private BigDecimal giaBanMax;
    private int trangThai;
    private KichThuoc kichThuocMin;
    private KichThuoc kichThuocMax;
    private MauSac mauSac;
    private Giay giay;

}
