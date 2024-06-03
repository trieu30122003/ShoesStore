package com.example.datn.service;

import com.example.datn.dto.HoaDonDto;
import com.example.datn.entity.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface HoaDonService {
    Page<HoaDon> getAll(int page, int size);

    HoaDonDto update(HoaDonDto hoaDonDto, int id);

    ResponseEntity save(HoaDonDto hoaDonDto, int maDH, String otp);

    HoaDonDto choXacNhan(int id);

    HoaDonDto xacNhan(int id);

    HoaDonDto dangGiao(int id);

    HoaDonDto daGiao(int id);

    HoaDonDto daHuy(int id);

    HoaDonDto daNhan(int id);
}
