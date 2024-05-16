package com.example.datn.repository;

import com.example.datn.dto.BienTheGiayDto;
import com.example.datn.dto.ChatLieuDto;
import com.example.datn.entity.BienTheGiay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BienTheGiayRepository extends JpaRepository<BienTheGiay, Integer> {
    BienTheGiay findByMa(String ma);

    Page<BienTheGiay> findByGiay_Ten(String name, Pageable pageable);
    @Transactional
    @Modifying
    @Query(value = "update BienTheGiay b set " +
            "b.ma = :#{#bienTheGiayDto.ma}," +
            "b.giaBan = :#{#bienTheGiayDto.giaBan}," +
            "b.giaNhap = :#{#bienTheGiayDto.giaNhap}," +
            "b.hinhAnh = :#{#bienTheGiayDto.hinhAnh}," +
            "b.soLuong = :#{#bienTheGiayDto.soLuong}," +
            "b.kichThuoc = :#{#bienTheGiayDto.kichThuoc}," +
            "b.mauSac = :#{#bienTheGiayDto.mauSac}," +
            "b.giay = :#{#bienTheGiayDto.giay}," +
            "b.trangThai = :#{#bienTheGiayDto.trangThai} where b.id = :id")
    void update(BienTheGiayDto bienTheGiayDto, int id);
}
