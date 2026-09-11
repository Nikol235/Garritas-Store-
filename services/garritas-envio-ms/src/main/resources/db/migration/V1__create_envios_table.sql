CREATE TABLE envios (
    id              BIGSERIAL PRIMARY KEY,
    venta_id        BIGINT NOT NULL,
    direccion_destino VARCHAR(255) NOT NULL,
    estado          VARCHAR(20) NOT NULL DEFAULT 'EN_RUTA',
    fecha_asignacion TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE detalles_seguimiento (
    id              BIGSERIAL PRIMARY KEY,
    envio_id        BIGINT NOT NULL,
    descripcion     VARCHAR(255) NOT NULL,
    latitud         VARCHAR(50),
    longitud        VARCHAR(50),
    timestamp       TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_detalle_envio FOREIGN KEY (envio_id) REFERENCES envios(id) ON DELETE CASCADE
);