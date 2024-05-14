package com.example.datn.controller;

import com.example.datn.dto.ChatLieuDto;
import com.example.datn.entity.ChatLieu;
import com.example.datn.request.OperationStatusModel;
import com.example.datn.request.RequestOperationStatus;
import com.example.datn.service.BaseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chatlieu")
public class ChatLieuController {
    @Autowired
    BaseService<ChatLieuDto, ChatLieu> baseService;

    @GetMapping
    public ResponseEntity<Page<ChatLieu>> getAllChatLieus(@RequestParam(value = "page", defaultValue = "0") int page,
                                                          @RequestParam(value = "size", defaultValue = "5") int size) {
        return ResponseEntity.ok(baseService.getAll(page, size));
    }

    @GetMapping("/{id}")
    @Operation(summary = "lấy ra 1 chất liệu theo id")
    public ChatLieuDto getChatLieuById(@PathVariable int id) {
        return baseService.getOne(id);
    }

    @PostMapping
    @Operation(summary = "thêm 1 chất liệu")
    public ResponseEntity<ChatLieuDto> createChatLieu(@RequestBody ChatLieuDto chatlieu) {
        return ResponseEntity.ok(baseService.save(chatlieu));
    }

    @PutMapping("/{id}")
    @Operation(summary = "update theo id")
    public ResponseEntity<ChatLieuDto> updateChatLieu(@PathVariable int id, @RequestBody ChatLieuDto chatLieuDto) {
        return ResponseEntity.ok(baseService.update(chatLieuDto,id));
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
            returnValue.setOperationMessage("Lỗi khi xóa ChatLieu: " + e.getMessage());
        }return returnValue;
    }

    @GetMapping("/search")
    public ResponseEntity<Page<ChatLieu>> search(@RequestParam(value = "name") String name,
                                 @RequestParam(value = "page", defaultValue = "0") int page,
                                 @RequestParam(value = "size", defaultValue = "5") int size){
        return ResponseEntity.ok(baseService.search(name,page,size));
    }
}
