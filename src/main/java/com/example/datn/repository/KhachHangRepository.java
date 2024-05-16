package com.example.datn.repository;

import com.example.datn.dto.KhachHangDto;
import com.example.datn.entity.KhachHang;
import com.example.datn.filter.FilterKhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
    KhachHang findByMa(String ma);

    @Transactional
    @Modifying
    @Query(value = "update KhachHang kh set " +
            "kh.ma = :#{#khachHangDto.ma}, " +
            "kh.ho = :#{#khachHangDto.ho}, " +
            "kh.ten = :#{#khachHangDto.ten}, " +
            "kh.email = :#{#khachHangDto.email}, " +
            "kh.gioiTinh = :#{#khachHangDto.gioiTinh}, " +
            "kh.ngaySinh = :#{#khachHangDto.ngaySinh}, " +
            "kh.diaChi = :#{#khachHangDto.diaChi}, " +
            "kh.sdt = :#{#khachHangDto.sdt}, " +
            "kh.trangThai = :#{#khachHangDto.trangThai} where kh.id = :id"
    )
    void update(KhachHangDto khachHangDto,int id);

    @Query(value = "select kh from KhachHang kh where lower(kh.ho) like concat('%',lower(:name),'%') or lower(kh.ten) like concat('%',lower(:name),'%') or lower(kh.sdt) like concat('%',lower(:name),'%') ")
    Page<KhachHang> search(String name, Pageable pageable);

    @Query(value = "select kh from KhachHang kh where " +
            "(:#{#filterKhachHang.gioiTinh} IS NULL OR :#{#filterKhachHang.gioiTinh}='' OR kh.gioiTinh = :#{#filterKhachHang.gioiTinh}) and" +
            "(:#{#filterKhachHang.trangThai} IS NULL OR :#{#filterKhachHang.trangThai}='' OR kh.trangThai = :#{#filterKhachHang.trangThai}) and" +
            "(:#{#filterKhachHang.tuNgay} IS NULL OR :#{#filterKhachHang.denNgay} IS NULL OR kh.ngaySinh BETWEEN :#{#filterKhachHang.tuNgay} and :#{#filterKhachHang.denNgay})"
    )
    Page<KhachHang> filter(FilterKhachHang filterKhachHang, Pageable pageable);

}
