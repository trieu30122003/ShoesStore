package com.example.datn.repository;

import com.example.datn.dto.DayGiayDto;
import com.example.datn.dto.DeGiayDto;
import com.example.datn.entity.DayGiay;
import com.example.datn.entity.DeGiay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DayGiayRepository extends JpaRepository<DayGiay, Integer> {
    DayGiay findByMa(String ma);

    Page<DayGiay> findByTen(String name, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update DayGiay d set " +
            "d.ten = :#{#dayGiayDto.ten}," +
            "d.ma = :#{#dayGiayDto.ma}," +
            "d.moTa = :#{#dayGiayDto.moTa}," +
            "d.mauSac = :#{#dayGiayDto.mauSac}," +
            "d.ngayTao = :#{#dayGiayDto.ngayTao}," +
            "d.trangThai = :#{#dayGiayDto.trangThai} where d.id = :id")
    void update(DayGiayDto dayGiayDto, int id);
}
