package com.example.datn.service.impl;

import com.example.datn.dto.GiayDto;
import com.example.datn.entity.Giay;
import com.example.datn.exception.GiayException;
import com.example.datn.filter.FilterGiay;
import com.example.datn.repository.GiayRepository;
import com.example.datn.service.GiayService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GiayServiceImpl implements GiayService {
    @Autowired
    GiayRepository giayRepository;

    @Override
    public Page<Giay> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Giay> returnValue = giayRepository.findAll(pageable);

        return returnValue;
    }

    @Override
    public GiayDto getOne(int id) {
        GiayDto returnValue = new GiayDto();
        Giay giay = giayRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Giày không tồn tại với id là: "+id));
        BeanUtils.copyProperties(giay, returnValue);
        return returnValue;
    }

    @Override
    public GiayDto save(GiayDto giayDto) {
        if (giayRepository.findByMa(giayDto.getMa())!=null){
            throw new GiayException("Mã "+giayDto.getMa()+" đã tồn tại trong hệ thống");
        }
        ModelMapper modelMapper = new ModelMapper();
        Giay giay = modelMapper.map(giayDto, Giay.class);
        Giay addGiay = giayRepository.save(giay);
        GiayDto returnValue = modelMapper.map(addGiay, GiayDto.class);

        return returnValue;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public GiayDto update(GiayDto giayDto, int id) {
        if (giayRepository.findById(id)==null){
            throw new GiayException("Giày không tồn tại với id là: "+id);
        }
        giayRepository.update(giayDto, id);

        GiayDto returnValue = new GiayDto();
        Giay giay = giayRepository.findById(id).get();
        BeanUtils.copyProperties(giay, returnValue);
        return returnValue;
    }

    @Override
    public Page<Giay> search(String name, int page, int size) {
        return null;
    }

    @Override
    public Page<Giay> filterGiay(FilterGiay filterGiay, int page, int size) {
        return null;
    }
}
