package com.example.datn.service;

import com.example.datn.dto.TopGiay;
import com.example.datn.entity.Giay;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

public interface ThongKeService {
    int soLuongKhachHangMua(Date tuNgay, Date denNgay);
    List<Giay> topGiay(Date tuNgay, Date denNgay);
    int tongSoLuongDaMua(Date tuNgay, Date denNgay);
    BigDecimal tongDoanhThu(Date tuNgay, Date denNgay);
}
