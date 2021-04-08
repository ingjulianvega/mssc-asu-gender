package ingjulianvega.ximic.msscasugender.services;

import ingjulianvega.ximic.msscasugender.web.model.Gender;
import ingjulianvega.ximic.msscasugender.web.model.GenderDto;
import ingjulianvega.ximic.msscasugender.web.model.GenderList;

import java.util.UUID;

public interface GenderService {
    GenderList get();

    GenderDto getById(UUID id);

    void create(Gender gender);

    void updateById(UUID id, Gender gender);

    void deleteById(UUID id);
}
