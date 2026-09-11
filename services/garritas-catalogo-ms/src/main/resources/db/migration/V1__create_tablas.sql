CREATE TABLE productos (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    descripcion TEXT,
    categoria VARCHAR(50) NOT NULL,
    precio NUMERIC(10, 2) NOT NULL,
    stock INT NOT NULL,
    activo BOOLEAN DEFAULT TRUE
);

INSERT INTO
    productos (
        nombre,
        descripcion,
        categoria,
        precio,
        stock,
        activo
    )
VALUES (
        'Alimento Dog Chow Adulto 15kg',
        'Comida para perros adultos raza mediana y grande',
        'Alimentos',
        135.50,
        25,
        TRUE
    ),
    (
        'Rascador para Gatos 3 Pisos',
        'Poste de yute con plataforma y juguete colgante',
        'Accesorios',
        89.90,
        15,
        TRUE
    ),
    (
        'Shampoo Antipulgas 500ml',
        'Cuidado e higiene para caninos y felinos',
        'Higiene',
        28.00,
        40,
        TRUE
    );