package com.example.datn.service.impl;

import com.example.datn.dto.MauSacDto;
import com.example.datn.entity.MauSac;
import com.example.datn.exception.MauSacException;
import com.example.datn.repository.MauSacRepository;
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
public class MauSacServiceImpl implements BaseService<MauSacDto, MauSac> {

    @Autowired
    MauSacRepository mauSacRepository;

    @Override
    public Page<MauSac> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<MauSac> returnValue = mauSacRepository.findAll(pageable);
        return returnValue;
    }

    @Override
    public MauSacDto getOne(int id) {
        MauSacDto returnValue = new MauSacDto();
        MauSac mauSac = mauSacRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Màu sắc không tồn tại với id là: "+id));
        BeanUtils.copyProperties(mauSac, returnValue);
        return returnValue;
    }

    @Override
    public MauSacDto save(MauSacDto mauSacDto) {
        if (mauSacRepository.findByMa(mauSacDto.getMa())!=null){
            throw new MauSacException("Mã "+mauSacDto.getMa()+" đã tồn tại trong hệ thống");
        }
        ModelMapper modelMapper = new ModelMapper();
        MauSac mauSac = modelMapper.map(mauSacDto, MauSac.class);
        MauSac addMauSac = mauSacRepository.save(mauSac);
        MauSacDto returnValue = modelMapper.map(addMauSac, MauSacDto.class);

        return returnValue;
    }

    @Override
    public MauSacDto update(MauSacDto mauSacDto, int id) {
        if (mauSacRepository.findByMa(mauSacDto.getMa())==null){
            throw new MauSacException("Mã "+mauSacDto.getMa()+" chưa tồn tại trong hệ thống");
        }
        mauSacRepository.update(mauSacDto, id);

        MauSacDto returnValue = new MauSacDto();
        MauSac mauSac = mauSacRepository.findById(id).get();
        BeanUtils.copyProperties(mauSac, returnValue);
        return returnValue;
    }

    @Override
    public void delete(int id) {
        mauSacRepository.deleteById(id);
    }

    @Override
    public Page<MauSac> search(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<MauSac> returnValue = mauSacRepository.findByTen(name, pageable);
        return returnValue;
    }
}
