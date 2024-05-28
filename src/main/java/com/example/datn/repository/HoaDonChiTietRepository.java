package com.example.datn.repository;

import com.example.datn.entity.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Integer> {

    HoaDonChiTiet findByHoaDon_Id(int id);

    @Query(value = "select hdct from HoaDonChiTiet hdct where hdct.hoaDon.id = :id")
    List<HoaDonChiTiet> getAll(int id);

    @Query(value = "select sum(hdct.soLuong) from HoaDonChiTiet hdct where hdct.hoaDon.ngayThanhToan between :tuNgay and :denNgay")
    int sumSoLuong(Date tuNgay, Date denNgay);

    @Query(value = "select sum(hdct.gia) from HoaDonChiTiet hdct where hdct.hoaDon.ngayThanhToan between :tuNgay and :denNgay")
    BigDecimal sumGia(Date tuNgay, Date denNgay);


}
