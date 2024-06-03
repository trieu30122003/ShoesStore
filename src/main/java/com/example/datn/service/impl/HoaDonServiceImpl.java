package com.example.datn.service.impl;

import com.example.datn.dto.HoaDonChiTietDto;
import com.example.datn.dto.HoaDonDto;
import com.example.datn.entity.Giay;
import com.example.datn.entity.HoaDon;
import com.example.datn.entity.HoaDonChiTiet;
import com.example.datn.repository.GiayRepository;
import com.example.datn.repository.HoaDonChiTietRepository;
import com.example.datn.repository.HoaDonRepository;
import com.example.datn.repository.KhachHangRepository;
import com.example.datn.service.HoaDonService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    HoaDonRepository hoaDonRepository;

    @Autowired
    GiayRepository giayRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    HoaDonChiTietRepository hoaDonChiTietRepository;

    @Autowired
    KhachHangRepository khachHangRepository;

    @Autowired
    OtpStorageService otpStorageService;



    @Override
    public Page<HoaDon> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<HoaDon> returnValue = hoaDonRepository.findAll(pageable);

        return returnValue;
    }

    @Override
    public ResponseEntity save(HoaDonDto hoaDonDto, int maDH, String otp) {
        if (khachHangRepository.findByMaDatHang(hoaDonDto.getKhachHang()
                                                         .getId()) == maDH) {
            if (otpStorageService.validateOtp(hoaDonDto.getKhachHang()
                                                       .getSdt(), otp)) {
                otpStorageService.removeOtp(hoaDonDto.getKhachHang()
                                                     .getSdt());
                ModelMapper modelMapper = new ModelMapper();
                HoaDon hoaDon = modelMapper.map(hoaDonDto, HoaDon.class);
                hoaDon.setKhachHang(hoaDonDto.getKhachHang());
                hoaDon.setNhanVien(hoaDonDto.getNhanVien());


                HoaDon addHD = hoaDonRepository.save(hoaDon);

                HoaDonDto returnValue = modelMapper.map(addHD, HoaDonDto.class);
                if (returnValue != null) {
                    String to = hoaDonDto.getKhachHang()
                                         .getEmail();
                    String subject = "Đơn hàng " + hoaDonDto.getMa();
                    String text = "Dear " + hoaDonDto.getKhachHang()
                                                     .getTen() + " chúng tôi sẽ gửi đơn hàng cho bạn vào ngày " + hoaDonDto.getNgayGiao() + " đến địa chỉ là: " + hoaDonDto.getDiaChi();
                    emailService.sendEmail(to, subject, text);
                }
                return ResponseEntity.ok(returnValue);
            } else {
                return ResponseEntity.badRequest()
                                     .body("Sai OTP");
            }
        } else {
            return ResponseEntity.badRequest()
                                 .body("Sai mật khẩu");
        }
    }

    @Override
    public HoaDonDto choXacNhan(int id) {
        HoaDonDto returnValue = new HoaDonDto();
        hoaDonRepository.choXacNhan(id);


        HoaDon hoaDon = hoaDonRepository.findById(id)
                                        .get();
        BeanUtils.copyProperties(hoaDon, returnValue);
        return returnValue;
    }

    @Override
    public HoaDonDto xacNhan(int id) {
        HoaDonDto returnValue = new HoaDonDto();
        hoaDonRepository.xacNhan(id);
        HoaDon hoaDon = hoaDonRepository.findById(id)
                                        .get();
        BeanUtils.copyProperties(hoaDon, returnValue);
        return returnValue;
    }

    @Override
    public HoaDonDto dangGiao(int id) {
        HoaDonDto returnValue = new HoaDonDto();
        hoaDonRepository.dangGiao(id);

        HoaDon hoaDon = hoaDonRepository.findById(id)
                                        .get();
        BeanUtils.copyProperties(hoaDon, returnValue);
        return returnValue;
    }

    @Override
    public HoaDonDto daGiao(int id) {
        HoaDonDto returnValue = new HoaDonDto();
        hoaDonRepository.daGiao(id);

        HoaDon hoaDon = hoaDonRepository.findById(id)
                                        .get();
        BeanUtils.copyProperties(hoaDon, returnValue);
        return returnValue;
    }

    @Override
    public HoaDonDto daHuy(int id) {
        HoaDonDto returnValue = new HoaDonDto();
        hoaDonRepository.daHuy(id);

        HoaDon hoaDon = hoaDonRepository.findById(id)
                                        .get();
        BeanUtils.copyProperties(hoaDon, returnValue);
        return returnValue;
    }

    @Override
    public HoaDonDto daNhan(int id) {
        HoaDonDto returnValue = new HoaDonDto();
        hoaDonRepository.daNhan(id);

        HoaDon hoaDon = hoaDonRepository.findById(id)
                                        .get();
        BeanUtils.copyProperties(hoaDon, returnValue);
        return returnValue;
    }

    @Override
    public HoaDonDto update(HoaDonDto hoaDonDto, int id) {
        HoaDonDto returnValue = new HoaDonDto();

        hoaDonRepository.update(hoaDonDto, id);

        HoaDon hoaDon = hoaDonRepository.findById(id)
                                        .get();
        BeanUtils.copyProperties(hoaDon, returnValue);
        return returnValue;
    }

}
