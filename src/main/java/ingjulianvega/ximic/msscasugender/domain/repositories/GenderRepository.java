package ingjulianvega.ximic.msscasugender.domain.repositories;

import ingjulianvega.ximic.msscasugender.domain.GenderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface GenderRepository extends JpaRepository<GenderEntity, UUID>, JpaSpecificationExecutor<GenderEntity> {
}
