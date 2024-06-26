package com.example.datn.service;

import com.example.datn.dto.KhachHangDto;
import com.example.datn.entity.KhachHang;
import com.example.datn.filter.FilterKhachHang;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface KhachHangService {
    Page<KhachHang> getAll(int page, int size);

    KhachHangDto getOne(int id);

    ResponseEntity save(KhachHangDto khachHangDto);

    void delete(int id);

    ResponseEntity update(KhachHangDto khachHangDto, int id);

    Page<KhachHang>search(String name, int page, int size);

    Page<KhachHang> filterKhachHang(FilterKhachHang filterKhachHang, int page, int size);
}
