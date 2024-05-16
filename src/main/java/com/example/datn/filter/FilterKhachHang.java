package com.example.datn.filter;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter

public class FilterKhachHang {

    private int gioiTinh;
    private Date tuNgay;
    private Date denNgay;
    private int trangThai;

}
