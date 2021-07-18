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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
@Service
public class GenderServiceImpl implements GenderService {

    private final GenderRepository genderRepository;
    private final GenderMapper genderMapper;

    @Cacheable(cacheNames = "genderListCache", condition = "#usingCache == false")
    @Override
    public GenderList get(Boolean usingCache) {
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
                genderRepository.findById(id).orElseThrow(() -> GenderException
                        .builder()
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .apiCode(ErrorCodeMessages.GENDER_NOT_FOUND_API_CODE)
                        .error(ErrorCodeMessages.GENDER_NOT_FOUND_ERROR)
                        .message(ErrorCodeMessages.GENDER_NOT_FOUND_MESSAGE)
                        .solution(ErrorCodeMessages.GENDER_NOT_FOUND_SOLUTION)
                        .build()));
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
        GenderEntity genderEntity = genderRepository.findById(id).orElseThrow(() -> GenderException
                .builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .apiCode(ErrorCodeMessages.GENDER_NOT_FOUND_API_CODE)
                .error(ErrorCodeMessages.GENDER_NOT_FOUND_ERROR)
                .message(ErrorCodeMessages.GENDER_NOT_FOUND_MESSAGE)
                .solution(ErrorCodeMessages.GENDER_NOT_FOUND_SOLUTION)
                .build());
        genderEntity.setName(gender.getName());

        genderRepository.save(genderEntity);
    }

    @Override
    public void deleteById(UUID id) {
        log.debug("deleteById...");
        genderRepository.deleteById(id);
    }
}
