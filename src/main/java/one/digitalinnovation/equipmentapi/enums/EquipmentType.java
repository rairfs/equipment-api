package one.digitalinnovation.equipmentapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum EquipmentType {

    DESKTOP("Desktop"),
    PRINTER("Printer");

    private final String description;

    EquipmentType(String description) {
        this.description = description;
    }
}
