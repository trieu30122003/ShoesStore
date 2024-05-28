package com.example.datn.service.impl;

import com.example.datn.dto.BienTheGiayDto;
import com.example.datn.dto.GiayDto;
import com.example.datn.dto.KichThuocDto;
import com.example.datn.dto.MauSacDto;
import com.example.datn.entity.BienTheGiay;
import com.example.datn.filter.FilterBienThe;
import com.example.datn.repository.BienTheGiayRepository;
import com.example.datn.service.BienTheGiayService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BienTheGiayServiceImpl implements BienTheGiayService {

    @Autowired
    BienTheGiayRepository bienTheGiayRepository;

    @Override
    public Page<BienTheGiay> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<BienTheGiay> returnValue = bienTheGiayRepository.findAll(pageable);
        return returnValue;
    }

    @Override
    public BienTheGiayDto getOne(MauSacDto ms, KichThuocDto kt, GiayDto g) {
        BienTheGiayDto returnValue = new BienTheGiayDto();
        BienTheGiay bienTheGiay = bienTheGiayRepository.bienThe(ms,kt,g);
        BeanUtils.copyProperties(bienTheGiay, returnValue);
        return returnValue;
    }

    @Override
    public BienTheGiayDto getOneById(int id) {
        BienTheGiayDto returnValue = new BienTheGiayDto();
        BienTheGiay bienTheGiay = bienTheGiayRepository.findById(id).get();
        BeanUtils.copyProperties(bienTheGiay, returnValue);
        return returnValue;
    }

    @Override
    public ResponseEntity save(BienTheGiayDto bienTheGiayDto) {
        if (bienTheGiayRepository.findByMa(bienTheGiayDto.getMa()) != null) {
//            throw new BienTheGiayException("Mã " + bienTheGiayDto.getMa() + " đã tồn tại trong hệ thống");
            return ResponseEntity.badRequest().body("Mã " + bienTheGiayDto.getMa() + " đã tồn tại trong hệ thống");
        }

        ModelMapper modelMapper = new ModelMapper();
        BienTheGiay bienTheGiay = modelMapper.map(bienTheGiayDto, BienTheGiay.class);

        bienTheGiay.setKichThuoc(bienTheGiayDto.getKichThuoc());
        bienTheGiay.setMauSac(bienTheGiayDto.getMauSac());
        bienTheGiay.setGiay(bienTheGiayDto.getGiay());

        BienTheGiay addBienThe = bienTheGiayRepository.save(bienTheGiay);
        BienTheGiayDto returnValue = modelMapper.map(addBienThe, BienTheGiayDto.class);

        return ResponseEntity.ok(returnValue);
    }

    @Override
    public ResponseEntity update(BienTheGiayDto bienTheGiayDto, int id) {
        if (bienTheGiayRepository.findById(id) == null) {
            ResponseEntity.badRequest().body(("id " + id + " chưa có trong hệ thống"));
        }
        bienTheGiayRepository.update(bienTheGiayDto, id);

        BienTheGiayDto returnValue = new BienTheGiayDto();
        BienTheGiay bienTheGiay = bienTheGiayRepository.findById(id)
                                                       .get();
        BeanUtils.copyProperties(bienTheGiay, returnValue);
        return ResponseEntity.ok(returnValue);
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

    @Override
    public Page<BienTheGiay> filterBienThe(FilterBienThe filterBienThe, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<BienTheGiay> returnValue = bienTheGiayRepository.filterBienThe(filterBienThe, pageable);
        return returnValue;
    }
}
