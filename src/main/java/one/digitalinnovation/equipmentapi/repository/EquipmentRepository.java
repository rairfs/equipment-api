package one.digitalinnovation.equipmentapi.repository;

import one.digitalinnovation.equipmentapi.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment, Long> {

}
