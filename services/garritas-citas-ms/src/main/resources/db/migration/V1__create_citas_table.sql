CREATE TABLE citas (
    id              BIGSERIAL PRIMARY KEY,
    cliente_id      BIGINT NOT NULL,
    mascota_id      BIGINT NOT NULL,
    tipo_servicio   VARCHAR(100) NOT NULL,
    fecha_hora      TIMESTAMP NOT NULL,
    estado          VARCHAR(20) NOT NULL DEFAULT 'PROGRAMADA'
);
