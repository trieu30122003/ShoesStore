package com.example.datn.repository;

import com.example.datn.dto.GiayDto;
import com.example.datn.entity.Giay;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GiayRepository extends JpaRepository<Giay,Integer> {
    Giay findByMa(String ma);

    int findBySoLuong(int id);

    int findByTrangThai(int id);


    @Transactional
    @Modifying
    @Query(value = "update Giay g set " +
            "g.ma = :#{#giayDto.ma}," +
            "g.ten = :#{#giayDto.ten}," +
            "g.moTa = :#{#giayDto.moTa}," +
            "g.soLuong = :#{#giayDto.soLuong}," +
            "g.trangThai = :#{#giayDto.trangThai}," +
            "g.ngaySanXuat = :#{#giayDto.ngaySanXuat}," +
            "g.chatLieu = :#{#giayDto.chatLieu}," +
            "g.coGiay = :#{#giayDto.coGiay}," +
            "g.dayGiay = :#{#giayDto.dayGiay}," +
            "g.deGiay = :#{#giayDto.deGiay}," +
            "g.lotGiay = :#{#giayDto.lotGiay}," +
            "g.muiGiay = :#{#giayDto.muiGiay}," +
            "g.thuongHieu = :#{#giayDto.thuongHieu} where g.id = :id"
    )
    void update(GiayDto giayDto, int id);


    @Transactional
    @Modifying
    @Query(value = "update Giay g set g.soLuong = :soLuong")
    void updateSoLuong(int soLuong);

//    @Query(value = "select g from Giay g where g.thuongHieu.id = :id")
//    Page<Giay> findAllByThuongHieu(int id);
}
