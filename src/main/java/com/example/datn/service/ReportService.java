package com.example.datn.service;

import com.example.datn.dto.BienTheGiayDto;
import com.example.datn.dto.HoaDonChiTietDto;
import com.example.datn.entity.BienTheGiay;
import com.example.datn.entity.HoaDonChiTiet;

import java.sql.Date;
import java.util.List;

public interface ReportService {
    int countProductIn(Date start, Date end);
    List<BienTheGiayDto> listProductIn(Date start, Date end);

    int countProductOut(Date start, Date end);
    List<HoaDonChiTietDto> listProductOut(Date start, Date end);
}
