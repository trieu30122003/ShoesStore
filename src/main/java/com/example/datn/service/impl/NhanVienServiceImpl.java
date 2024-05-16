package com.example.datn.service.impl;

import com.example.datn.dto.NhanVienDto;
import com.example.datn.entity.NhanVien;
import com.example.datn.exception.NhanVienException;
import com.example.datn.repository.NhanVienRepository;
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
public class NhanVienServiceImpl implements BaseService<NhanVienDto, NhanVien> {

    @Autowired
    NhanVienRepository nhanVienRepository;

    @Override
    public Page<NhanVien> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<NhanVien> returnValue = nhanVienRepository.findAll(pageable);

        return returnValue;
    }

    @Override
    public NhanVienDto getOne(int id) {
        NhanVienDto returnValue = new NhanVienDto();
        NhanVien nhanVien = nhanVienRepository.findById(id).orElseThrow(()->new EntityNotFoundException("Nhân viên không tồn tại với id là: "+id));
        BeanUtils.copyProperties(nhanVien, returnValue);
        return returnValue;
    }

    @Override
    public NhanVienDto save(NhanVienDto nhanVienDto) {
        if (nhanVienRepository.findByMa(nhanVienDto.getMa())!=null){
            throw new NhanVienException("Mã "+nhanVienDto.getMa()+" đã tồn tại trong hệ thống");
        }
        ModelMapper modelMapper = new ModelMapper();
        NhanVien nhanVien = modelMapper.map(nhanVienDto, NhanVien.class);
        NhanVien addNhanVien = nhanVienRepository.save(nhanVien);
        NhanVienDto returnValue = modelMapper.map(addNhanVien, NhanVienDto.class);

        return returnValue;
    }

    @Override
    public NhanVienDto update(NhanVienDto nhanVienDto, int id) {
        if (nhanVienRepository.findById(id)==null){
            throw new NhanVienException("id "+id+" chưa tồn tại trong hệ thống");
        }
        nhanVienRepository.update(nhanVienDto, id);

        NhanVienDto returnValue = new NhanVienDto();
        NhanVien nhanVien = nhanVienRepository.findById(id).get();
        BeanUtils.copyProperties(nhanVien, returnValue);
        return returnValue;
    }

    @Override
    public void delete(int id) {
        nhanVienRepository.deleteById(id);
    }

    @Override
    public Page<NhanVien> search(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page,size);
        Page<NhanVien> returnValue = nhanVienRepository.search(name,pageable);
        return returnValue;
    }
}
