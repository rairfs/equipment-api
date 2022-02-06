package one.digitalinnovation.equipmentapi.mapper;

import one.digitalinnovation.equipmentapi.dto.request.EquipmentDTO;
import one.digitalinnovation.equipmentapi.entity.Equipment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EquipmentMapper {

    EquipmentMapper INSTANCE = Mappers.getMapper(EquipmentMapper.class);

    Equipment toModel(EquipmentDTO equipmentDTO);

    EquipmentDTO toDTO(Equipment equipment);
}
