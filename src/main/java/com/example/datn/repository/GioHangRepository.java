package com.example.datn.repository;

import com.example.datn.entity.GioHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GioHangRepository extends JpaRepository<GioHang, Integer> {
    Page<GioHang> findByBienTheGiay_TenGiay(String someField, Pageable pageable);
}
