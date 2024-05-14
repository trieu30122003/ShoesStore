package com.example.datn.repository;

import com.example.datn.dto.ChatLieuDto;
import com.example.datn.entity.ChatLieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ChatLieuRepository extends JpaRepository<ChatLieu, Integer> {

    ChatLieu findByMa(String ma);

    @Transactional
    @Modifying
    @Query(value = "update ChatLieu c set " +
            "c.ma = :#{#chatLieuDto.ma}," +
            "c.ten = :#{#chatLieuDto.ten}," +
            "c.moTa = :#{#chatLieuDto.moTa}," +
            "c.trangThai = :#{#chatLieuDto.trangThai} where c.id = :id")
    void update(ChatLieuDto chatLieuDto, int id);

    @Query(value = "select c from ChatLieu c where c.ten = :name")
    Page<ChatLieu> search(String name, Pageable pageable);
//
//    @Query(value = "select c from ChatLieu c where " +
//            "(:#{#chatLieuDto.ten} IS NULL OR :#{#chatLieuDto.ten}='' OR lower(c.ten) like concat('%', lower(:#{#chatLieuDto.ten}),'%'))"
//    )
//    List<ChatLieu> filter(ChatLieuDto chatLieuDto);
}
