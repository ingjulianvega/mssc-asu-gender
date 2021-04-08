package ingjulianvega.ximic.msscasugender.web.controller;

import ingjulianvega.ximic.msscasugender.services.GenderService;
import ingjulianvega.ximic.msscasugender.web.model.Gender;
import ingjulianvega.ximic.msscasugender.web.model.GenderDto;
import ingjulianvega.ximic.msscasugender.web.model.GenderList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class GenderController implements GenderI{

    private final GenderService genderService;

    @Override
    public ResponseEntity<GenderList> get() {
        return new ResponseEntity<>(genderService.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<GenderDto> getById(UUID id) {
        return new ResponseEntity<>(genderService.getById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> create(Gender gender) {
        genderService.create(gender);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> updateById(UUID id, Gender gender) {
        genderService.updateById(id, gender);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteById(UUID id) {
        genderService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
