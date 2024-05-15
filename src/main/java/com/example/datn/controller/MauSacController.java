package com.example.datn.controller;

import com.example.datn.dto.MauSacDto;
import com.example.datn.entity.MauSac;
import com.example.datn.request.OperationStatusModel;
import com.example.datn.request.RequestOperationStatus;
import com.example.datn.service.BaseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mau-sac")
public class MauSacController {

    @Autowired
    BaseService<MauSacDto, MauSac> baseService;

    @GetMapping
    @Operation(summary = "getAll")
    public ResponseEntity<Page<MauSac>> getAllMauSacs(@RequestParam(value = "page", defaultValue = "0") int page,
                                                      @RequestParam(value = "size", defaultValue = "5") int size) {
        return ResponseEntity.ok(baseService.getAll(page, size));
    }

    @GetMapping("/{id}")
    @Operation(summary = "lấy ra 1 màu sắc theo id")
    public MauSacDto getMauSacById(@PathVariable int id) {
        return baseService.getOne(id);
    }

    @PostMapping
    @Operation(summary = "thêm 1 màu sắc")
    public ResponseEntity<MauSacDto> createMauSac(@RequestBody MauSacDto mauSacDto) {
        return ResponseEntity.ok(baseService.save(mauSacDto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "update theo id")
    public ResponseEntity<MauSacDto> updateMauSac(@PathVariable int id, @RequestBody MauSacDto mauSacDto) {
        return ResponseEntity.ok(baseService.update(mauSacDto, id));
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
            returnValue.setOperationMessage("Lỗi khi xóa MauSac: " + e.getMessage());
        }
        return returnValue;
    }

    @GetMapping("/search")
    @Operation(summary = "tìm kiếm theo tên")
    public ResponseEntity<Page<MauSac>> search(@RequestParam(value = "name") String name,
                                               @RequestParam(value = "page", defaultValue = "0") int page,
                                               @RequestParam(value = "size", defaultValue = "5") int size) {
        return ResponseEntity.ok(baseService.search(name, page, size));
    }
}
