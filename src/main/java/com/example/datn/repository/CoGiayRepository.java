package com.example.datn.repository;

import com.example.datn.dto.ChatLieuDto;
import com.example.datn.dto.CoGiayDto;
import com.example.datn.entity.ChatLieu;
import com.example.datn.entity.CoGiay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CoGiayRepository extends JpaRepository<CoGiay, Integer> {
    CoGiay findByMa(String ma);

    Page<CoGiay> findByTen(String name, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update CoGiay c set " +
            "c.ma = :#{#coGiayDto.ma}," +
            "c.ten = :#{#coGiayDto.ten}," +
            "c.moTa = :#{#coGiayDto.moTa}," +
            "c.trangThai = :#{#coGiayDto.trangThai} where c.id = :id")
    void update(CoGiayDto coGiayDto, int id);
}
