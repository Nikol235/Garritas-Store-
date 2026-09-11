package pe.edu.upeu.garritas.citas.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.garritas.citas.dto.CitaRequest;
import pe.edu.upeu.garritas.citas.entity.Cita;
import pe.edu.upeu.garritas.citas.exception.ResourceNotFoundException;
import pe.edu.upeu.garritas.citas.repository.CitaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CitaService {

    private final CitaRepository repo;

    @Transactional
    public Cita crear(CitaRequest req) {
        Cita cita = Cita.builder()
                .clienteId(req.getClienteId())
                .mascotaId(req.getMascotaId())
                .tipoServicio(req.getTipoServicio())
                .fechaHora(req.getFechaHora())
                .estado("PROGRAMADA")
                .build();
        return repo.save(cita);
    }

    @Transactional(readOnly = true)
    public List<Cita> listar() {
        return repo.findAll();
    }

    @Transactional(readOnly = true)
    public Cita obtener(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cita " + id + " no encontrada"));
    }

    @Transactional
    public Cita actualizarEstado(Long id, String estado) {
        Cita cita = obtener(id);
        cita.setEstado(estado);
        return repo.save(cita);
    }

    @Transactional
    public void eliminar(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Cita " + id + " no encontrada");
        }
        repo.deleteById(id);
    }
}