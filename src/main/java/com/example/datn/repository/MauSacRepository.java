package com.example.datn.repository;

import com.example.datn.dto.MauSacDto;
import com.example.datn.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, Integer> {
    MauSac findByMa(String ma);

    @Transactional
    @Modifying
    @Query(value = "update MauSac m set " +
            "m.ma = :#{#mauSacDto.ma}," +
            "m.ten = :#{#mauSacDto.ten}," +
            "m.moTa = :#{#mauSacDto.moTa}," +
            "m.trangThai = :#{#mauSacDto.trangThai} where m.id = :id")
    void update(MauSacDto mauSacDto, int id);

    Page<MauSac> findByTen(String name, Pageable pageable);
}
