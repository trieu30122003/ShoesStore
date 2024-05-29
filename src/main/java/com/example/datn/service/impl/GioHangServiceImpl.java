package com.example.datn.service.impl;

import com.example.datn.dto.GioHangDto;
import com.example.datn.entity.GioHang;
import com.example.datn.repository.GioHangRepository;
import com.example.datn.service.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class GioHangServiceImpl implements BaseService<GioHangDto, GioHang> {

    @Autowired
    GioHangRepository gioHangRepository;

    @Override
    public Page<GioHang> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        //theo 1 tiêu chí
//        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy));
        // theo nhiều tiêu chí
//        Sort sort = Sort.by(
//                Sort.Order.asc("firstProperty"),
//                Sort.Order.desc("secondProperty")
//        );
//        Pageable pageable = PageRequest.of(page, size, sort);
        Page<GioHang> returnValue = gioHangRepository.findAll(pageable);

        return returnValue;
    }

    @Override
    public GioHangDto getOne(int id) {
        GioHangDto returnValue = new GioHangDto();
        GioHang gioHang = gioHangRepository.findById(id)
                                           .orElseThrow(() -> new EntityNotFoundException("Giỏ hàng không tồn tại"));
        BeanUtils.copyProperties(gioHang, returnValue);
        return returnValue;
    }

    @Override
    public GioHangDto save(GioHangDto gioHangDto) {
        ModelMapper modelMapper = new ModelMapper();
        GioHang gioHang = modelMapper.map(gioHangDto, GioHang.class);
        gioHang.setKhachHang(gioHangDto.getKhachHang());
        gioHang.setBienTheGiay(gioHangDto.getBienTheGiay());
        GioHang addGioHang = gioHangRepository.save(gioHang);
        GioHangDto returnValue = modelMapper.map(addGioHang, GioHangDto.class);

        return returnValue;
    }

    @Override
    public GioHangDto update(GioHangDto gioHangDto, int id) {
        return null;
    }

    @Override
    public void delete(int id) {
        gioHangRepository.deleteById(id);
    }

    @Override
    public Page<GioHang> search(String name, int page, int size) {
        return null;
    }
}
