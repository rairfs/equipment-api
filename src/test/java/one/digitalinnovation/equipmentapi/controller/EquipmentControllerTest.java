package one.digitalinnovation.equipmentapi.controller;

import one.digitalinnovation.equipmentapi.builder.EquipmentDTOBuilder;
import one.digitalinnovation.equipmentapi.dto.request.EquipmentDTO;
import one.digitalinnovation.equipmentapi.service.EquipmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import static one.digitalinnovation.equipmentapi.utils.JsonConvertionUtils.asJsonString;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class EquipmentControllerTest {

    private static final String EQUIPMENT_API_URL_PATH = "/api/v1/equipment";
    private static final long VALID_EQUIPMENT_ID = 1L;
    private static final long INVALID_EQUIPMENT_ID = 2l;
    private static final String EQUIPMENT_API_SUBPATH_INCREMENT_URL = "/increment";
    private static final String EQUIPMENT_API_SUBPATH_DECREMENT_URL = "/decrement";

    private MockMvc mockMvc;

    @Mock
    private EquipmentService equipmentService;

    @InjectMocks
    private EquipmentController equipmentController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(equipmentController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    }

    @Test
    void whenPOSTIsCalledThenAEquipmentIsCreated() throws Exception{
        //given
        EquipmentDTO equipmentDTO = EquipmentDTOBuilder.builder().build().toEquipmentDTO();

        //when
        when(equipmentService.createEquipment(equipmentDTO)).thenReturn(equipmentDTO);

        //then
        mockMvc.perform(MockMvcRequestBuilders.post(EQUIPMENT_API_URL_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(equipmentDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name", is(equipmentDTO.getName())))
                .andExpect(jsonPath("$.place", is(equipmentDTO.getPlace())))
                .andExpect(jsonPath("$.type", is(equipmentDTO.getType().toString())));
    }

    @Test
    void whenPOSTIsCalledWithoutRequiredFieldThenAnErrorIsReturned() throws Exception {
        // given
        EquipmentDTO equipmentDTO = EquipmentDTOBuilder.builder().build().toEquipmentDTO();
        equipmentDTO.setPlace(null);

        // then
        mockMvc.perform(MockMvcRequestBuilders.post(EQUIPMENT_API_URL_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(equipmentDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenGETIsCalledWithValidNameThenOkStatusIsReturned() throws Exception{
        //given
        EquipmentDTO equipmentDTO = EquipmentDTOBuilder.builder().build().toEquipmentDTO();

        //when
        when(equipmentService.createEquipment(equipmentDTO)).thenReturn(equipmentDTO);

        //then
        mockMvc.perform(MockMvcRequestBuilders.post(EQUIPMENT_API_URL_PATH + "/" + equipmentDTO.getName())
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(equipmentDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(equipmentDTO.getName())))
                .andExpect(jsonPath("$.place", is(equipmentDTO.getPlace())))
                .andExpect(jsonPath("$.type", is(equipmentDTO.getType().toString())));
    }
}
