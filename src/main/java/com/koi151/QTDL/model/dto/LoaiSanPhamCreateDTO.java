package com.koi151.QTDL.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoaiSanPhamCreateDTO {
    private Long maLoai;
    private String tenLoai;
}
