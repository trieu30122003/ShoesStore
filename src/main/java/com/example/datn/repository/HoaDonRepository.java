package com.example.datn.repository;

import com.example.datn.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update HoaDon h set h.trangThai = 1 where h.id = :id")
    void choXacNhan(int id);

    @Transactional
    @Modifying
    @Query(value = "update HoaDon h set h.trangThai = 2 where h.id = :id")
    void xacNhan(int id);

    @Transactional
    @Modifying
    @Query(value = "update HoaDon h set h.trangThai = 3 where h.id = :id")
    void dangGiao(int id);

    @Transactional
    @Modifying
    @Query(value = "update HoaDon h set h.trangThai = 4 where h.id = :id")
    void daGiao(int id);

    @Transactional
    @Modifying
    @Query(value = "update HoaDon h set h.trangThai = 5 where h.id = :id")
    void daNhan(int id);

    @Transactional
    @Modifying
    @Query(value = "update HoaDon h set h.trangThai = 6 where h.id = :id")
    void daHuy(int id);


}
