package com.koi151.QTDL.controller;

import com.koi151.QTDL.model.request.DaiLyCreateRequest;
import com.koi151.QTDL.model.response.ResponseData;
import com.koi151.QTDL.service.DaiLyService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/dai-ly")
public class DaiLyController {

    private final DaiLyService daiLyService;

    @PostMapping("/")
    public ResponseEntity<ResponseData> taoDaiLy(
        @RequestBody @NotNull @Valid DaiLyCreateRequest request
    ) {
        var accountCreated = daiLyService.taoDaiLy(request);
        return new ResponseEntity<>(
            ResponseData.builder()
                .data(accountCreated)
                .desc("Tạo thành công đại lý " + request.getTenDL())
                .build()
            , HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseData> xoaDaiLy (@PathVariable(name = "id") Long id ) {
        daiLyService.xoaDaiLy(id);

        return new ResponseEntity<>(
            ResponseData.builder()
                .desc("Xóa thành công đại lý với id: " + id)
                .build()
            , HttpStatus.OK);
    }
}
