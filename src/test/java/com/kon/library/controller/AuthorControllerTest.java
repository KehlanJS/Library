package com.kon.library.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kon.library.controller.dto.AuthorDto;
import com.kon.library.model.Author;
import com.kon.library.service.author.AuthorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    AuthorService authorService;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    void addAuthorTest() throws Exception {
        AuthorDto author = new AuthorDto();

        final String request = mapper.writeValueAsString(author);

        mvc.perform(MockMvcRequestBuilders.post("/author/add")
                .content(request)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
    }

    @Test
    void getAllAuthors() throws Exception {
        // service -> lista z autorem

        List<AuthorDto> list = new ArrayList<>();
        AuthorDto authorDto = new AuthorDto("adf","asda", new Date());
        list.add(authorDto);

        given(authorService.getAllAuthors()).willReturn(list);

        final String request = mapper.writeValueAsString(authorService.getAllAuthors());

        final MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/author/all")
                .content(request)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        final String stringResult = result.getResponse().getContentAsString();

        assertNotNull(stringResult);
        assertTrue(stringResult.contains(authorDto.getName()));
    }

}
