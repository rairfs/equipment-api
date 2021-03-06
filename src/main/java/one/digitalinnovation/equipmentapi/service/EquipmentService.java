package one.digitalinnovation.equipmentapi.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import one.digitalinnovation.equipmentapi.dto.request.EquipmentDTO;
import one.digitalinnovation.equipmentapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.equipmentapi.entity.Equipment;
import one.digitalinnovation.equipmentapi.exceptions.EquipmentNotFoundException;
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

    public EquipmentDTO createEquipment(EquipmentDTO equipmentDTO){
        Equipment equipmentToSave = equipmentMapper.toModel(equipmentDTO);
        Equipment createdEquipment = equipmentRepository.save(equipmentToSave);
        return equipmentMapper.toDTO(createdEquipment);
    }

    public List<EquipmentDTO> listAllEquipments(){
        List<Equipment> allEquipments = equipmentRepository.findAll();
        return allEquipments.stream()
                .map(equipmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EquipmentDTO findById(Long id) throws EquipmentNotFoundException {
        Equipment equipment = verifyIfExists(id);

        return equipmentMapper.toDTO(equipment);
    }

    public MessageResponseDTO updateById(Long id, EquipmentDTO equipmentDTO) throws EquipmentNotFoundException {
        verifyIfExists(id);

        Equipment equipmentToUpdate = equipmentMapper.toModel(equipmentDTO);
        Equipment updatedEquipment = equipmentRepository.save(equipmentToUpdate);
        return createMessageDTO("Updated equipment with ID ", updatedEquipment.getId());
    }

    public void delete(Long id) throws EquipmentNotFoundException {
        verifyIfExists(id);
        equipmentRepository.deleteById(id);
    }

    public EquipmentDTO incrementQuantity(Long id, int quantity) throws EquipmentNotFoundException {
        Equipment equipmentToIncrement = verifyIfExists(id);
        int oldEquipmentValue = equipmentToIncrement.getQuantity();
        int actualEquipmentValue = oldEquipmentValue + quantity;
        equipmentToIncrement.setQuantity(actualEquipmentValue);
        return equipmentMapper.toDTO(equipmentToIncrement);
    }

    public EquipmentDTO decrementQuantity(Long id, int quantity) throws EquipmentNotFoundException {
        Equipment equipmentToDecrement = verifyIfExists(id);
        int oldEquipmentValue = equipmentToDecrement.getQuantity();
        int actualEquipmentValue = oldEquipmentValue - quantity;
        equipmentToDecrement.setQuantity(actualEquipmentValue);
        return equipmentMapper.toDTO(equipmentToDecrement);
    }

    private MessageResponseDTO createMessageDTO(String message, Long id) {
        return MessageResponseDTO.builder()
                .message(message + id)
                .build();
    }

    private Equipment verifyIfExists(Long id) throws EquipmentNotFoundException {
        return equipmentRepository.findById(id).orElseThrow(() -> new EquipmentNotFoundException(id));
    }

}
