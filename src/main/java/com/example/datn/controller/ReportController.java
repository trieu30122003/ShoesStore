package com.example.datn.controller;

import com.example.datn.dto.BienTheGiayDto;
import com.example.datn.dto.HoaDonChiTietDto;
import com.example.datn.service.ReportService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/report")
public class ReportController {
    @Autowired
    ReportService reportService;

    @GetMapping("/product-in")
    @Operation(summary = "số lượng giày được thêm vào trong khoảng tg")
    public int countProsuctIn(@RequestParam(value = "startDate")Date start,
                              @RequestParam(value = "endDate") Date end){
        return reportService.countProductIn(start, end);
    }

    @GetMapping("/list-product-in")
    @Operation(summary = "List giày được thêm vào trong khoảng tg")
    public ResponseEntity<List<BienTheGiayDto>> listProductIn(@RequestParam(value = "startDate")Date start,
                                                             @RequestParam(value = "endDate") Date end){
        return ResponseEntity.ok(reportService.listProductIn(start, end));
    }

    @GetMapping("/product-out")
    @Operation(summary = "Tổng số lượng giày đã được bán ra")
    public int sumProductOut(@RequestParam(value = "startDate")Date start,
                             @RequestParam(value = "endDate") Date end){
        return reportService.countProductOut(start, end);
    }

    @GetMapping("/list-product-out")
    @Operation(summary = "List giày được bán ra")
    public ResponseEntity<List<HoaDonChiTietDto>> listProductOut(@RequestParam(value = "startDate")Date start,
                                                                 @RequestParam(value = "endDate") Date end){
        return ResponseEntity.ok(reportService.listProductOut(start, end));
    }
}
