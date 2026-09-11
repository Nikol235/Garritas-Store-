package pe.edu.upeu.garritas.envio.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EnvioRequest {
    @NotNull(message = "El ventaId es obligatorio")
    private Long ventaId;

    @NotBlank(message = "La direccion es obligatoria")
    private String direccionDestino;

    @NotNull(message = "Los detalles son obligatorios")
    @Valid
    private List<DetalleRequest> detalles;

    @Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
    public static class DetalleRequest {
        @NotBlank(message = "La descripcion es obligatoria")
        private String descripcion;
        private String latitud;
        private String longitud;
    }
}