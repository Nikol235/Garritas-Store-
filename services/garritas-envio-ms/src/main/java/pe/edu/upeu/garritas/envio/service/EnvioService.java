package pe.edu.upeu.garritas.envio.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.garritas.envio.dto.EnvioRequest;
import pe.edu.upeu.garritas.envio.entity.DetalleSeguimiento;
import pe.edu.upeu.garritas.envio.entity.Envio;
import pe.edu.upeu.garritas.envio.exception.ResourceNotFoundException;
import pe.edu.upeu.garritas.envio.repository.EnvioRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnvioService {

    private final EnvioRepository repo;

    @Transactional
    public Envio crear(EnvioRequest req) {
        Envio envio = Envio.builder()
                .ventaId(req.getVentaId())
                .direccionDestino(req.getDireccionDestino())
                .estado("EN_RUTA")
                .fechaAsignacion(LocalDateTime.now())
                .build();

        List<DetalleSeguimiento> detalles = req.getDetalles().stream()
                .map(d -> DetalleSeguimiento.builder()
                        .envio(envio)
                        .descripcion(d.getDescripcion())
                        .latitud(d.getLatitud())
                        .longitud(d.getLongitud())
                        .timestamp(LocalDateTime.now())
                        .build())
                .toList();

        envio.setDetalles(detalles);
        return repo.save(envio);
    }

    @Transactional(readOnly = true)
    public List<Envio> listar() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public Envio obtener(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Envio " + id + " no encontrado"));
    }

    @Transactional
    public Envio actualizarEstado(Long id, String estado) {
        Envio envio = obtener(id);
        envio.setEstado(estado);
        return repo.save(envio);
    }

    @Transactional
    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Envio " + id + " no encontrado");
        }
        repo.deleteById(id);
    }
}