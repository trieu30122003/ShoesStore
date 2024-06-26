package com.example.datn.controller;

import com.example.datn.dto.ThuongHieuDto;
import com.example.datn.entity.ThuongHieu;
import com.example.datn.request.OperationStatusModel;
import com.example.datn.request.RequestOperationStatus;
import com.example.datn.service.BaseService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/thuong-hieu")
public class ThuongHieuController {
    @Autowired
    BaseService<ThuongHieuDto, ThuongHieu> baseService;

    @GetMapping()
    @Operation(summary = "lấy tất cả thương hiệu")
    public ResponseEntity<Page<ThuongHieu>> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                   @RequestParam(value = "size", defaultValue = "5") int size){
        return ResponseEntity.ok(baseService.getAll(page, size));
    }

    @GetMapping("/{id}")
    @Operation(summary = "lấy ra 1 thương hiệu theo id")
    public ThuongHieuDto getOne(@PathVariable int id) {
        return baseService.getOne(id);
    }

    @PostMapping
    @Operation(summary = "thêm 1 thương hiệu")
    public ResponseEntity<ThuongHieuDto> create(@Valid @RequestBody ThuongHieuDto thuongHieuDto) {
        return ResponseEntity.ok(baseService.save(thuongHieuDto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "update theo id")
    public ResponseEntity<ThuongHieuDto> update(@Valid @PathVariable int id, @RequestBody ThuongHieuDto thuongHieuDto) {
        return ResponseEntity.ok(baseService.update(thuongHieuDto, id));
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
            returnValue.setOperationMessage("Lỗi khi xóa ThuongHieu: " + e.getMessage());
        }
        return returnValue;
    }

    @GetMapping("/search")
    @Operation(summary = "tìm kiếm theo tên")
    public ResponseEntity<Page<ThuongHieu>> search(@RequestParam(value = "name") String name,
                                                @RequestParam(value = "page", defaultValue = "0") int page,
                                                @RequestParam(value = "size", defaultValue = "5") int size) {
        return ResponseEntity.ok(baseService.search(name, page, size));
    }
}
