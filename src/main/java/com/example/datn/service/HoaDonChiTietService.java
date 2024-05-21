package com.example.datn.service;

import com.example.datn.dto.HoaDonChiTietDto;

import java.util.List;

public interface HoaDonChiTietService {
    HoaDonChiTietDto save(HoaDonChiTietDto hoaDonChiTietDto);
    List<HoaDonChiTietDto> getAllByHoaDon(int id);
    HoaDonChiTietDto update(HoaDonChiTietDto hoaDonChiTietDto, int id);
}
