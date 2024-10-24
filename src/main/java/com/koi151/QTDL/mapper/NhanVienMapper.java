package com.koi151.QTDL.mapper;

import com.koi151.QTDL.entity.NhanVien;
import com.koi151.QTDL.model.dto.NhanVienCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NhanVienMapper {

    NhanVienCreateDTO toNhanVienDTO(NhanVien nv);
}
