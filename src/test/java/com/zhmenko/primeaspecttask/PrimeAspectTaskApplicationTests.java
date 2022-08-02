package com.zhmenko.primeaspecttask;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PrimeAspectTaskApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    private final String baseApiUrl = "http://localhost/api/flags";
    private final String examplePath = System.getProperty("os.name").startsWith("Windows")
            ? "C:\\\\tmp\\\\countries\\\\flags"
            : "/tmp/countries/flags";

    @Test
    void okTest() throws Exception {
        String dataPng = "{\n" +
                "  \"countriesCodesList\": [\n" +
                "    \"ru\", \"col\",\"us\",\"cl\",\"be\",\"pe\"\n" +
                "  ],\n" +
                "  \"imageFormat\": \"png\",\n" +
                "  \"saveDirectoryPath\": \"" + examplePath + "\"\n" +
                "}";
        mockMvc.perform(
                        post(baseApiUrl)
                                .content(dataPng)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
        String dataSvg = "{\n" +
                "  \"countriesCodesList\": [\n" +
                "    \"ru\", \"col\",\"us\",\"cl\",\"be\",\"pe\"\n" +
                "  ],\n" +
                "  \"imageFormat\": \"svg\",\n" +
                "  \"saveDirectoryPath\": \"" + examplePath + "\"\n" +
                "}";
        mockMvc.perform(
                        post(baseApiUrl)
                                .content(dataSvg)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    void nullCountriesCodesTest() throws Exception {
        String dataPng = "{\n" +
                "  \"countriesCodesList\": null,\n" +
                "  \"imageFormat\": \"png\",\n" +
                "  \"saveDirectoryPath\": \"" + examplePath + "\"\n" +
                "}";
        mockMvc.perform(
                        post(baseApiUrl)
                                .content(dataPng)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void emptyCountriesCodesListTest() throws Exception {
        String dataPng = "{\n" +
                "  \"countriesCodesList\": [],\n" +
                "  \"imageFormat\": \"png\",\n" +
                "  \"saveDirectoryPath\": \"" + examplePath + "\"\n" +
                "}";
        mockMvc.perform(
                        post(baseApiUrl)
                                .content(dataPng)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void wrongCountriesCodesTest() throws Exception {
        String dataPng = "{\n" +
                "  \"countriesCodesList\": [\"ri\",\"mb\"],\n" +
                "  \"imageFormat\": \"png\",\n" +
                "  \"saveDirectoryPath\": \"" + examplePath + "\"\n" +
                "}";
        mockMvc.perform(
                        post(baseApiUrl)
                                .content(dataPng)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andReturn();
    }

    @Test
    void nullImageFormatTest() throws Exception {
        String dataPng = "{\n" +
                "  \"countriesCodesList\": [\n" +
                "    \"ru\", \"col\",\"us\",\"cl\",\"be\",\"pe\"\n" +
                "  ],\n" +
                "  \"imageFormat\": null,\n" +
                "  \"saveDirectoryPath\": \"" + examplePath + "\"\n" +
                "}";
        mockMvc.perform(
                        post(baseApiUrl)
                                .content(dataPng)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void wrongImageFormatTest() throws Exception {
        String dataPng = "{\n" +
                "  \"countriesCodesList\": [\n" +
                "    \"ru\", \"col\",\"us\",\"cl\",\"be\",\"pe\"\n" +
                "  ],\n" +
                "  \"imageFormat\": \"jpg\",\n" +
                "  \"saveDirectoryPath\": \"" + examplePath + "\"\n" +
                "}";
        mockMvc.perform(
                        post(baseApiUrl)
                                .content(dataPng)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void nullDirectoryPath() throws Exception {
        String dataPng = "{\n" +
                "  \"countriesCodesList\": [\n" +
                "    \"ru\", \"col\",\"us\",\"cl\",\"be\",\"pe\"\n" +
                "  ],\n" +
                "  \"imageFormat\": \"png\",\n" +
                "  \"saveDirectoryPath\": null\n" +
                "}";
        mockMvc.perform(
                        post(baseApiUrl)
                                .content(dataPng)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void wrongDirectoryPath() throws Exception {
        String dataPng = "{\n" +
                "  \"countriesCodesList\": [\n" +
                "    \"ru\", \"col\",\"us\",\"cl\",\"be\",\"pe\"\n" +
                "  ],\n" +
                "  \"imageFormat\": \"png\",\n" +
                "  \"saveDirectoryPath\": \"123?:Wrong_Path\"\n" +
                "}";
        mockMvc.perform(
                        post(baseApiUrl)
                                .content(dataPng)
                                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();
    }

}
