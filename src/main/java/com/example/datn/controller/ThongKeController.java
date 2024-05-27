package com.example.datn.controller;

import com.example.datn.entity.Giay;
import com.example.datn.service.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/thong-ke")
public class ThongKeController {
    @Autowired
    ThongKeService thongKeService;

    @GetMapping("/so-khach-mua")
    public int soLuongKhachMua(@RequestParam(value = "tuNgay")Date tuNgay,
                               @RequestParam(value = "denNgay") Date denNgay){
        return thongKeService.soLuongKhachHangMua(tuNgay, denNgay);
    }

    @GetMapping("/top-ban-chay")
    public List<Giay> top(@RequestParam(value = "tuNgay")Date tuNgay,
                          @RequestParam(value = "denNgay") Date denNgay){
        return thongKeService.topGiay(tuNgay, denNgay);
    }

    @GetMapping("/tong-san-pham-da-mua")
    public int tongsp(@RequestParam(value = "tuNgay")Date tuNgay,
                      @RequestParam(value = "denNgay") Date denNgay){
        return thongKeService.tongSoLuongDaMua(tuNgay, denNgay);
    }

    @GetMapping("/tong-doanh-thu")
    public BigDecimal tongDoanhThu(@RequestParam(value = "tuNgay")Date tuNgay,
                                   @RequestParam(value = "denNgay") Date denNgay){
        return thongKeService.tongDoanhThu(tuNgay, denNgay);
    }
}
