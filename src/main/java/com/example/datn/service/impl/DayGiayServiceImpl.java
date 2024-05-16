package com.example.datn.service.impl;

import com.example.datn.dto.DayGiayDto;
import com.example.datn.entity.DayGiay;
import com.example.datn.exception.DayGiayException;
import com.example.datn.repository.DayGiayRepository;
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
public class DayGiayServiceImpl implements BaseService<DayGiayDto, DayGiay> {

    @Autowired
    DayGiayRepository dayGiayRepository;

    @Override
    public Page<DayGiay> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<DayGiay> returnValue = dayGiayRepository.findAll(pageable);
        return returnValue;
    }

    @Override
    public DayGiayDto getOne(int id) {
        DayGiayDto returnValue = new DayGiayDto();
        DayGiay dayGiay = dayGiayRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Dây giày không tồn tại với id là: "+id));
        BeanUtils.copyProperties(dayGiay, returnValue);
        return returnValue;
    }

    @Override
    public DayGiayDto save(DayGiayDto dayGiayDto) {
        if (dayGiayRepository.findByMa(dayGiayDto.getMa())!=null){
            throw new DayGiayException("Mã "+dayGiayDto.getMa()+" đã tồn tại trong hệ thống");
        }
        ModelMapper modelMapper = new ModelMapper();
        DayGiay dayGiay = modelMapper.map(dayGiayDto, DayGiay.class);
        DayGiay addDayGiay = dayGiayRepository.save(dayGiay);
        DayGiayDto returnValue = modelMapper.map(addDayGiay, DayGiayDto.class);

        return returnValue;
    }

    @Override
    public DayGiayDto update(DayGiayDto dayGiayDto, int id) {
        if (dayGiayRepository.findById(id)==null){
            throw new DayGiayException("Id "+id+" chưa tồn tại trong hệ thống");
        }
        dayGiayRepository.update(dayGiayDto,id);

        DayGiayDto returnValue = new DayGiayDto();
        DayGiay dayGiay = dayGiayRepository.findById(id).get();
        BeanUtils.copyProperties(dayGiay, returnValue);
        return returnValue;
    }

    @Override
    public void delete(int id) {
        dayGiayRepository.deleteById(id);
    }

    @Override
    public Page<DayGiay> search(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<DayGiay> returnValue = dayGiayRepository.findByTen(name, pageable);

        return returnValue;
    }
}
