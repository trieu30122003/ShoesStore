package com.example.datn.service.impl;

import com.example.datn.dto.ThuongHieuDto;
import com.example.datn.entity.ThuongHieu;
import com.example.datn.exception.ThuongHieuException;
import com.example.datn.repository.ThuongHieuRepository;
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
public class ThuongHieuServiceImpl implements BaseService<ThuongHieuDto, ThuongHieu> {
    @Autowired
    ThuongHieuRepository thuongHieuRepository;

    @Override
    public Page<ThuongHieu> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ThuongHieu> returnValue = thuongHieuRepository.findAll(pageable);
        return returnValue;
    }

    @Override
    public ThuongHieuDto getOne(int id) {
        ThuongHieuDto returnValue = new ThuongHieuDto();
        ThuongHieu thuongHieu = thuongHieuRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Thương hiệu không tồn tại với id là: "+id));
        BeanUtils.copyProperties(thuongHieu, returnValue);
        return returnValue;
    }

    @Override
    public ThuongHieuDto save(ThuongHieuDto thuongHieuDto) {
        if (thuongHieuRepository.findByMa(thuongHieuDto.getMa())!=null){
            throw new ThuongHieuException("Mã "+thuongHieuDto.getMa()+" đã tồn tại trong hệ thống");
        }
        ModelMapper modelMapper = new ModelMapper();
        ThuongHieu thuongHieu = modelMapper.map(thuongHieuDto, ThuongHieu.class);
        ThuongHieu addThuongHieu = thuongHieuRepository.save(thuongHieu);
        ThuongHieuDto returnValue = modelMapper.map(addThuongHieu, ThuongHieuDto.class);
        return returnValue;
    }

    @Override
    public ThuongHieuDto update(ThuongHieuDto thuongHieuDto, int id) {
        if (thuongHieuRepository.findById(thuongHieuDto.getId())==null){
            throw new ThuongHieuException("Id "+thuongHieuDto.getId()+" chưa tồn tại trong hệ thống");
        }
        thuongHieuRepository.update(thuongHieuDto, id);

        ThuongHieuDto returnValue = new ThuongHieuDto();
        ThuongHieu thuongHieu = thuongHieuRepository.findById(id).get();
        BeanUtils.copyProperties(thuongHieu, returnValue);
        return returnValue;
    }

    @Override
    public void delete(int id) {
        thuongHieuRepository.deleteById(id);
    }

    @Override
    public Page<ThuongHieu> search(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ThuongHieu> returnValue = thuongHieuRepository.findByTen(name, pageable);

        return returnValue;
    }
}
