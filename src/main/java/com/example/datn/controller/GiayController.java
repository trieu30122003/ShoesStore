package com.example.datn.controller;

import com.example.datn.dto.GiayDto;
import com.example.datn.entity.Giay;
import com.example.datn.service.GiayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/giay")
public class GiayController {
    @Autowired
    GiayService giayService;

    @GetMapping
    public ResponseEntity<Page<Giay>> getAll(@RequestParam(value = "page", defaultValue = "0")int page,
                                             @RequestParam(value = "size", defaultValue = "5") int size){
        return ResponseEntity.ok(giayService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public GiayDto getOne(@PathVariable int id){
        return giayService.getOne(id);
    }

    @PostMapping
    public ResponseEntity<GiayDto> create(@RequestBody GiayDto giayDto){
        return ResponseEntity.ok(giayService.save(giayDto));
    }
}
