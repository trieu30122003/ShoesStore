package com.example.datn.controller;

import com.example.datn.dto.MauSacDto;
import com.example.datn.dto.NhanVienDto;
import com.example.datn.entity.MauSac;
import com.example.datn.entity.NhanVien;
import com.example.datn.request.OperationStatusModel;
import com.example.datn.request.RequestOperationStatus;
import com.example.datn.service.BaseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nhan-vien")
public class NhanVienController {
    @Autowired
    BaseService<NhanVienDto, NhanVien> baseService;

    @GetMapping
    @Operation(summary = "getAll")
    public ResponseEntity<Page<NhanVien>> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                      @RequestParam(value = "size", defaultValue = "5") int size) {
        return ResponseEntity.ok(baseService.getAll(page, size));
    }

    @GetMapping("/{id}")
    @Operation(summary = "lấy ra 1 nhân viên theo id")
    public NhanVienDto getOne(@PathVariable int id) {
        return baseService.getOne(id);
    }

    @PostMapping
    @Operation(summary = "thêm 1 nhân viên")
    public ResponseEntity<NhanVienDto> create(@RequestBody NhanVienDto nhanVienDto) {
        return ResponseEntity.ok(baseService.save(nhanVienDto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "update theo id")
    public ResponseEntity<NhanVienDto> update(@PathVariable int id, @RequestBody NhanVienDto nhanVienDto) {
        return ResponseEntity.ok(baseService.update(nhanVienDto, id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "xóa theo id")
    public OperationStatusModel delete(@PathVariable int id) {
        OperationStatusModel returnValue = new OperationStatusModel();
        returnValue.setOperationName(RequestOperationName.DELETE.name());
        try {
            if (baseService.getOne(id)
                           .equals(null)) {
                throw new IllegalArgumentException("Không tồn tại ID này");
            }
            baseService.delete(id);
            returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
            returnValue.setOperationMessage("Xoa Thanh Cong.");
        } catch (Exception e) {
            returnValue.setOperationResult(RequestOperationStatus.ERROR.name());
            returnValue.setOperationMessage("Lỗi khi xóa NhanVien: " + e.getMessage());
        }
        return returnValue;
    }

    @GetMapping("/search")
    @Operation(summary = "tìm kiếm theo tên hoặc họ hoặc sdt hoặc email hoặc mã")
    public ResponseEntity<Page<NhanVien>> search(@RequestParam(value = "name") String name,
                                               @RequestParam(value = "page", defaultValue = "0") int page,
                                               @RequestParam(value = "size", defaultValue = "5") int size) {
        return ResponseEntity.ok(baseService.search(name, page, size));
    }
}
