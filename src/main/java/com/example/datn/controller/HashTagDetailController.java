package com.example.datn.controller;

import com.example.datn.dto.HashTagDetailDto;
import com.example.datn.entity.HashTagChiTiet;
import com.example.datn.service.BaseService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hashtag-detail")
public class HashTagDetailController {
    @Autowired
    BaseService<HashTagDetailDto, HashTagChiTiet> baseService;

    @GetMapping
    @Operation(summary = "lấy ra tất cả")
    public ResponseEntity<Page<HashTagChiTiet>> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                       @RequestParam(value = "size", defaultValue = "5") int size){
        return ResponseEntity.ok(baseService.getAll(page, size));
    }

    @GetMapping("/{id}")
    @Operation(summary = "lấy ra 1 hashtagdetail")
    public HashTagDetailDto getOne(@PathVariable int id){
        return baseService.getOne(id);
    }

    @PostMapping
    @Operation(summary = "thêm")
    public ResponseEntity<HashTagDetailDto> create(@Valid @RequestBody HashTagDetailDto hashTagDetailDto){
        return ResponseEntity.ok(baseService.save(hashTagDetailDto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "cập nhật")
    public ResponseEntity<HashTagDetailDto> update(@Valid @RequestBody HashTagDetailDto hashTagDetailDto, @PathVariable int id){
        return ResponseEntity.ok(baseService.update(hashTagDetailDto, id));
    }
}
