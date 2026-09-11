package pe.edu.upeu.garritas.catalogo.dto;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoResponse {
    private Long id;
    private String nombre;
    private String descripcion;
    private String categoria;
    private BigDecimal precio;
    private Integer stock;
    private Boolean activo;
}