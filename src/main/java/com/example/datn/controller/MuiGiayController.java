package com.example.datn.controller;

import com.example.datn.dto.LotGiayDto;
import com.example.datn.dto.MuiGiayDto;
import com.example.datn.entity.LotGiay;
import com.example.datn.entity.MuiGiay;
import com.example.datn.request.OperationStatusModel;
import com.example.datn.request.RequestOperationStatus;
import com.example.datn.service.BaseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mui-giay")
public class MuiGiayController {
    @Autowired
    BaseService<MuiGiayDto, MuiGiay> baseService;

    @GetMapping
    @Operation(summary = "getAll")
    public ResponseEntity<Page<MuiGiay>> getAllMuiGiays(@RequestParam(value = "page", defaultValue = "0") int page,
                                                        @RequestParam(value = "size", defaultValue = "5") int size) {
        return ResponseEntity.ok(baseService.getAll(page, size));
    }

    @GetMapping("/{id}")
    @Operation(summary = "lấy ra 1 mũi giày theo id")
    public MuiGiayDto getMuiGiayById(@PathVariable int id) {
        return baseService.getOne(id);
    }

    @PostMapping
    @Operation(summary = "thêm 1 mũi giày")
    public ResponseEntity<MuiGiayDto> createMuiGiay(@RequestBody MuiGiayDto muiGiayDto) {
        return ResponseEntity.ok(baseService.save(muiGiayDto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "update theo id")
    public ResponseEntity<MuiGiayDto> updateMuiGiay(@PathVariable int id, @RequestBody MuiGiayDto muiGiayDto) {
        return ResponseEntity.ok(baseService.update(muiGiayDto, id));
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
            returnValue.setOperationMessage("Lỗi khi xóa MuiGiay: " + e.getMessage());
        }
        return returnValue;
    }

    @GetMapping("/search")
    @Operation(summary = "tìm kiếm theo tên")
    public ResponseEntity<Page<MuiGiay>> search(@RequestParam(value = "name") String name,
                                                @RequestParam(value = "page", defaultValue = "0") int page,
                                                @RequestParam(value = "size", defaultValue = "5") int size) {
        return ResponseEntity.ok(baseService.search(name, page, size));
    }
}
