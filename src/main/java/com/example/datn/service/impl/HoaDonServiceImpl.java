package com.example.datn.service.impl;

import com.example.datn.dto.HoaDonDto;
import com.example.datn.entity.Giay;
import com.example.datn.entity.HoaDon;
import com.example.datn.repository.GiayRepository;
import com.example.datn.repository.HoaDonRepository;
import com.example.datn.service.HoaDonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    HoaDonRepository hoaDonRepository;

    @Autowired
    GiayRepository giayRepository;

    @Override
    public Page<HoaDon> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<HoaDon> returnValue = hoaDonRepository.findAll(pageable);

        return returnValue;
    }


    @Override
    public HoaDonDto save(HoaDonDto hoaDonDto) {
        ModelMapper modelMapper = new ModelMapper();
        HoaDon hoaDon = modelMapper.map(hoaDonDto, HoaDon.class);
        hoaDon.setKhachHang(hoaDonDto.getKhachHang());
        hoaDon.setNhanVien(hoaDonDto.getNhanVien());

        HoaDon addHD = hoaDonRepository.save(hoaDon);
        HoaDonDto returnValue = modelMapper.map(addHD, HoaDonDto.class);

        return returnValue;
    }

    @Override
    public HoaDonDto choXacNhan(int id) {
        HoaDonDto returnValue = new HoaDonDto();
        hoaDonRepository.choXacNhan(id);
        HoaDon hoaDon = hoaDonRepository.findById(id).get();
        BeanUtils.copyProperties(hoaDon, returnValue);
        return returnValue;
    }

    @Override
    public HoaDonDto xacNhan(int id, int soLuong) {
        HoaDonDto returnValue = new HoaDonDto();
        hoaDonRepository.xacNhan(id);

        Giay giay = new Giay();
        int soLuongGiay = giay.getSoLuong() - soLuong;
        giayRepository.updateSoLuong(soLuongGiay);

        HoaDon hoaDon = hoaDonRepository.findById(id).get();
        BeanUtils.copyProperties(hoaDon, returnValue);
        return returnValue;
    }

    @Override
    public HoaDonDto dangGiao(int id) {
        HoaDonDto returnValue = new HoaDonDto();
        hoaDonRepository.dangGiao(id);

        HoaDon hoaDon = hoaDonRepository.findById(id).get();
        BeanUtils.copyProperties(hoaDon, returnValue);
        return returnValue;
    }

    @Override
    public HoaDonDto daGiao(int id) {
        HoaDonDto returnValue = new HoaDonDto();
        hoaDonRepository.daGiao(id);

        HoaDon hoaDon = hoaDonRepository.findById(id).get();
        BeanUtils.copyProperties(hoaDon, returnValue);
        return returnValue;
    }

    @Override
    public HoaDonDto daHuy(int id) {
        HoaDonDto returnValue = new HoaDonDto();
        hoaDonRepository.daHuy(id);

        HoaDon hoaDon = hoaDonRepository.findById(id).get();
        BeanUtils.copyProperties(hoaDon, returnValue);
        return returnValue;
    }

    @Override
    public HoaDonDto daNhan(int id) {
        HoaDonDto returnValue = new HoaDonDto();
        hoaDonRepository.daNhan(id);

        HoaDon hoaDon = hoaDonRepository.findById(id).get();
        BeanUtils.copyProperties(hoaDon, returnValue);
        return returnValue;
    }

    @Override
    public HoaDonDto update(HoaDonDto hoaDonDto, int id) {
        HoaDonDto returnValue = new HoaDonDto();

        hoaDonRepository.update(hoaDonDto, id);

        HoaDon hoaDon = hoaDonRepository.findById(id).get();
        BeanUtils.copyProperties(hoaDon, returnValue);
        return returnValue;
    }

}
