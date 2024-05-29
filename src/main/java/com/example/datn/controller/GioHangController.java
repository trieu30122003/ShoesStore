package com.example.datn.controller;

import com.example.datn.dto.GioHangDto;
import com.example.datn.entity.GioHang;
import com.example.datn.request.OperationStatusModel;
import com.example.datn.request.RequestOperationStatus;
import com.example.datn.service.BaseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/gio-hang")
public class GioHangController {
    @Autowired
    BaseService<GioHangDto, GioHang> baseService;

    @GetMapping
    public ResponseEntity<Page<GioHang>> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                @RequestParam(value = "size", defaultValue = "5") int size){
        return ResponseEntity.ok(baseService.getAll(page, size));
    }

    @GetMapping("/{id}")
    public GioHangDto getOne(@PathVariable int id){
        return baseService.getOne(id);
    }

    @PostMapping
    public ResponseEntity<GioHangDto> save(@RequestBody GioHangDto gioHangDto){
        return ResponseEntity.ok(baseService.save(gioHangDto));
    }
    @DeleteMapping("/{id}")
    @Operation(summary = "xóa theo id")
    public OperationStatusModel delete(@PathVariable int id){
        OperationStatusModel returnValue = new OperationStatusModel();
        returnValue.setOperationName(RequestOperationName.DELETE.name());
        try {
            if (baseService.getOne(id).equals(null)){
                throw new IllegalArgumentException("Không tồn tại ID này");
            }
            baseService.delete(id);
            returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
            returnValue.setOperationMessage("Xóa thành công.");
        } catch (Exception e){
            returnValue.setOperationResult(RequestOperationStatus.ERROR.name());
            returnValue.setOperationMessage("Lỗi khi xóa giỏ hàng: " + e.getMessage());
        }return returnValue;
    }
}
