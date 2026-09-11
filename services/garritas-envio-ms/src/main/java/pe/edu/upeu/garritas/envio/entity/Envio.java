package pe.edu.upeu.garritas.envio.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "envios")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "venta_id", nullable = false)
    private Long ventaId;

    @Column(name = "direccion_destino", nullable = false)
    private String direccionDestino;

    @Column(nullable = false)
    private String estado;

    @Column(name = "fecha_asignacion", nullable = false)
    private LocalDateTime fechaAsignacion;

    @OneToMany(mappedBy = "envio", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<DetalleSeguimiento> detalles = new ArrayList<>();
}