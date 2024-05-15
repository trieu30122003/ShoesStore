package com.example.datn.controller;

import com.example.datn.dto.ChatLieuDto;
import com.example.datn.dto.CoGiayDto;
import com.example.datn.entity.ChatLieu;
import com.example.datn.entity.CoGiay;
import com.example.datn.request.OperationStatusModel;
import com.example.datn.request.RequestOperationStatus;
import com.example.datn.service.BaseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/co-giay")
public class CoGiayCotroller {
    @Autowired
    BaseService<CoGiayDto, CoGiay> baseService;

    @GetMapping
    @Operation(summary = "getAll")
    public ResponseEntity<Page<CoGiay>> getAllCoGiays(@RequestParam(value = "page", defaultValue = "0") int page,
                                                          @RequestParam(value = "size", defaultValue = "5") int size) {
        return ResponseEntity.ok(baseService.getAll(page, size));
    }

    @GetMapping("/{id}")
    @Operation(summary = "lấy ra 1 cổ giày theo id")
    public CoGiayDto getCoGiayById(@PathVariable int id) {
        return baseService.getOne(id);
    }

    @PostMapping
    @Operation(summary = "thêm 1 cổ giày")
    public ResponseEntity<CoGiayDto> createCoGiay(@RequestBody CoGiayDto coGiayDto) {
        return ResponseEntity.ok(baseService.save(coGiayDto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "update theo id")
    public ResponseEntity<CoGiayDto> updateCoGiay(@PathVariable int id, @RequestBody CoGiayDto coGiayDto) {
        return ResponseEntity.ok(baseService.update(coGiayDto,id));
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
            returnValue.setOperationMessage("Lỗi khi xóa CoGiay: " + e.getMessage());
        }return returnValue;
    }

    @GetMapping("/search")
    @Operation(summary = "tìm kiếm theo tên")
    public ResponseEntity<Page<CoGiay>> search(@RequestParam(value = "name") String name,
                                                 @RequestParam(value = "page", defaultValue = "0") int page,
                                                 @RequestParam(value = "size", defaultValue = "5") int size){
        return ResponseEntity.ok(baseService.search(name,page,size));
    }
}
