package com.koi151.QTDL.service.impl;

import com.koi151.QTDL.customExceptions.EntityNotExistedException;
import com.koi151.QTDL.entity.DaiLy;
import com.koi151.QTDL.mapper.DaiLyMapper;
import com.koi151.QTDL.model.dto.DaiLyCreateDTO;
import com.koi151.QTDL.model.request.DaiLyCreateRequest;
import com.koi151.QTDL.repository.DaiLyRepository;
import com.koi151.QTDL.service.DaiLyService;
import com.koi151.QTDL.validator.DaiLyValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DaiLyServiceImpl implements DaiLyService {

    private final DaiLyRepository daiLyRepository;
    private final DaiLyMapper daiLyMapper;
    private final DaiLyValidator daiLyValidator;

    @Override
    @Transactional
    public DaiLyCreateDTO taoDaiLy(DaiLyCreateRequest request) {
        daiLyValidator.validateDaiLy(request);

        DaiLy daiLy = DaiLy.builder()
            .tenDL(request.getTenDL())
            .diaChi(request.getDiaChi())
            .nguoiDaiDien(request.getNguoiDaiDien())
            .sdt(request.getSdt())
            .build();

        DaiLy savedDaiLyEntity = daiLyRepository.save(daiLy);
        return daiLyMapper.toDaiLyCreateDTO(savedDaiLyEntity);
    }

    @Override
    public void xoaDaiLy(Long id) {
        DaiLy dl = daiLyRepository.findById(id)
            .orElseThrow(() -> new EntityNotExistedException("Không tìm thấy đại lý với id: " + id));

        dl.setDaXoa(true);
        daiLyRepository.save(dl);
    }
}
