package one.digitalinnovation.equipmentapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/equipment")
@RestController()
public class EquipmentController {

    @GetMapping
    public String teste(){
        return "Hello world!";
    }
}
