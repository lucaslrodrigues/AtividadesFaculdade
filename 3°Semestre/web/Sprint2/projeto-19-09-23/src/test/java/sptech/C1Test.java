package sptech;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import sptech.modelo.Usuario;

import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(includeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern =
"sptech.c1.alanriquelmeaquinodasilva.*"
 ))
//@WebMvcTest
@TestMethodOrder(MethodOrderer.MethodName.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class C1Test {
    private String URI = "/usuarios";

    @Autowired
    private MockMvc mvc;

    Double notaGeral = 0.0;

    StringBuilder sbReport = new StringBuilder();

    @BeforeAll
    protected void setup() {
        addMsg("Testes para "+getClass().getSimpleName());
    }

    @AfterAll
    protected void tearDown() {
        new File()
    }


    ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    protected  String toJson(Usuario usuario) {
        try {
            return objectMapper.writeValueAsString(usuario);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    protected Usuario getUsuarioValido() {
        return new Usuario("email1@gmail.com", "fulano 1", "senha 1", "1990-01-01");
    }

    protected Usuario getUsuarioSemEmail() {
        return new Usuario(null, "fulano 1", "senha 1", "1990-01-01");
    }

    protected Usuario getUsuarioEmailPequeno() {
        return new Usuario("ww@ww.com", "fulano 1", "senha 1", "1990-01-01");
    }

    protected Usuario getUsuarioEmailInvalido() {
        return new Usuario("www$www.com", "fulano 1", "senha 1", "1990-01-01");
    }

    @Test
    public void test0Get204() throws Exception {

        if (testGet(URI, MockMvcResultMatchers.status().isNoContent())) {
            System.out.println("Nota: 0.50");
            notaGeral += 0.5;
            return;
        }

        if (testGet(URI+"/", MockMvcResultMatchers.status().isNoContent())) {
            System.out.println("Nota: 0.50");
            notaGeral += 0.5;
        }
    }

    @Test
    public void test1Post() throws Exception {
        AtomicReference<Double> nota = new AtomicReference<>(0.0);

        if (testPost(URI, nota)) {
            System.out.println("Nota: %.2f".formatted(nota.get()));
            notaGeral += nota.get();
            return;
        }

        if (testPost(URI + "/", nota)) {
            System.out.println("Nota: %.2f".formatted(nota.get()));
            notaGeral += nota.get();
        }
    }


    @Test
    public void test2Get200() throws Exception {
        if (testGet(URI, MockMvcResultMatchers.status().isOk())) {
            System.out.println("Nota: 0.50");
            notaGeral += 0.5;
            return;
        }

        if (testGet(URI+"/", MockMvcResultMatchers.status().isOk())) {
            System.out.println("Nota: 0.50");
            notaGeral += 0.5;
        }
    }

    protected void addMsg(String mensagem) {
        sbReport = sbReport.append(mensagem).append("\r\n");
    }

    protected boolean testPost(String uri, AtomicReference<Double> nota) {
        MockHttpServletRequestBuilder builder = post(uri)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        try {
            assertAll(
                    () -> {
                        mvc.perform(builder.content(toJson(getUsuarioValido()))).andDo(print())
                                .andExpect(MockMvcResultMatchers.status().isCreated());
                        nota.updateAndGet(v -> (v + 1.5));
                    },
                    () -> {
                        mvc.perform(builder.content(toJson(getUsuarioSemEmail()))).andDo(print())
                                .andExpect(MockMvcResultMatchers.status().isBadRequest());
                        nota.updateAndGet(v -> (v + 0.5));
                    },
                    () -> {
                        mvc.perform(builder.content(toJson(getUsuarioEmailPequeno()))).andDo(print())
                                .andExpect(MockMvcResultMatchers.status().isBadRequest());
                        nota.updateAndGet(v -> (v + 0.5));
                    },
                    () -> {
                        mvc.perform(builder.content(toJson(getUsuarioEmailInvalido()))).andDo(print())
                                .andExpect(MockMvcResultMatchers.status().isBadRequest());
                        nota.updateAndGet(v -> (v + 0.5));
                    }
            );
            return true;
        } catch (AssertionError error) {
            return false;
        }
    }


    protected boolean testGet(String uri, ResultMatcher matcher) throws Exception {
        try {
            this.mvc.perform(get(uri))
                    .andDo(print())
                    .andExpect(matcher);
            return true;
        } catch (AssertionError error) {
            return false;
        }
    }


}
