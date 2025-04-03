package com.seip.Mars_CICD;

import com.seip.Mars_CICD.controller.ResourceController;
import com.seip.Mars_CICD.model.Resource;
import com.seip.Mars_CICD.repository.ResourceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ResourceControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ResourceRepository resourceRepository;

    @InjectMocks
    private ResourceController resourceController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(resourceController).build();
    }

    @Test
    void testShowAddForm() throws Exception {
        mockMvc.perform(get("/resources/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("add-resource"))
                .andExpect(model().attributeExists("resource"));
    }

    @Test
    void testAddResource() throws Exception {
        when(resourceRepository.save(any(Resource.class))).thenReturn(new Resource("Bronze", "BronzeDesc", "Earth", 8.99));

        mockMvc.perform(post("/resources/add")
            .param("name", "Bronze")
            .param("description", "BronzeDesc")
            .param("planet_of_origin", "Earth")
            .param("price", "8.99"))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/resources"));
    }

    @Test
    void testEditResource() throws Exception {
        Resource resource = new Resource("Resource1", "Description1", "Planet", 10.0);
        resource.setId(1L);
        when(resourceRepository.save(any(Resource.class))).thenReturn(resource);

        mockMvc.perform(post("/resources/edit/1")
                        .param("name", "UpdatedResource")
                        .param("description", "UpdatedDescription")
                        .param("planet_of_origin", "UpdatedPlanet")
                        .param("price", "15.0"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/resources"));
    }

    @Test
    void testDeleteResource() throws Exception {
        mockMvc.perform(get("/resources/delete/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/resources"));

        Mockito.verify(resourceRepository).deleteById(1L);
    }
}
