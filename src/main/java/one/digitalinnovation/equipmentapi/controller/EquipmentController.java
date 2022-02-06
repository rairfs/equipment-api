package one.digitalinnovation.equipmentapi.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.equipmentapi.dto.request.EquipmentDTO;
import one.digitalinnovation.equipmentapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.equipmentapi.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/api/v1/equipment")
@RestController()
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EquipmentController {

    private EquipmentService equipmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createEquipment(@Valid @RequestBody EquipmentDTO equipmentDTO){
        return equipmentService.createEquipment(equipmentDTO);
    }


}
