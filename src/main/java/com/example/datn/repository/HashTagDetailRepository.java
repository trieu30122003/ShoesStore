package com.example.datn.repository;

import com.example.datn.dto.HashTagDetailDto;
import com.example.datn.entity.HashTagChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface HashTagDetailRepository extends JpaRepository<HashTagChiTiet, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update HashTagChiTiet h set " +
            "h.giay = :#{#hashTagDetailDto.giay}," +
            "h.hashTag = :#{#hashTagDetailDto.hashTag}," +
            "h.ngayTao = :#{#hashTagDetailDto.ngayTao} where h.id = :id")
    void update(HashTagDetailDto hashTagDetailDto, int id);
}
