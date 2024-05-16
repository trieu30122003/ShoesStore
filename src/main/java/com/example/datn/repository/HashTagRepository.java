package com.example.datn.repository;

import com.example.datn.dto.CoGiayDto;
import com.example.datn.dto.HashTagDto;
import com.example.datn.entity.CoGiay;
import com.example.datn.entity.HashTag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface HashTagRepository extends JpaRepository<HashTag, Integer> {
    HashTag findByMa(String ma);

    Page<HashTag> findByTen(String name, Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "update HashTag c set " +
            "c.ma = :#{#hashTagDto.ma}," +
            "c.ten = :#{#hashTagDto.ten}," +
            "c.moTa = :#{#hashTagDto.moTa}," +
            "c.trangThai = :#{#hashTagDto.trangThai} where c.id = :id")
    void update(HashTagDto hashTagDto, int id);
}
