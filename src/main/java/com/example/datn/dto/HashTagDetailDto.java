package com.example.datn.dto;

import com.example.datn.entity.Giay;
import com.example.datn.entity.HashTag;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter

public class HashTagDetailDto {
    private int id;
    @NotBlank(message = "HashTag is not mandatory")
    private HashTag hashTag;
    private Giay giay;
//    @NotBlank(message = "NgayTao is not mandatory")
    private Date ngayTao;

}
