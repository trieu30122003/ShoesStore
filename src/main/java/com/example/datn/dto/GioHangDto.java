package com.example.datn.dto;

import com.example.datn.entity.BienTheGiay;
import com.example.datn.entity.KhachHang;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class GioHangDto {
    private long id;
    private BienTheGiay bienTheGiay;
    private KhachHang khachHang;
    private int trangThai;
}
