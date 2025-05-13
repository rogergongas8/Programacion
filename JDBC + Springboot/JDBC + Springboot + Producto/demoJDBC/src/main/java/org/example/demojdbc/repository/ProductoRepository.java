package org.example.demojdbc.repository;

import org.example.demojdbc.model.Producto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class ProductoRepository {
    private final JdbcTemplate plantilla;

    public ProductoRepository(JdbcTemplate plantilla) {
        this.plantilla = plantilla;
    }

    @Transactional
    public void insertar(Producto producto) {
        plantilla.update("INSERT INTO productos (nombre, precio, stock) VALUES (?, ?, ?)",
                producto.getNombre(), producto.getPrecio(), producto.getStock());
    }

    public List<Producto> buscarTodos() {
        return plantilla.query("SELECT * FROM productos", new ProductoMapper());
    }

    public Producto buscarPorNombre(String nombre) {
        List<Producto> resultados = plantilla.query(
                "SELECT * FROM productos WHERE nombre = ?",
                new ProductoMapper(), nombre);
        return resultados.isEmpty() ? null : resultados.get(0);
    }

    @Transactional
    public void actualizar(Producto producto) {
        plantilla.update("UPDATE productos SET precio = ?, stock = ? WHERE nombre = ?",
                producto.getPrecio(), producto.getStock(), producto.getNombre());
    }

    @Transactional
    public void borrar(String nombre) {
        plantilla.update("DELETE FROM productos WHERE nombre = ?", nombre);
    }

    @Transactional
    public void borrarTodos() {
        plantilla.update("DELETE FROM productos");
    }
}