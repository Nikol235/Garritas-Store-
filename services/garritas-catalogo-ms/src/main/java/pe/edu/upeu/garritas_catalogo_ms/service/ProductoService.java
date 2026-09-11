package pe.edu.upeu.garritas.catalogo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.garritas.catalogo.dto.ProductoRequest;
import pe.edu.upeu.garritas.catalogo.dto.ProductoResponse;
import pe.edu.upeu.garritas.catalogo.entity.Producto;
import pe.edu.upeu.garritas.catalogo.exception.ResourceNotFoundException;
import pe.edu.upeu.garritas.catalogo.repository.ProductoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    @Transactional(readOnly = true)
    public List<ProductoResponse> listarTodos() {
        return productoRepository.findAll().stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public ProductoResponse buscarPorId(Long id) {
        Producto p = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + id));
        return mapToResponse(p);
    }

    @Transactional
    public ProductoResponse crear(ProductoRequest req) {
        Producto producto = Producto.builder()
                .nombre(req.getNombre())
                .descripcion(req.getDescripcion())
                .categoria(req.getCategoria())
                .precio(req.getPrecio())
                .stock(req.getStock())
                .activo(true)
                .build();
        return mapToResponse(productoRepository.save(producto));
    }

    @Transactional
    public ProductoResponse actualizar(Long id, ProductoRequest req) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + id));

        producto.setNombre(req.getNombre());
        producto.setDescripcion(req.getDescripcion());
        producto.setCategoria(req.getCategoria());
        producto.setPrecio(req.getPrecio());
        producto.setStock(req.getStock());

        return mapToResponse(productoRepository.save(producto));
    }

    @Transactional
    public void eliminar(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado con ID: " + id));
        productoRepository.delete(producto);
    }

    private ProductoResponse mapToResponse(Producto p) {
        return ProductoResponse.builder()
                .id(p.getId())
                .nombre(p.getNombre())
                .descripcion(p.getDescripcion())
                .categoria(p.getCategoria())
                .precio(p.getPrecio())
                .stock(p.getStock())
                .activo(p.getActivo())
                .build();
    }
}