package com.example.datn.service;

import com.example.datn.dto.HoaDonDto;
import com.example.datn.entity.HoaDon;
import org.springframework.data.domain.Page;

public interface HoaDonService {
    Page<HoaDon> getAll(int page, int size);

    HoaDonDto update(HoaDonDto hoaDonDto, int id);

    HoaDonDto save(HoaDonDto hoaDonDto);



    HoaDonDto choXacNhan(int id);

    HoaDonDto xacNhan(int id);

    HoaDonDto dangGiao(int id);

    HoaDonDto daGiao(int id);

    HoaDonDto daHuy(int id);

    HoaDonDto daNhan(int id);
}
