package com.example.datn.service.impl;

import com.example.datn.dto.KhachHangDto;
import com.example.datn.entity.KhachHang;
import com.example.datn.exception.KhachHangException;
import com.example.datn.filter.FilterKhachHang;
import com.example.datn.repository.KhachHangRepository;
import com.example.datn.service.KhachHangService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class KhachHangServiceImpl implements KhachHangService {

    @Autowired
    KhachHangRepository khachHangRepository;

    @Override
    public Page<KhachHang> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<KhachHang> returnValue = khachHangRepository.findAll(pageable);

        return returnValue;
    }

    @Override
    public KhachHangDto getOne(int id) {
        KhachHangDto returnValue = new KhachHangDto();
        KhachHang khachHang = khachHangRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Khách hàng không tồn tại với id là: "+id));
        BeanUtils.copyProperties(khachHang,returnValue);
        return returnValue;
    }

    @Override
    public KhachHangDto save(KhachHangDto khachHangDto) {
        if (khachHangRepository.findByMa(khachHangDto.getMa())!=null){
            throw new KhachHangException("Mã "+khachHangDto.getMa()+" đã tồn tại trong hệ thống");
        }
        ModelMapper modelMapper = new ModelMapper();
        KhachHang khachHang = modelMapper.map(khachHangDto, KhachHang.class);
        KhachHang addkhachHang = khachHangRepository.save(khachHang);
        KhachHangDto returnValue = modelMapper.map(addkhachHang, KhachHangDto.class);

        return returnValue;
    }

    @Override
    public void delete(int id) {
        khachHangRepository.deleteById(id);
    }

    @Override
    public KhachHangDto update(KhachHangDto khachHangDto, int id) {
        if (khachHangRepository.findById(khachHangDto.getId())==null){
            throw new KhachHangException("Id "+khachHangDto.getMa()+" không tồn tại trong hệ thống");
        }
        khachHangRepository.update(khachHangDto, id);

        KhachHangDto returnValue = new KhachHangDto();
        KhachHang khachHang = khachHangRepository.findById(id).get();
        BeanUtils.copyProperties(khachHang,returnValue);
        return returnValue;
    }

    @Override
    public Page<KhachHang> search(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<KhachHang> returnVaule = khachHangRepository.search(name, pageable);
        return returnVaule;
    }

    @Override
    public Page<KhachHang> filterKhachHang(FilterKhachHang filterKhachHang, int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<KhachHang> returnValue = khachHangRepository.filter(filterKhachHang,pageable);
        return returnValue;
    }
}
