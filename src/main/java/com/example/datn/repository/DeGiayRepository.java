package com.example.datn.repository;

import com.example.datn.dto.DeGiayDto;
import com.example.datn.entity.DeGiay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DeGiayRepository extends JpaRepository<DeGiay,Integer> {
    DeGiay findByMa(String ma);

    Page<DeGiay> findByTen(String name, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update DeGiay d set " +
            "d.ten = :#{#deGiayDto.ten}," +
            "d.ma = :#{#deGiayDto.ma}," +
            "d.moTa = :#{#deGiayDto.moTa}," +
            "d.chatLieu = :#{#deGiayDto.chatLieu}," +
            "d.mauSac = :#{#deGiayDto.mauSac}," +
            "d.trangThai = :#{#deGiayDto.trangThai} where d.id = :id")
    void update(DeGiayDto deGiayDto, int id);
}
