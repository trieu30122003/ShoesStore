package com.example.datn.service.impl;

import com.example.datn.dto.CoGiayDto;
import com.example.datn.entity.CoGiay;
import com.example.datn.exception.ChatLieuException;
import com.example.datn.repository.CoGiayRepository;
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
public class CoGiayServiceImpl implements BaseService<CoGiayDto, CoGiay> {

    @Autowired
    CoGiayRepository coGiayRepository;

    @Override
    public Page<CoGiay> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CoGiay> returnValue = coGiayRepository.findAll(pageable);
        return returnValue;
    }

    @Override
    public CoGiayDto getOne(int id) {
        CoGiayDto returnValue = new CoGiayDto();
        CoGiay coGiay = coGiayRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Cổ giày không tồn tại khi id là: "+id));
        BeanUtils.copyProperties(coGiay,returnValue);
        return returnValue;
    }

    @Override
    public CoGiayDto save(CoGiayDto coGiayDto) {
        if(coGiayRepository.findByMa(coGiayDto.getMa()) != null){
            throw new ChatLieuException("Mã cổ giày đã tồn tại");
        }
        ModelMapper modelMapper = new ModelMapper();
        CoGiay coGiay = modelMapper.map(coGiayDto, CoGiay.class);
        CoGiay addCoGiay = coGiayRepository.save(coGiay);
        CoGiayDto returnValue = modelMapper.map(addCoGiay, CoGiayDto.class);
        return returnValue;
    }

    @Override
    public CoGiayDto update(CoGiayDto coGiayDto, int id) {
        CoGiayDto returnValue = new CoGiayDto();
        if(coGiayRepository.findByMa(coGiayDto.getMa()) != null){
            throw new ChatLieuException("Mã cổ giày đã tồn tại");
        }
        coGiayRepository.update(coGiayDto,id);

        CoGiay coGiay = coGiayRepository.findById(id).get();
        BeanUtils.copyProperties(coGiay, returnValue);
        return returnValue;
    }

    @Override
    public void delete(int id) {
        coGiayRepository.deleteById(id);
    }

    @Override
    public Page<CoGiay> search(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<CoGiay> returnValue = coGiayRepository.findByTen(name,pageable);
        return returnValue;
    }
}
