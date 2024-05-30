package com.example.datn.repository;

import com.example.datn.dto.HoaDonDto;
import com.example.datn.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update HoaDon h set h.trangThai = 1 where h.id = :id")
    void choXacNhan(int id);

    @Transactional
    @Modifying
    @Query(value = "update HoaDon h set h.trangThai = 2 where h.id = :id")
    void xacNhan(int id);

    @Transactional
    @Modifying
    @Query(value = "update HoaDon h set h.trangThai = 3 where h.id = :id")
    void dangGiao(int id);

    @Transactional
    @Modifying
    @Query(value = "update HoaDon h set h.trangThai = 4 where h.id = :id")
    void daGiao(int id);

    @Transactional
    @Modifying
    @Query(value = "update HoaDon h set h.trangThai = 5 where h.id = :id")
    void daNhan(int id);

    @Transactional
    @Modifying
    @Query(value = "update HoaDon h set h.trangThai = 6 where h.id = :id")
    void daHuy(int id);

    @Transactional
    @Modifying
    @Query(value = "update HoaDon h set " +
            "h.ma = :#{#hoaDonDto.ma}," +
            "h.sdt = :#{#hoaDonDto.sdt}," +
            "h.moTa = :#{#hoaDonDto.moTa}," +
            "h.diaChi = :#{#hoaDonDto.diaChi}," +
            "h.khachHang = :#{#hoaDonDto.khachHang}," +
            "h.kieuThanhToan = :#{#hoaDonDto.kieuThanhToan}," +
            "h.ngayGiao = :#{#hoaDonDto.ngayGiao}," +
            "h.ngayThanhToan = :#{#hoaDonDto.ngayThanhToan}," +
            "h.nhanVien = :#{#hoaDonDto.nhanVien}," +
            "h.paymentAmount = :#{#hoaDonDto.paymentAmount} where h.trangThai = 0 or h.trangThai = 1 and h.id = :id")
    void update(HoaDonDto hoaDonDto, int id);

    @Query(value = "select COUNT(distinct hd.khachHang) from HoaDon hd where hd.ngayThanhToan between :tuNgay and :denNgay")
    int soLuongKhachHang(Date tuNgay, Date denNgay);
}