package one.digitalinnovation.equipmentapi.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import one.digitalinnovation.equipmentapi.dto.request.EquipmentDTO;
import one.digitalinnovation.equipmentapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.equipmentapi.entity.Equipment;
import one.digitalinnovation.equipmentapi.mapper.EquipmentMapper;
import one.digitalinnovation.equipmentapi.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class EquipmentService {


    private EquipmentRepository equipmentRepository;

    private final EquipmentMapper equipmentMapper = EquipmentMapper.INSTANCE;

    public MessageResponseDTO createEquipment(EquipmentDTO equipmentDTO){
        Equipment equipmentToSave = equipmentMapper.toModel(equipmentDTO);

        Equipment savedEquipment = equipmentRepository.save(equipmentToSave);
        return createMessageDTO("Created person with ID ", savedEquipment.getId());
    }

    public List<EquipmentDTO> listAllEquipments(){
        List<Equipment> allEquipments = equipmentRepository.findAll();
        return allEquipments.stream()
                .map(equipmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    private MessageResponseDTO createMessageDTO(String message, Long id) {
        return MessageResponseDTO.builder()
                .message(message + id)
                .build();
    }


}
