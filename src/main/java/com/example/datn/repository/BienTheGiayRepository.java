package com.example.datn.repository;

import com.example.datn.dto.*;
import com.example.datn.entity.BienTheGiay;
import com.example.datn.filter.FilterBienThe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Repository
public interface BienTheGiayRepository extends JpaRepository<BienTheGiay, Integer> {
    BienTheGiay findByMa(String ma);

    Page<BienTheGiay> findByGiay_Ten(String name, Pageable pageable);

    @Query(value = "select bt.giaBan from BienTheGiay bt where bt.id = :id")
    BigDecimal findByGiaBan(int id);

    @Transactional
    @Modifying
    @Query(value = "update BienTheGiay b set " +
            "b.ma = :#{#bienTheGiayDto.ma}," +
            "b.giaBan = :#{#bienTheGiayDto.giaBan}," +
            "b.giaNhap = :#{#bienTheGiayDto.giaNhap}," +
            "b.hinhAnh = :#{#bienTheGiayDto.hinhAnh}," +
            "b.kichThuoc = :#{#bienTheGiayDto.kichThuoc}," +
            "b.mauSac = :#{#bienTheGiayDto.mauSac}," +
            "b.giay = :#{#bienTheGiayDto.giay}," +
            "b.trangThai = :#{#bienTheGiayDto.trangThai} where b.id = :id")
    void update(BienTheGiayDto bienTheGiayDto, int id);

    @Query(value = "select b from BienTheGiay b where " +
            "(:#{#filterBienThe.giaBanMin} IS NULL OR :#{#filterBienThe.giaBanMax} IS NULL OR b.giaBan BETWEEN :#{#filterBienThe.giaBanMin} and :#{#filterBienThe.giaBanMax}) and " +
            "(:#{#filterBienThe.trangThai} IS NULL OR :#{#filterBienThe.trangThai}='' OR b.trangThai = :#{#filterBienThe.trangThai}) and " +
            "(:#{#filterBienThe.kichThuocMin.chieuDai} IS NULL OR :#{#filterBienThe.kichThuocMax.chieuDai} IS NULL OR b.kichThuoc.chieuDai BETWEEN :#{#filterBienThe.kichThuocMin.chieuDai} and :#{#filterBienThe.kichThuocMax.chieuDai}) and" +
            "(:#{#filterBienThe.mauSac.ten} IS NULL OR :#{#filterBienThe.mauSac.ten}='' OR lower(b.mauSac.ten) like concat('%',lower(:#{#filterBienThe.mauSac.ten}),'%')) and" +
            "(:#{#filterBienThe.giay.ten} IS NULL OR :#{#filterBienThe.giay.ten}='' OR lower(b.giay.ten) like concat('%',lower(:#{#filterBienThe.giay.ten}),'%'))"
    )
    Page<BienTheGiay> filterBienThe(FilterBienThe filterBienThe, Pageable pageable);

    @Query(value = "select b from BienTheGiay b where b.mauSac.id = :#{#ms.id} and b.kichThuoc.id = :#{#kt.id} and b.giay = :#{#g.id}")
    BienTheGiay bienThe(MauSacDto ms, KichThuocDto kt, GiayDto g);

    @Query(value = "select count(bt.id) from BienTheGiay bt where bt.create_date between :start and :end")
    int productIn(Date start, Date end);

    @Query(value = "select bt from BienTheGiay bt where bt.create_date between :start and :end")
    List<BienTheGiay> listProductIn(Date start, Date end);

}
