package ingjulianvega.ximic.msscasugender.services;

import ingjulianvega.ximic.msscasugender.configuration.ErrorCodeMessages;
import ingjulianvega.ximic.msscasugender.domain.GenderEntity;
import ingjulianvega.ximic.msscasugender.domain.repositories.GenderRepository;
import ingjulianvega.ximic.msscasugender.exception.GenderException;
import ingjulianvega.ximic.msscasugender.web.Mappers.GenderMapper;
import ingjulianvega.ximic.msscasugender.web.model.Gender;
import ingjulianvega.ximic.msscasugender.web.model.GenderDto;
import ingjulianvega.ximic.msscasugender.web.model.GenderList;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class GenderServiceImpl implements GenderService {

    private final GenderRepository genderRepository;
    private final GenderMapper genderMapper;

    @Cacheable(cacheNames = "genderListCache")
    @Override
    public GenderList get() {
        log.debug("get()...");
        return GenderList
                .builder()
                .genderList(genderMapper.genderEntityListToGenderDtoList(genderRepository.findAllByOrderByName()))
                .build();
    }

    @Cacheable(cacheNames = "genderCache")
    @Override
    public GenderDto getById(UUID id) {
        log.debug("getById()...");
        return genderMapper.genderEntityToGenderDto(
                genderRepository.findById(id).orElseThrow(() -> new GenderException(ErrorCodeMessages.MARITAL_STATUS_NOT_FOUND, "")));
    }

    @Override
    public void create(Gender gender) {
        log.debug("create()...");
        genderMapper.genderEntityToGenderDto(
                genderRepository.save(
                        genderMapper.genderDtoToGenderEntity(
                                GenderDto
                                        .builder()
                                        .name(gender.getName()).
                                        build())));
    }

    @Override
    public void updateById(UUID id, Gender gender) {
        log.debug("updateById...");
        GenderEntity genderEntity = genderRepository.findById(id).orElseThrow(() -> new GenderException(ErrorCodeMessages.MARITAL_STATUS_NOT_FOUND, ""));
        genderEntity.setName(gender.getName());

        genderRepository.save(genderEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        genderRepository.deleteById(id);
    }
}
