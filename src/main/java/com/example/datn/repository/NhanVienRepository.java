package com.example.datn.repository;

import com.example.datn.dto.NhanVienDto;
import com.example.datn.dto.ThuongHieuDto;
import com.example.datn.entity.NhanVien;
import com.example.datn.entity.ThuongHieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Integer> {
    NhanVien findByMa(String ma);

    @Transactional
    @Modifying
    @Query(value = "update NhanVien m set " +
            "m.ma = :#{#nhanVienDto.ma}," +
            "m.ho = :#{#nhanVienDto.ho}," +
            "m.ten = :#{#nhanVienDto.ten}," +
            "m.gioiTinh = :#{#nhanVienDto.gioiTinh}," +
            "m.ngaySinh = :#{#nhanVienDto.ngaySinh}," +
            "m.diaChi = :#{#nhanVienDto.diaChi}," +
            "m.email = :#{#nhanVienDto.email}," +
            "m.sdt = :#{#nhanVienDto.sdt}," +
//            "m.encryptedPassword = :#{#nhanVienDto.encryptedPassword}," +
            "m.trangThai = :#{#nhanVienDto.trangThai} where m.id = :id")
    void update(NhanVienDto nhanVienDto, int id);

    @Query(value = "select n from NhanVien n where " +
            "lower(n.ho) like concat('%',lower(:name),'%') or " +
            "lower(n.ten) like concat('%',lower(:name),'%') or " +
            "lower(n.sdt) like concat('%',lower(:name),'%') or " +
            "lower(n.email) like concat('%',lower(:name),'%') or " +
            "lower(n.ma) like concat('%',lower(:name),'%')")
    Page<NhanVien> search(String name, Pageable pageable);
}
