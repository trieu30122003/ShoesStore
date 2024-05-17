package com.example.datn.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DeGiayDto {
    private int id;
    @NotBlank(message = "Ma is not mandatory")
    private String ma;
    @NotBlank(message = "ten is not mandatory")
    private String ten;
    @NotBlank(message = "MauSac is not mandatory")
    private String mauSac;
    @NotBlank(message = "ChatLieu is not mandatory")
    private String chatLieu;
    private String moTa;
    private int trangThai;
}
