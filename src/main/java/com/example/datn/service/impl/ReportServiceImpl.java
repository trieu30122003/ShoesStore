package com.example.datn.service.impl;

import com.example.datn.dto.BienTheGiayDto;
import com.example.datn.dto.HoaDonChiTietDto;
import com.example.datn.entity.BienTheGiay;
import com.example.datn.entity.HoaDonChiTiet;
import com.example.datn.repository.BienTheGiayRepository;
import com.example.datn.repository.HoaDonChiTietRepository;
import com.example.datn.service.ReportService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    BienTheGiayRepository bienTheGiayRepository;

    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository;

    @Override
    public int countProductIn(Date start, Date end) {
        return bienTheGiayRepository.productIn(start, end);
    }

    @Override
    public List<BienTheGiayDto> listProductIn(Date start, Date end) {
        List<BienTheGiayDto> returnValue = new ArrayList<>();
        List<BienTheGiay> list = bienTheGiayRepository.listProductIn(start, end);
        for (BienTheGiay bienTheGiay : list){
            BienTheGiayDto bienTheGiayDto = new BienTheGiayDto();
            BeanUtils.copyProperties(bienTheGiay, bienTheGiayDto);
            returnValue.add(bienTheGiayDto);
        }
        return returnValue;
    }

    @Override
    public int countProductOut(Date start, Date end) {
        if (hoaDonChiTietRepository.check()!=0){
            return hoaDonChiTietRepository.sumProductOut(start, end);
        }else {
            return 0;
        }
    }

    @Override
    public List<HoaDonChiTietDto> listProductOut(Date start, Date end) {
        List<HoaDonChiTietDto> returnValue = new ArrayList<>();
        List<HoaDonChiTiet> list = hoaDonChiTietRepository.listProductOut(start,end);
        for (HoaDonChiTiet hoaDonChiTiet : list){
            HoaDonChiTietDto hoaDonChiTietDto = new HoaDonChiTietDto();
            BeanUtils.copyProperties(hoaDonChiTiet,hoaDonChiTietDto);
            returnValue.add(hoaDonChiTietDto);
        }
        return returnValue;
    }
}
