package com.example.datn.service.impl;

import com.example.datn.entity.Giay;
import com.example.datn.repository.GiayRepository;
import com.example.datn.repository.HoaDonChiTietRepository;
import com.example.datn.repository.HoaDonRepository;
import com.example.datn.service.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Service
public class ThongKeServiceImpl implements ThongKeService {

    @Autowired
    HoaDonRepository hoaDonRepository;

    @Autowired
    GiayRepository giayRepository;

    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository;

    @Override
    public int soLuongKhachHangMua(Date tuNgay, Date denNgay) {
        return hoaDonRepository.soLuongKhachHang(tuNgay, denNgay);
    }

    @Override
    public List<Giay> topGiay(Date tuNgay, Date denNgay) {
        return giayRepository.topGiay(tuNgay, denNgay);
    }

    @Override
    public int tongSoLuongDaMua(Date tuNgay, Date denNgay) {
        return hoaDonChiTietRepository.sumSoLuong(tuNgay, denNgay);
    }

    @Override
    public BigDecimal tongDoanhThu(Date tuNgay, Date denNgay) {
        return hoaDonChiTietRepository.sumGia(tuNgay, denNgay);
    }
}
