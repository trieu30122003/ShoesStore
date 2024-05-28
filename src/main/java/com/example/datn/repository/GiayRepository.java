package com.example.datn.repository;

import com.example.datn.dto.GiayDto;
import com.example.datn.dto.TopGiay;
import com.example.datn.entity.Giay;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Repository
public interface GiayRepository extends JpaRepository<Giay,Integer> {
    Giay findByMa(String ma);

    @Query(value = "select g.soLuong from Giay g where g.id = :id")
    int findBySoLuong(int id);

    @Query(value = "select g.trangThai from Giay g where g.id = :id")
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
    @Query(value = "update Giay g set g.soLuong = :soLuong where g.id = :id")
    void updateSoLuong(int soLuong, int id);

//    @Query(value = "select g from Giay g where g.thuongHieu.id = :id")
//    Page<Giay> findAllByThuongHieu(int id);

    @Query(value = "SELECT giay.*\n" +
            "FROM giay\n" +
            "JOIN bien_the_giay ON giay.id_giay = bien_the_giay.id_giay\n" +
            "JOIN hoa_don_chi_tiet ON bien_the_giay.id_bien_the_giay = hoa_don_chi_tiet.id_bien_the_giay\n" +
            "JOIN hoa_don ON hoa_don.id_hoa_don = hoa_don_chi_tiet.id_hoa_don\n" +
            "WHERE hoa_don.ngay_thanh_toan BETWEEN :tuNgay AND :denNgay\n" +
            "GROUP BY giay.id_giay\n" +
            "ORDER BY SUM(hoa_don_chi_tiet.so_luong) DESC\n" +
            "LIMIT 10;\n", nativeQuery = true)
    List<Giay> topGiay(Date tuNgay, Date denNgay);
}
