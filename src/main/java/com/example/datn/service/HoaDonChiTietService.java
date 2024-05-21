package com.example.datn.service;

import com.example.datn.dto.HoaDonChiTietDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HoaDonChiTietService {
    ResponseEntity save(HoaDonChiTietDto hoaDonChiTietDto);
    List<HoaDonChiTietDto> getAllByHoaDon(int id);
    HoaDonChiTietDto update(HoaDonChiTietDto hoaDonChiTietDto, int id);
}
