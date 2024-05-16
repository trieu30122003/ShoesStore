package com.example.datn.repository;

import com.example.datn.dto.ThuongHieuDto;
import com.example.datn.entity.ThuongHieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ThuongHieuRepository extends JpaRepository<ThuongHieu, Integer> {
    ThuongHieu findByMa(String ma);

    @Transactional
    @Modifying
    @Query(value = "update ThuongHieu m set " +
            "m.ma = :#{#thuongHieuDto.ma}," +
            "m.ten = :#{#thuongHieuDto.ten}," +
            "m.moTa = :#{#thuongHieuDto.moTa}," +
            "m.trangThai = :#{#thuongHieuDto.trangThai} where m.id = :id")
    void update(ThuongHieuDto thuongHieuDto, int id);

    Page<ThuongHieu> findByTen(String name, Pageable pageable);
}
