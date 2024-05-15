package com.example.datn.service.impl;

import com.example.datn.dto.MuiGiayDto;
import com.example.datn.entity.MuiGiay;
import com.example.datn.exception.MuiGiayException;
import com.example.datn.repository.MuiGiayRepository;
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
public class MuiGiayServiceImpl implements BaseService<MuiGiayDto, MuiGiay> {
    @Autowired
    MuiGiayRepository muiGiayRepository;

    @Override
    public Page<MuiGiay> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<MuiGiay> returnValue = muiGiayRepository.findAll(pageable);
        return returnValue;
    }

    @Override
    public MuiGiayDto getOne(int id) {
        MuiGiayDto returnValue = new MuiGiayDto();
        MuiGiay muiGiay = muiGiayRepository.findById(id)
                                           .orElseThrow(() -> new EntityNotFoundException("Mũi giày không tồn tại khi id là: " + id));
        BeanUtils.copyProperties(muiGiay, returnValue);
        return returnValue;
    }

    @Override
    public MuiGiayDto save(MuiGiayDto muiGiayDto) {
        if (muiGiayRepository.findByMa(muiGiayDto.getMa()) != null) {
            throw new MuiGiayException("Mã " + muiGiayDto.getMa() + " đã tồn tại trong hệ thống");
        }
        ModelMapper modelMapper = new ModelMapper();
        MuiGiay muiGiay = modelMapper.map(muiGiayDto, MuiGiay.class);
        MuiGiay addMuiGiay = muiGiayRepository.save(muiGiay);
        MuiGiayDto returnValue = modelMapper.map(addMuiGiay, MuiGiayDto.class);

        return returnValue;
    }

    @Override
    public MuiGiayDto update(MuiGiayDto muiGiayDto, int id) {
        if (muiGiayRepository.findById(muiGiayDto.getId()) == null) {
            throw new MuiGiayException("Mã " + muiGiayDto.getMa() + " chưa tồn tại trong hệ thống");
        }
        muiGiayRepository.update(muiGiayDto, id);

        MuiGiayDto returnValue = new MuiGiayDto();
        MuiGiay muiGiay = muiGiayRepository.findById(id)
                                           .get();
        BeanUtils.copyProperties(muiGiay, returnValue);
        return returnValue;
    }

    @Override
    public void delete(int id) {
        muiGiayRepository.deleteById(id);
    }

    @Override
    public Page<MuiGiay> search(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<MuiGiay> returnValue = muiGiayRepository.findByTen(name, pageable);

        return returnValue;
    }
}
