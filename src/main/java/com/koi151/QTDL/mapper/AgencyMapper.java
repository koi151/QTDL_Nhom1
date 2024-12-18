package com.koi151.QTDL.mapper;

import com.koi151.QTDL.entity.Agency;
import com.koi151.QTDL.model.dto.AgencyDTO;
import com.koi151.QTDL.model.request.create.AgencyCreateRequest;
import com.koi151.QTDL.model.request.update.AgencyUpdateRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AgencyMapper {
    AgencyDTO toAgencyDTO(Agency agency);

    @BeanMapping(
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS
    )
    Agency updateAgencyFromRequest(AgencyUpdateRequest request, @MappingTarget Agency category);

}
