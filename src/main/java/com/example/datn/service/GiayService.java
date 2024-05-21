package com.example.datn.service;

import com.example.datn.dto.GiayDto;
import com.example.datn.entity.Giay;
import com.example.datn.filter.FilterGiay;
import com.example.datn.filter.FilterKhachHang;
import org.springframework.data.domain.Page;

public interface GiayService {
    Page<Giay> getAll(int page, int size);

    GiayDto getOne(int id);

    GiayDto save(GiayDto giayDto);

    void delete(int id);

    GiayDto update(GiayDto giayDto, int id);

    Page<Giay>search(String name, int page, int size);

    Page<Giay> filterGiay(FilterGiay filterGiay, int page, int size);
}
