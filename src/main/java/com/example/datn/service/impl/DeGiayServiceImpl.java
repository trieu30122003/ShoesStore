package com.example.datn.service.impl;

import com.example.datn.dto.DeGiayDto;
import com.example.datn.entity.DeGiay;
import com.example.datn.exception.DeGiayException;
import com.example.datn.repository.DeGiayRepository;
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
public class DeGiayServiceImpl implements BaseService<DeGiayDto, DeGiay> {

    @Autowired
    DeGiayRepository deGiayRepository;

    @Override
    public Page<DeGiay> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<DeGiay> returnValue = deGiayRepository.findAll(pageable);
        return returnValue;
    }

    @Override
    public DeGiayDto getOne(int id) {
        DeGiayDto returnValue = new DeGiayDto();
        DeGiay deGiay = deGiayRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Đế giày không tồn tại id là: "+id));
        BeanUtils.copyProperties(deGiay,returnValue);
        return returnValue;
    }

    @Override
    public DeGiayDto save(DeGiayDto deGiayDto) {
        if (deGiayRepository.findByMa(deGiayDto.getMa())!=null){
            throw new DeGiayException("Mã đế giày đã tồn tại!");
        }
        ModelMapper modelMapper = new ModelMapper();
        DeGiay deGiay= modelMapper.map(deGiayDto, DeGiay.class);
        DeGiay addDeGiay = deGiayRepository.save(deGiay);
        DeGiayDto returnValue = modelMapper.map(addDeGiay, DeGiayDto.class);
        return returnValue;
    }

    @Override
    public DeGiayDto update(DeGiayDto deGiayDto, int id) {
        DeGiayDto returnValue = new DeGiayDto();
//        if (deGiayRepository.findByMa(deGiayDto.getMa())!=null){
//            throw new DeGiayException("Mã đế giày đã tồn tại!");
//        }else
            if (deGiayRepository.findById(id).get()==null){
            throw new DeGiayException("Không tồn tại id là: "+id);
        }
        deGiayRepository.update(deGiayDto,id);
        DeGiay deGiay = deGiayRepository.findById(id).get();
        BeanUtils.copyProperties(deGiay,returnValue);
        return returnValue;
    }

    @Override
    public void delete(int id) {
        deGiayRepository.deleteById(id);
    }

    @Override
    public Page<DeGiay> search(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<DeGiay> returnValue = deGiayRepository.findByTen(name,pageable);
        return returnValue;
    }
}
