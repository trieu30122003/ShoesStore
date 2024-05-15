package com.example.datn.service.impl;

import com.example.datn.dto.KichThuocDto;
import com.example.datn.entity.KichThuoc;
import com.example.datn.exception.KichThuocException;
import com.example.datn.repository.KichThuocRepository;
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
public class KichThuocServiceImpl implements BaseService<KichThuocDto, KichThuoc> {

    @Autowired
    KichThuocRepository kichThuocRepository;

    @Override
    public Page<KichThuoc> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<KichThuoc> returnValue = kichThuocRepository.findAll(pageable);
        return returnValue;
    }

    @Override
    public KichThuocDto getOne(int id) {
        KichThuocDto returnValue = new KichThuocDto();
        KichThuoc kichThuoc = kichThuocRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Kích thước không tồn tại với id là: "+id));
        BeanUtils.copyProperties(kichThuoc,returnValue);
        return returnValue;
    }

    @Override
    public KichThuocDto save(KichThuocDto kichThuocDto) {
        if (kichThuocRepository.findByMa(kichThuocDto.getMa())!=null){
            throw new KichThuocException("Mã "+kichThuocDto.getMa()+" đã tồn tại");
        }
        ModelMapper modelMapper = new ModelMapper();
        KichThuoc kichThuoc = modelMapper.map(kichThuocDto, KichThuoc.class);
        KichThuoc addKichThuoc = kichThuocRepository.save(kichThuoc);
        KichThuocDto returnValue = modelMapper.map(addKichThuoc, KichThuocDto.class);
        return returnValue;
    }

    @Override
    public KichThuocDto update(KichThuocDto kichThuocDto, int id) {
        if (kichThuocRepository.findById(kichThuocDto.getId())==null){
            throw new KichThuocException("Id "+kichThuocDto.getId()+" chưa tồn tại");
        }
        kichThuocRepository.update(kichThuocDto, id);

        KichThuocDto returnValue = new KichThuocDto();
        KichThuoc kichThuoc = kichThuocRepository.findById(id).get();
        BeanUtils.copyProperties(kichThuoc,returnValue);
        return returnValue;
    }

    @Override
    public void delete(int id) {
        kichThuocRepository.deleteById(id);
    }

    @Override
    public Page<KichThuoc> search(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<KichThuoc> returnValue = kichThuocRepository.findByTen(name,pageable);
        return returnValue;
    }
}
