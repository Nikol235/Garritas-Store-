package pe.edu.upeu.garritas.catalogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.garritas.catalogo.entity.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}