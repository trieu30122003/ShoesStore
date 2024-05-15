package com.example.datn.repository;

import com.example.datn.dto.KichThuocDto;
import com.example.datn.entity.KichThuoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface KichThuocRepository extends JpaRepository<KichThuoc, Integer> {
    KichThuoc findByMa(String ma);

    @Transactional
    @Modifying
    @Query(value = "update KichThuoc k set " +
            "k.ma = :#{#kichThuocDto.ma}," +
            "k.ten = :#{#kichThuocDto.ten}," +
            "k.chieuDai = :#{#kichThuocDto.chieuDai}," +
            "k.chieuRong = :#{#kichThuocDto.chieuRong}," +
            "k.moTa = :#{#kichThuocDto.moTa}," +
            "k.trangThai = :#{#kichThuocDto.trangThai} where k.id = :id")
    void update(KichThuocDto kichThuocDto, int id);

    Page<KichThuoc> findByTen(String name, Pageable pageable);

}
