package com.koi151.QTDL.service.impl;

import com.koi151.QTDL.customExceptions.InvalidRequestException;
import com.koi151.QTDL.entity.LoaiSanPham;
import com.koi151.QTDL.mapper.LoaiSanPhamMapper;
import com.koi151.QTDL.model.dto.LoaiSanPhamCreateDTO;
import com.koi151.QTDL.model.request.LoaiSanPhamCreateRequest;
import com.koi151.QTDL.repository.LoaiSanPhamRepository;
import com.koi151.QTDL.service.LoaiSanPhamService;
import com.koi151.QTDL.validator.LoaiSanPhamValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService {

    private final LoaiSanPhamRepository loaiSanPhamRepository;
    private final LoaiSanPhamMapper loaiSanPhamMapper;
    private final LoaiSanPhamValidator loaiSanPhamValidator;

    @Override
    public LoaiSanPhamCreateDTO taoLoaiSP(LoaiSanPhamCreateRequest request) {
        loaiSanPhamValidator.validateLoaiSanPham(request);
        LoaiSanPham loaiSP = LoaiSanPham.builder()
            .tenLoai(request.getTenLoai())
            .build();

        LoaiSanPham loaiSPsaved = loaiSanPhamRepository.save(loaiSP);
        return loaiSanPhamMapper.toLoaiSanPhamDTO(loaiSPsaved);
    }
}