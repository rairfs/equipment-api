package one.digitalinnovation.equipmentapi.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.equipmentapi.dto.request.EquipmentDTO;
import one.digitalinnovation.equipmentapi.dto.request.QuantityDTO;
import one.digitalinnovation.equipmentapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.equipmentapi.exceptions.EquipmentNotFoundException;
import one.digitalinnovation.equipmentapi.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/equipment")
@RestController()
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EquipmentController {

    private EquipmentService equipmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EquipmentDTO createEquipment(@RequestBody @Valid EquipmentDTO equipmentDTO){
        return equipmentService.createEquipment(equipmentDTO);
    }

    @GetMapping
    public List<EquipmentDTO> listAllEquipments(){
        return equipmentService.listAllEquipments();
    }

    @GetMapping("/{id}")
    public EquipmentDTO findEquipmentById(@PathVariable Long id) throws EquipmentNotFoundException {
        return equipmentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipmentById(@PathVariable Long id) throws EquipmentNotFoundException {
        equipmentService.delete(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateEquipmentById(@PathVariable Long id, @RequestBody EquipmentDTO equipmentDTO) throws EquipmentNotFoundException {
        return equipmentService.updateById(id, equipmentDTO);
    }

    @PatchMapping("/{id}/increment")
    public EquipmentDTO incrementEquipmentQuantity(@PathVariable Long id, @RequestBody @Valid QuantityDTO quantityDTO) throws EquipmentNotFoundException {
        return equipmentService.incrementQuantity(id, quantityDTO.getQuantity());
    }

    @PatchMapping("/{id}/decrement")
    public EquipmentDTO decrementEquipmentQuantity(@PathVariable Long id, @RequestBody @Valid QuantityDTO quantityDTO) throws EquipmentNotFoundException {
        return equipmentService.decrementQuantity(id, quantityDTO.getQuantity());
    }


}
