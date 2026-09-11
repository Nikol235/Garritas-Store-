package pe.edu.upeu.garritas.citas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class CitaRequest {
    @NotNull(message = "El clienteId es obligatorio")
    private Long clienteId;

    @NotNull(message = "El mascotaId es obligatorio")
    private Long mascotaId;

    @NotBlank(message = "El tipo de servicio es obligatorio")
    private String tipoServicio;

    @NotNull(message = "La fecha y hora son obligatorias")
    private LocalDateTime fechaHora;
}