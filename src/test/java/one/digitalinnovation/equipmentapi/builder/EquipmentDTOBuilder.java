package one.digitalinnovation.equipmentapi.builder;

import lombok.Builder;
import one.digitalinnovation.equipmentapi.dto.request.EquipmentDTO;
import one.digitalinnovation.equipmentapi.enums.EquipmentType;

@Builder
public class EquipmentDTOBuilder {

    @Builder.Default
    private Long id = 1L;

    @Builder.Default
    private String name = "PC Deutel";

    @Builder.Default
    private String place = "Maria Francisca";

    @Builder.Default
    private int quantity = 3;

    @Builder.Default
    private EquipmentType type = EquipmentType.DESKTOP;

    public EquipmentDTO toEquipmentDTO() {
        return new EquipmentDTO(id,
                name,
                place,
                quantity,
                type);
    }

}
