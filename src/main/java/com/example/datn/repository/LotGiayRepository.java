package com.example.datn.repository;

import com.example.datn.dto.LotGiayDto;
import com.example.datn.dto.MuiGiayDto;
import com.example.datn.entity.LotGiay;
import com.example.datn.entity.MuiGiay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LotGiayRepository extends JpaRepository<LotGiay, Integer> {
    LotGiay findByMa(String ma);

    @Transactional
    @Modifying
    @Query(value = "update LotGiay m set " +
            "m.ma = :#{#lotGiayDto.ma}," +
            "m.ten = :#{#lotGiayDto.ten}," +
            "m.moTa = :#{#lotGiayDto.moTa}," +
            "m.trangThai = :#{#lotGiayDto.trangThai} where m.id = :id")
    void update(LotGiayDto lotGiayDto, int id);

    Page<LotGiay> findByTen(String name, Pageable pageable);
}
