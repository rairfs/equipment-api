package one.digitalinnovation.equipmentapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.equipmentapi.enums.EquipmentType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDTO {

    private Long id;

    @NotNull
    @Size(min = 2, max = 100)
    private String name;

    @NotNull
    @Size(min = 3, max = 150)
    private String place;

    @NotNull
    private Integer quantity;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EquipmentType type;
}
