package com.koi151.QTDL.controller;

import com.koi151.QTDL.model.request.AgencyCreateRequest;
import com.koi151.QTDL.model.response.ResponseData;
import com.koi151.QTDL.service.AgencyService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/agencies")
public class AgencyController {

    private final AgencyService agencyService;

    @PostMapping("/")
    public ResponseEntity<ResponseData> createAgency(
        @RequestBody @NotNull @Valid AgencyCreateRequest request
    ) {
        var accountCreated = agencyService.createAgency(request);
        return new ResponseEntity<>(
            ResponseData.builder()
                .data(accountCreated)
                .desc("Tạo thành công đại lý " + request.getAgencyName())
                .build()
            , HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseData> deleteAgency (@PathVariable(name = "id") Long id ) {
        agencyService.deleteAgency(id);

        return new ResponseEntity<>(
            ResponseData.builder()
                .desc("Xóa thành công đại lý với id: " + id)
                .build()
            , HttpStatus.OK);
    }
}