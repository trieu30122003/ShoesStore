package com.example.datn.service.impl;

import com.example.datn.dto.HashTagDetailDto;
import com.example.datn.entity.HashTagChiTiet;
import com.example.datn.repository.HashTagDetailRepository;
import com.example.datn.service.BaseService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HashTagDetailServiceImpl implements BaseService<HashTagDetailDto, HashTagChiTiet> {
    @Autowired
    HashTagDetailRepository hashTagDetailRepository;

    @Override
    public Page<HashTagChiTiet> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<HashTagChiTiet> returnValue = hashTagDetailRepository.findAll(pageable);
        return returnValue;
    }

    @Override
    public HashTagDetailDto getOne(int id) {
        HashTagDetailDto returnValue = new HashTagDetailDto();
        HashTagChiTiet hashTagChiTiet = hashTagDetailRepository.findById(id).orElseThrow(()->new EntityNotFoundException("HashTagChiTiet không tồn tại với id là: "+id));
        BeanUtils.copyProperties(hashTagChiTiet,returnValue);
        return returnValue;
    }

    @Override
    public HashTagDetailDto save(HashTagDetailDto hashTagDetailDto) {
        ModelMapper modelMapper = new ModelMapper();
        HashTagChiTiet hashTagChiTiet = modelMapper.map(hashTagDetailDto, HashTagChiTiet.class);
        HashTagChiTiet addHashTagCT = hashTagDetailRepository.save(hashTagChiTiet);
        HashTagDetailDto returnValue = modelMapper.map(addHashTagCT, HashTagDetailDto.class);
        return returnValue;
    }

    @Override
    public HashTagDetailDto update(HashTagDetailDto hashTagDetailDto, int id) {
        hashTagDetailRepository.update(hashTagDetailDto, id);
        HashTagDetailDto returnValue = new HashTagDetailDto();
        HashTagChiTiet hashTagChiTiet = hashTagDetailRepository.findById(id).get();
        BeanUtils.copyProperties(hashTagChiTiet,returnValue);
        return returnValue;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Page<HashTagChiTiet> search(String name, int page, int size) {
        return null;
    }
}
