package org.example.demojdbc;

import jakarta.transaction.Transactional;
import org.example.demojdbc.model.Persona;
import org.example.demojdbc.repository.PersonaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Sql({"/schema.sql"})
class DemoJdbcApplicationTests {

    @Autowired
    PersonaRepository repositorio;

    @Test
    void borrarTodos() {
        repositorio.borrarTodos();
        List<Persona> lista = repositorio.buscarTodos();
        assertEquals(0, lista.size());
    }

    @Test
    void insertarPersona() {
        Persona persona = new Persona("eric", "morales", 19);
        repositorio.insertar(persona);
        persona = new Persona("roger", "gonzalbo", 27);
        repositorio.insertar(persona);
        List<Persona> lista = repositorio.buscarTodos();
        assertEquals(2, lista.size());
    }

    @Test
    void buscarTodos() {
        List<Persona> lista = repositorio.buscarTodos();
        assertEquals(2, lista.size());
    }

  @Test
    void borrarPersona() {
        Persona persona = new Persona("eric");
        repositorio.borrar(persona);
        List<Persona> lista = repositorio.buscarTodos();
        assertEquals(1, lista.size());

    }

    @Test
    void buscarUno() {
        Persona persona = repositorio.buscarUno("roger");
        assertEquals("roger", persona.getNombre());
    }


}
