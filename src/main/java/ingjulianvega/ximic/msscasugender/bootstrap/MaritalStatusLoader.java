package ingjulianvega.ximic.msscasugender.bootstrap;

import ingjulianvega.ximic.msscasugender.domain.GenderEntity;
import ingjulianvega.ximic.msscasugender.domain.repositories.GenderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@RequiredArgsConstructor
@Component
public class MaritalStatusLoader implements CommandLineRunner {

    private final GenderRepository genderRepository;

    @Override
    public void run(String... args) throws Exception {
        if (genderRepository.count() == 0) {
            loadMaritalStatusObjects();
        }
    }

    private void loadMaritalStatusObjects() {
        genderRepository.saveAll(Arrays.asList(
                GenderEntity.builder().name("Femenino").build(),
                GenderEntity.builder().name("Masculino").build(),
                GenderEntity.builder().name("Otro").build()
        ));
    }
}