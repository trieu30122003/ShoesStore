package com.example.datn.dto;

import com.example.datn.entity.Giay;
import com.example.datn.entity.KichThuoc;
import com.example.datn.entity.MauSac;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

public class BienTheGiayDto {
    private int id;
    @NotBlank(message = "Ma is not mandatory")
    private String ma;

//    @NotBlank(message = "giaBan is not mandatory")
    private BigDecimal giaBan;

//    @NotBlank(message = "giaNhap is not mandatory")
    private BigDecimal giaNhap;

    @NotBlank(message = "hinhAnh is not mandatory")
    private String hinhAnh;

    private int trangThai;

    private KichThuoc kichThuoc;

    private MauSac mauSac;

//    @NotBlank(message = "Giay is not mandatory")
    private Giay giay;

}
