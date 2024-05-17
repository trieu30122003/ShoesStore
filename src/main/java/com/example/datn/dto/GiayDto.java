package com.example.datn.dto;

import com.example.datn.entity.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter

public class GiayDto {
    private int id;
    @NotBlank(message = "Ma is not mandatory")
    private String ma;
    @NotBlank(message = "ten is not mandatory")
    private String ten;
    @NotBlank(message = "ngaySanXuat is not mandatory")
    private Date ngaySanXuat;
    @NotBlank(message = "ChatLieu is not mandatory")
    private ChatLieu chatLieu;
    @NotBlank(message = "CoGiay is not mandatory")
    private CoGiay coGiay;
    @NotBlank(message = "DeGiay is not mandatory")
    private DeGiay deGiay;
    @NotBlank(message = "MuiGiay is not mandatory")
    private MuiGiay muiGiay;
    @NotBlank(message = "ThuongHieu is not mandatory")
    private ThuongHieu thuongHieu;
    private String moTa;
    private int trangThai;
}
