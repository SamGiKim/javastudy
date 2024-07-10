package com.studymavenspringboot1.rentcar.vehicletype;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleTypeJpaRepository extends JpaRepository<VehicleTypeEntity, Long > {
    List<VehicleTypeEntity> findAllByTypeContains(String type);
    Optional<VehicleTypeEntity> findByType(String type);
}
