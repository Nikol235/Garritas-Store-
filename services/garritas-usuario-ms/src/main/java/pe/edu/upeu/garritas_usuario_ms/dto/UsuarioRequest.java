package pe.edu.upeu.garritas.usuario.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellido;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Debe ingresar un email con formato valido")
    private String email;

    private String telefono;
    private String direccion;

    @NotBlank(message = "El rol es obligatorio (ej. CLIENTE, ADMIN)")
    private String rol;
}