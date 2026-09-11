CREATE TABLE usuarios (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    telefono VARCHAR(20),
    direccion VARCHAR(255),
    rol VARCHAR(30) NOT NULL,
    activo BOOLEAN DEFAULT TRUE
);

INSERT INTO
    usuarios (
        nombre,
        apellido,
        email,
        telefono,
        direccion,
        rol,
        activo
    )
VALUES (
        'Fiorella',
        'Perez',
        'admin@garritas.pe',
        '987654321',
        'Juliaca - Puno',
        'ADMIN',
        TRUE
    ),
    (
        'Juan',
        'Quispe',
        'cliente1@gmail.com',
        '951234567',
        'Av. Central 240',
        'CLIENTE',
        TRUE
    );