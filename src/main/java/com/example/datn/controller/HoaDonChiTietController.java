package com.example.datn.controller;

import com.example.datn.dto.HoaDonChiTietDto;
import com.example.datn.service.HoaDonChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hdct")
public class HoaDonChiTietController {
    @Autowired
    HoaDonChiTietService hoaDonChiTietService;

    @GetMapping("/{id}")
    public ResponseEntity<List<HoaDonChiTietDto>> getAll(@PathVariable int id){
        return ResponseEntity.ok(hoaDonChiTietService.getAllByHoaDon(id));
    }

    @PostMapping
    public ResponseEntity<HoaDonChiTietDto> save(HoaDonChiTietDto hoaDonChiTietDto){
        return ResponseEntity.ok(hoaDonChiTietService.save(hoaDonChiTietDto));
    }
}
