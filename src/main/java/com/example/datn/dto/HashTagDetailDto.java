package com.example.datn.dto;

import com.example.datn.entity.Giay;
import com.example.datn.entity.HashTag;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter

public class HashTagDetailDto {
    private int id;
    private HashTag hashTag;
    private Giay giay;
    private Date ngayTao;

}
