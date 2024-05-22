package com.example.datn.filter;

import com.example.datn.entity.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter

public class FilterGiay {
    private Date tuNgay;
    private Date denNgay;
    private ChatLieu chatLieu;
    private CoGiay coGiay;
    private DeGiay deGiay;
    private MuiGiay muiGiay;
    private ThuongHieu thuongHieu;
    private int trangThai;
}
