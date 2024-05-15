package com.example.datn.repository;

import com.example.datn.dto.MauSacDto;
import com.example.datn.dto.MuiGiayDto;
import com.example.datn.entity.MauSac;
import com.example.datn.entity.MuiGiay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MuiGiayRepository extends JpaRepository<MuiGiay, Integer> {
    MuiGiay findByMa(String ma);

    @Transactional
    @Modifying
    @Query(value = "update MuiGiay m set " +
            "m.ma = :#{#muiGiayDto.ma}," +
            "m.ten = :#{#muiGiayDto.ten}," +
            "m.moTa = :#{#muiGiayDto.moTa}," +
            "m.trangThai = :#{#muiGiayDto.trangThai} where m.id = :id")
    void update(MuiGiayDto muiGiayDto, int id);

    Page<MuiGiay> findByTen(String name, Pageable pageable);
}
