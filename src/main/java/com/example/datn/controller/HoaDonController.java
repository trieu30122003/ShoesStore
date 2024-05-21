package com.example.datn.controller;

import com.example.datn.dto.HoaDonDto;
import com.example.datn.entity.HoaDon;
import com.example.datn.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hoa-don")
public class HoaDonController {
    @Autowired
    HoaDonService hoaDonService;

    @GetMapping
    public ResponseEntity<Page<HoaDon>> getAll(@RequestParam(value = "page",defaultValue = "0")int page,
                                               @RequestParam(value = "size", defaultValue = "5")int size){
        return ResponseEntity.ok(hoaDonService.getAll(page, size));
    }

    @PostMapping
    public ResponseEntity<HoaDonDto> save(@RequestBody HoaDonDto hoaDonDto){
        return ResponseEntity.ok(hoaDonService.save(hoaDonDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HoaDonDto> update(@PathVariable int id, @RequestBody HoaDonDto hoaDonDto){
        return ResponseEntity.ok(hoaDonService.update(hoaDonDto, id));
    }

    @GetMapping("/cho-xac-nhan/{id}")
    public HoaDonDto choXacNhan(@PathVariable int id){
        return hoaDonService.choXacNhan(id);
    }

    @GetMapping("/xac-nhan/{id}")
    public HoaDonDto xacNhan(@PathVariable int id, @RequestParam(value = "soLuong")int soLuong){
        return hoaDonService.xacNhan(id, soLuong);
    }

    @GetMapping("/dang-giao/{id}")
    public HoaDonDto dangGiao(@PathVariable int id){
        return hoaDonService.dangGiao(id);
    }

    @GetMapping("/da-giao/{id}")
    public HoaDonDto daGiao(@PathVariable int id){
        return hoaDonService.daGiao(id);
    }

    @GetMapping("/da-huy/{id}")
    public HoaDonDto daHuy(@PathVariable int id){
        return hoaDonService.daHuy(id);
    }

    @GetMapping("/da-nhan/{id}")
    public HoaDonDto daNhan(@PathVariable int id){
        return hoaDonService.daNhan(id);
    }

}