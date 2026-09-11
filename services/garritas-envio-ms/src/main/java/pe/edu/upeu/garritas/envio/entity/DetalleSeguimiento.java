package pe.edu.upeu.garritas.envio.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "detalles_seguimiento")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class DetalleSeguimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "envio_id", nullable = false)
    private Envio envio;

    @Column(nullable = false)
    private String descripcion;

    private String latitud;
    private String longitud;

    @Column(nullable = false)
    private LocalDateTime timestamp;
}