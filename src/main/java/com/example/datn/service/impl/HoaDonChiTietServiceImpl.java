package com.example.datn.service.impl;

import com.example.datn.dto.HoaDonChiTietDto;
import com.example.datn.entity.HoaDonChiTiet;
import com.example.datn.exception.GiayException;
import com.example.datn.repository.GiayRepository;
import com.example.datn.repository.HoaDonChiTietRepository;
import com.example.datn.service.BaseService;
import com.example.datn.service.HoaDonChiTietService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {

    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository;

    @Autowired
    GiayRepository giayRepository;

    @Override
    public ResponseEntity save(HoaDonChiTietDto hoaDonChiTietDto) {
        if (giayRepository.findBySoLuong(hoaDonChiTietDto.getBienTheGiay().getGiay().getSoLuong())> hoaDonChiTietDto.getSoLuong()){
            return ResponseEntity.badRequest().body("Vuợt quá số lượng");
//            throw new GiayException("Số lượng đã vượt quá số lượng còn lại!!");
        }
        if (giayRepository.findByTrangThai(hoaDonChiTietDto.getBienTheGiay().getGiay().getTrangThai())==1){
//            throw new GiayException("Sản phẩm này đã hết hàng!!");
            return ResponseEntity.badRequest().body("Sản phẩm này đã hết hàng");
        }
        ModelMapper modelMapper = new ModelMapper();
        HoaDonChiTiet hoaDonChiTiet = modelMapper.map(hoaDonChiTietDto, HoaDonChiTiet.class);
        hoaDonChiTiet.setBienTheGiay(hoaDonChiTietDto.getBienTheGiay());
        hoaDonChiTiet.setHoaDon(hoaDonChiTietDto.getHoaDon());
        HoaDonChiTiet addHDCT = hoaDonChiTietRepository.save(hoaDonChiTiet);
        HoaDonChiTietDto returnValue = modelMapper.map(addHDCT, HoaDonChiTietDto.class);
        return ResponseEntity.ok(returnValue);
    }

    @Override
    public List<HoaDonChiTietDto> getAllByHoaDon(int id) {
        List<HoaDonChiTietDto> returnValue = new ArrayList<>();
        List<HoaDonChiTiet> hoaDonChiTietList = hoaDonChiTietRepository.getAll(id);
        BeanUtils.copyProperties(hoaDonChiTietList, returnValue);
        return returnValue;
    }

    @Override
    public HoaDonChiTietDto update(HoaDonChiTietDto hoaDonChiTietDto, int id) {
        return null;
    }

}
