package com.example.datn.service;

import com.example.datn.dto.BienTheGiayDto;
import com.example.datn.dto.GiayDto;
import com.example.datn.dto.KichThuocDto;
import com.example.datn.dto.MauSacDto;
import com.example.datn.entity.BienTheGiay;
import com.example.datn.filter.FilterBienThe;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

public interface BienTheGiayService {
    Page<BienTheGiay> getAll(int page, int size);

    BienTheGiayDto getOne(MauSacDto ms, KichThuocDto kt, GiayDto g);

    BienTheGiayDto getOneById(int id);

    ResponseEntity save(BienTheGiayDto bienTheGiayDto);

    void delete(int id);

    ResponseEntity update(BienTheGiayDto bienTheGiayDto, int id);

    Page<BienTheGiay>search(String name, int page, int size);

    Page<BienTheGiay> filterBienThe(FilterBienThe filterBienThe, int page, int size);
}
