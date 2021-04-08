package ingjulianvega.ximic.msscasugender.web.Mappers;


import ingjulianvega.ximic.msscasugender.domain.GenderEntity;
import ingjulianvega.ximic.msscasugender.web.model.GenderDto;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(uses = DateMapper.class)
public interface GenderMapper {
    GenderDto genderEntityToGenderDto(GenderEntity genderEntity);

    GenderEntity genderDtoToGenderEntity(GenderDto genderDto);

    ArrayList<GenderDto> genderEntityListToGenderDtoList(List<GenderEntity> genderEntityList);
}
