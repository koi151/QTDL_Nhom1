package com.koi151.QTDL.mapper;

import com.koi151.QTDL.entity.ProductCategory;
import com.koi151.QTDL.model.dto.ProductCategoryCreateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductCategoryMapper {

    ProductCategoryCreateDTO toCategoryDTO(ProductCategory loaiSP);
}