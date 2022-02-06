package one.digitalinnovation.equipmentapi.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.equipmentapi.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/equipment")
@RestController()
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EquipmentController {

    private EquipmentService equipmentService;

    @GetMapping
    public String teste(){
        return "Hello world!";
    }


}
