package sptech;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sptech.alanriquelmeaquinodasilva.UsuarioController;
import sptech.modelo.Usuario;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

//@WebMvcTest(includeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "sptech.c1.alanriquelmeaquinodasilva.*"))
@WebMvcTest
@TestMethodOrder(MethodOrderer.MethodName.class)
public class C1TestBk {

    @Autowired
    private MockMvc mvc;

    private final String URI = "/usuarios/";

    ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

//    @BeforeEach
    void setup() {
//        this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        this.mvc = MockMvcBuilders.standaloneSetup(new UsuarioController()).build();
    }

    private String getNovo() {
        try {
            return objectMapper.writeValueAsString(novoUsuario());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private Usuario novoUsuario() {
        return new Usuario("email1@gmail.com", "fulano 1", "senha 1", "1990-01-01");
    }

    @Test
    public void post1() throws Exception {
        this.mvc.perform(post(URI)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(getNovo()))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void get1() throws Exception {
        this.mvc.perform(get(URI))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
