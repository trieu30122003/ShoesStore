package com.example.datn.service.impl;

import com.example.datn.dto.BienTheGiayDto;
import com.example.datn.entity.BienTheGiay;
import com.example.datn.exception.BienTheGiayException;
import com.example.datn.repository.BienTheGiayRepository;
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
public class BienTheGiayServiceImpl implements BaseService<BienTheGiayDto, BienTheGiay> {

    @Autowired
    BienTheGiayRepository bienTheGiayRepository;

    @Override
    public Page<BienTheGiay> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<BienTheGiay> returnValue = bienTheGiayRepository.findAll(pageable);
        return returnValue;
    }

    @Override
    public BienTheGiayDto getOne(int id) {
        BienTheGiayDto returnValue = new BienTheGiayDto();
        BienTheGiay bienTheGiay= bienTheGiayRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Biến thể giày không tồn tại với id là: "+id));
        BeanUtils.copyProperties(bienTheGiay, returnValue);
        return returnValue;
    }

    @Override
    public BienTheGiayDto save(BienTheGiayDto bienTheGiayDto) {
        if (bienTheGiayRepository.findByMa(bienTheGiayDto.getMa())!=null){
            throw new BienTheGiayException("Mã "+bienTheGiayDto.getMa()+" đã tồn tại trong hệ thống");
        }

        ModelMapper modelMapper = new ModelMapper();
        BienTheGiay bienTheGiay = modelMapper.map(bienTheGiayDto, BienTheGiay.class);

        bienTheGiay.setKichThuoc(bienTheGiayDto.getKichThuoc());
        bienTheGiay.setMauSac(bienTheGiayDto.getMauSac());
        bienTheGiay.setGiay(bienTheGiayDto.getGiay());

        BienTheGiay addBienThe = bienTheGiayRepository.save(bienTheGiay);
        BienTheGiayDto returnValue = modelMapper.map(addBienThe, BienTheGiayDto.class);

        return returnValue;
    }

    @Override
    public BienTheGiayDto update(BienTheGiayDto bienTheGiayDto, int id) {
        if (bienTheGiayRepository.findById(id)==null){
            throw new BienTheGiayException("id "+id+" chưa có trong hệ thống");
        }
        bienTheGiayRepository.update(bienTheGiayDto,id);

        BienTheGiayDto returnValue = new BienTheGiayDto();
        BienTheGiay bienTheGiay = bienTheGiayRepository.findById(id).get();
        BeanUtils.copyProperties(bienTheGiay, returnValue);
        return returnValue;
    }

    @Override
    public void delete(int id) {
        bienTheGiayRepository.deleteById(id);
    }

    @Override
    public Page<BienTheGiay> search(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<BienTheGiay> returnValue = bienTheGiayRepository.findByGiay_Ten(name, pageable);
        return returnValue;
    }
}
