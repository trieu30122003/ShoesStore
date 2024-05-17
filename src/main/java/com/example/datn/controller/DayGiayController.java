package com.example.datn.controller;

import com.example.datn.dto.DayGiayDto;
import com.example.datn.dto.DeGiayDto;
import com.example.datn.entity.DayGiay;
import com.example.datn.entity.DeGiay;
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
@RequestMapping("/api/day-giay")
public class DayGiayController {
    @Autowired
    BaseService<DayGiayDto, DayGiay> baseService;

    @GetMapping
    @Operation(summary = "getAll")
    public ResponseEntity<Page<DayGiay>> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                      @RequestParam(value = "size", defaultValue = "5") int size) {
        return ResponseEntity.ok(baseService.getAll(page, size));
    }

    @GetMapping("/{id}")
    @Operation(summary = "lấy ra 1 dây giày theo id")
    public DayGiayDto detOne(@PathVariable int id) {
        return baseService.getOne(id);
    }

    @PostMapping
    @Operation(summary = "thêm 1 dây giày")
    public ResponseEntity<DayGiayDto> create(@Valid @RequestBody DayGiayDto dayGiayDto) {
        return ResponseEntity.ok(baseService.save(dayGiayDto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "update theo id")
    public ResponseEntity<DayGiayDto> uodate(@Valid @PathVariable int id, @RequestBody DayGiayDto dayGiayDto) {
        return ResponseEntity.ok(baseService.update(dayGiayDto,id));
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
            returnValue.setOperationMessage("Xoa Thanh Cong.");
        } catch (Exception e){
            returnValue.setOperationResult(RequestOperationStatus.ERROR.name());
            returnValue.setOperationMessage("Lỗi khi xóa DayGiay: " + e.getMessage());
        }return returnValue;
    }

    @GetMapping("/search")
    @Operation(summary = "tìm kiếm theo tên")
    public ResponseEntity<Page<DayGiay>> search(@RequestParam(value = "name") String name,
                                               @RequestParam(value = "page", defaultValue = "0") int page,
                                               @RequestParam(value = "size", defaultValue = "5") int size){
        return ResponseEntity.ok(baseService.search(name,page,size));
    }
}
