package com.example.datn.service;

import com.example.datn.dto.BienTheGiayDto;
import com.example.datn.entity.BienTheGiay;
import com.example.datn.filter.FilterBienThe;
import org.springframework.data.domain.Page;

public interface BienTheGiayService {
    Page<BienTheGiay> getAll(int page, int size);

    BienTheGiayDto getOne(int id);

    BienTheGiayDto save(BienTheGiayDto bienTheGiayDto);

    void delete(int id);

    BienTheGiayDto update(BienTheGiayDto bienTheGiayDto, int id);

    Page<BienTheGiay>search(String name, int page, int size);

    Page<BienTheGiay> filterBienThe(FilterBienThe filterBienThe, int page, int size);
}
