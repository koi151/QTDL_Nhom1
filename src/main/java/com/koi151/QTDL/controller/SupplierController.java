package com.koi151.QTDL.controller;

import com.koi151.QTDL.model.request.SupplierRequest;
import com.koi151.QTDL.model.response.ResponseData;
import com.koi151.QTDL.service.SupplierService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    @PostMapping("/")
    public ResponseEntity<ResponseData> createSupplier(
        @RequestBody @NotNull @Valid SupplierRequest request
    ) {
        var accountCreated = supplierService.createSupplier(request);
        return new ResponseEntity<>(
            ResponseData.builder()
                .data(accountCreated)
                .desc("Tạo thành công nhà cung cấp " + request.getSupplierName())
                .build()
            , HttpStatus.CREATED);
    }

    @PatchMapping("/{supplierId}")
    public ResponseEntity<ResponseData> updateSupplier(@PathVariable Long supplierId,
                                                   @Valid @RequestBody SupplierRequest supplierRequest) {
        var updatedSupplier = supplierService.updateSupplier(supplierId, supplierRequest);
        return ResponseEntity.ok(ResponseData.builder()
            .data(updatedSupplier)
            .desc("Cập nhật thành công thông tin nhà cung cấp " + updatedSupplier.getSupplierName())
            .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseData> deleteSupplier (@PathVariable(name = "id") Long id ) {
        supplierService.deleteSupplier(id);

        return new ResponseEntity<>(
            ResponseData.builder()
                .desc("Xóa thành công nhà cung cấp với id: " + id)
                .build()
            , HttpStatus.OK);
    }
}
