package com.example.datn.service.impl;

import com.example.datn.dto.HoaDonChiTietDto;
import com.example.datn.entity.HoaDonChiTiet;
import com.example.datn.repository.BienTheGiayRepository;
import com.example.datn.repository.GiayRepository;
import com.example.datn.repository.HoaDonChiTietRepository;
import com.example.datn.service.HoaDonChiTietService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    BienTheGiayRepository bienTheGiayRepository;

    @Override
    public ResponseEntity<?> save(HoaDonChiTietDto hoaDonChiTietDto) {
        if (giayRepository.findBySoLuong(hoaDonChiTietDto.getBienTheGiay()
                                                         .getGiay()
                                                         .getId()) < (hoaDonChiTietDto.getSoLuong())) {
            return ResponseEntity.badRequest()
                                 .body("Vuợt quá số lượng");
        } else if (giayRepository.findByTrangThai(hoaDonChiTietDto.getBienTheGiay()
                                                                  .getGiay()
                                                                  .getId()) == 1) {
            return ResponseEntity.badRequest()
                                 .body("Sản phẩm này đã hết hàng");
        } else {
            ModelMapper modelMapper = new ModelMapper();
            HoaDonChiTiet hoaDonChiTiet = modelMapper.map(hoaDonChiTietDto, HoaDonChiTiet.class);
            hoaDonChiTiet.setBienTheGiay(hoaDonChiTietDto.getBienTheGiay());
            hoaDonChiTiet.setHoaDon(hoaDonChiTietDto.getHoaDon());
//            BigDecimal gia = bienTheGiayRepository.findByGiaBan(hoaDonChiTietDto.getBienTheGiay()
//                                                                                .getId())
//                                                  .multiply(BigDecimal.valueOf(hoaDonChiTietDto.getSoLuong()));
//            hoaDonChiTiet.setGia(gia);
            int giay = giayRepository.findBySoLuong(hoaDonChiTietDto.getBienTheGiay()
                                                                    .getGiay()
                                                                    .getId());
            int soLuongGiay = giay - hoaDonChiTiet.getSoLuong();
            giayRepository.updateSoLuong(soLuongGiay, hoaDonChiTietDto.getBienTheGiay()
                                                                      .getGiay()
                                                                      .getId());

            HoaDonChiTiet addHDCT = hoaDonChiTietRepository.save(hoaDonChiTiet);
            HoaDonChiTietDto returnValue = modelMapper.map(addHDCT, HoaDonChiTietDto.class);
            return ResponseEntity.ok(returnValue);
        }
    }

    @Override
    public List<HoaDonChiTietDto> getAllByHoaDon(int id) {
        List<HoaDonChiTietDto> returnValue = new ArrayList<>();
        List<HoaDonChiTiet> hoaDonChiTietList = hoaDonChiTietRepository.getAll(id);
        BeanUtils.copyProperties(hoaDonChiTietList, returnValue);
        return returnValue;
    }

    @Override
    public ResponseEntity<?> update(HoaDonChiTietDto hoaDonChiTietDto, int id) {
        if (hoaDonChiTietDto.getHoaDon().getTrangThai() >= 2){
            return ResponseEntity.badRequest().body("Hết thời gian có thể sửa!!");
        }
        HoaDonChiTietDto returnValue = new HoaDonChiTietDto();
//        hoaDonChiTietRepository.update(hoaDonChiTietDto, id);
        HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietRepository.findById(id).get();
        BeanUtils.copyProperties(hoaDonChiTiet,returnValue);
        return ResponseEntity.ok(returnValue);
    }

}
