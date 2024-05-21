package com.example.datn.controller;

import com.example.datn.dto.*;
import com.example.datn.entity.BienTheGiay;
import com.example.datn.entity.ChatLieu;
import com.example.datn.filter.FilterBienThe;
import com.example.datn.request.OperationStatusModel;
import com.example.datn.request.RequestOperationStatus;
import com.example.datn.service.BaseService;
import com.example.datn.service.BienTheGiayService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bien-the-giay")
public class BienTheGiayController {
    @Autowired
    BienTheGiayService baseService;

    @GetMapping
    @Operation(summary = "lấy ra tất cả biến thể")
    public ResponseEntity<Page<BienTheGiay>> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                    @RequestParam(value = "size", defaultValue = "5") int size){
        return ResponseEntity.ok(baseService.getAll(page, size));
    }

    @GetMapping("/{id}")
    @Operation(summary = "lấy ra 1 biến thể theo id")
    public BienTheGiayDto getOne(@RequestBody MauSacDto ms,
                                 @RequestBody KichThuocDto kt,
                                 @RequestBody GiayDto g){
        return baseService.getOne(ms, kt, g);
    }

    @PostMapping
    @Operation(summary = "thêm 1 biến thể")
    public ResponseEntity<BienTheGiayDto> create(@Valid @RequestBody BienTheGiayDto bienTheGiayDto){
        return ResponseEntity.ok(baseService.save(bienTheGiayDto));
    }


    @PutMapping("/{id}")
    @Operation(summary = "update theo id")
    public ResponseEntity<BienTheGiayDto> updateChatLieu(@Valid @PathVariable int id, @RequestBody BienTheGiayDto bienTheGiayDto) {
        return ResponseEntity.ok(baseService.update(bienTheGiayDto,id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "xóa theo id")
    public OperationStatusModel delete(@PathVariable int id){
        OperationStatusModel returnValue = new OperationStatusModel();
        returnValue.setOperationName(RequestOperationName.DELETE.name());
        try {
            if (baseService.getOneById(id).equals(null)){
                throw new IllegalArgumentException("Không tồn tại ID này");
            }
            baseService.delete(id);
            returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
            returnValue.setOperationMessage("Xoa Thanh Cong.");
        } catch (Exception e){
            returnValue.setOperationResult(RequestOperationStatus.ERROR.name());
            returnValue.setOperationMessage("Lỗi khi xóa BienTheGiay: " + e.getMessage());
        }return returnValue;
    }

    @GetMapping("/search")
    @Operation(summary = "tìm kiếm theo tên")
    public ResponseEntity<Page<BienTheGiay>> search(@RequestParam(value = "name") String name,
                                                 @RequestParam(value = "page", defaultValue = "0") int page,
                                                 @RequestParam(value = "size", defaultValue = "5") int size){
        return ResponseEntity.ok(baseService.search(name,page,size));
    }

    @GetMapping("/filter")
    @Operation(summary = "filter test trong postman")
    public ResponseEntity<Page<BienTheGiay>> filter(@RequestBody FilterBienThe filterBienThe,@RequestParam(value = "page",defaultValue = "0") int page,@RequestParam(value = "size",defaultValue = "5") int size){
        return ResponseEntity.ok(baseService.filterBienThe(filterBienThe, page, size));
    }
}
