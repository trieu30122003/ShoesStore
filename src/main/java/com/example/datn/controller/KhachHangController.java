package com.example.datn.controller;

import com.example.datn.dto.KhachHangDto;
import com.example.datn.dto.KichThuocDto;
import com.example.datn.entity.KhachHang;
import com.example.datn.entity.KichThuoc;
import com.example.datn.filter.FilterKhachHang;
import com.example.datn.request.OperationStatusModel;
import com.example.datn.request.RequestOperationStatus;
import com.example.datn.service.KhachHangService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/khach-hang")
public class KhachHangController {
    @Autowired
    KhachHangService khachHangService;

    @GetMapping()
    public ResponseEntity<Page<KhachHang>> getAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                                  @RequestParam(value = "size", defaultValue = "5") int size){
        Page<KhachHang> returnValue = khachHangService.getAll(page, size);

        return ResponseEntity.ok(returnValue);
    }


    @GetMapping("/{id}")
    @Operation(summary = "lấy ra 1 khách hàng theo id")
    public KhachHangDto getOne(@PathVariable int id) {
        return khachHangService.getOne(id);
    }

    @PostMapping
    @Operation(summary = "thêm 1 khách hàng")
    public ResponseEntity<?> create(@Valid @RequestBody KhachHangDto khachHangDto){
        return ResponseEntity.ok(khachHangService.save(khachHangDto));
    }

    @PutMapping("/{id}")
    @Operation(summary = "update theo id")
    public ResponseEntity<?> update(@Valid @PathVariable int id, @RequestBody KhachHangDto khachHangDto) {
        return ResponseEntity.ok(khachHangService.update(khachHangDto,id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "xóa theo id")
    public OperationStatusModel delete(@PathVariable int id){
        OperationStatusModel returnValue = new OperationStatusModel();
        returnValue.setOperationName(RequestOperationName.DELETE.name());
        try {
            if (khachHangService.getOne(id).equals(null)){
                throw new IllegalArgumentException("Không tồn tại ID này");
            }
            khachHangService.delete(id);
            returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
            returnValue.setOperationMessage("Xoa Thanh Cong.");
        } catch (Exception e){
            returnValue.setOperationResult(RequestOperationStatus.ERROR.name());
            returnValue.setOperationMessage("Lỗi khi xóa KhachHang: " + e.getMessage());
        }return returnValue;
    }

    @GetMapping("/search")
    @Operation(summary = "tìm kiếm theo họ hoặc tên hoặc sdt")
    public ResponseEntity<Page<KhachHang>> search(@RequestParam(value = "name") String name,
                                                  @RequestParam(value = "page", defaultValue = "0") int page,
                                                  @RequestParam(value = "size", defaultValue = "5") int size){
        return ResponseEntity.ok(khachHangService.search(name,page,size));
    }

    @GetMapping("/filter")
    @Operation(summary = "filter theo giới tính, trạng thái, khoảng ngày sinh(LẤY JSON filterKhachHang PASTE VÀO ROW TRONG POSTMAN)(TEST BẰNG POSTMAN)")
    public ResponseEntity<Page<KhachHang>> filterKhachHang(@RequestBody FilterKhachHang filterKhachHang,
                                                  @RequestParam(value = "page", defaultValue = "0") int page,
                                                  @RequestParam(value = "size", defaultValue = "5") int size) throws Exception{
        return ResponseEntity.ok(khachHangService.filterKhachHang(filterKhachHang, page, size));
    }
}
