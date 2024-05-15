package com.example.datn.service.impl;

import com.example.datn.dto.LotGiayDto;
import com.example.datn.entity.LotGiay;
import com.example.datn.exception.LotGiayException;
import com.example.datn.repository.LotGiayRepository;
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
public class LotGiayServiceImpl implements BaseService<LotGiayDto, LotGiay> {
    @Autowired
    LotGiayRepository lotGiayRepository;

    @Override
    public Page<LotGiay> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<LotGiay> returnValue = lotGiayRepository.findAll(pageable);
        return returnValue;
    }

    @Override
    public LotGiayDto getOne(int id) {
        LotGiayDto returnValue = new LotGiayDto();
        LotGiay lotGiay = lotGiayRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Lót giày không tồn tại với id là: "+id));
        BeanUtils.copyProperties(lotGiay,returnValue);
        return returnValue;
    }

    @Override
    public LotGiayDto save(LotGiayDto lotGiayDto) {
        if (lotGiayRepository.findByMa(lotGiayDto.getMa())!=null){
            throw new LotGiayException("Mã "+lotGiayDto.getMa()+" đã tồn tại trong hệ thống");
        }
        ModelMapper modelMapper = new ModelMapper();
        LotGiay lotGiay = modelMapper.map(lotGiayDto, LotGiay.class);
        LotGiay addLotGiay = lotGiayRepository.save(lotGiay);
        LotGiayDto returnValue = modelMapper.map(addLotGiay, LotGiayDto.class);

        return returnValue;
    }

    @Override
    public LotGiayDto update(LotGiayDto lotGiayDto, int id) {
        if (lotGiayRepository.findById(lotGiayDto.getId())==null){
            throw new LotGiayException("Id "+lotGiayDto.getId()+" chưa tồn tại trong hệ thống");
        }
        lotGiayRepository.update(lotGiayDto, id);

        LotGiayDto returnValue = new LotGiayDto();
        LotGiay lotGiay = lotGiayRepository.findById(id).get();
        BeanUtils.copyProperties(lotGiay,returnValue);
        return returnValue;
    }

    @Override
    public void delete(int id) {
        lotGiayRepository.deleteById(id);
    }

    @Override
    public Page<LotGiay> search(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<LotGiay> returnValue = lotGiayRepository.findByTen(name,pageable);
        return returnValue;
    }
}
