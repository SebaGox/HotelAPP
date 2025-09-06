ALTER TABLE hotel ADD COLUMN imagen_url VARCHAR(500) NULL;

INSERT INTO hotel (nombre, ciudad, direccion, descripcion, estrellas, imagen_url) VALUES
('Mandarin Oriental, Santiago', 'Santiago', 'Av. Pdte. Kennedy 4601, Las Condes', 'Lujo contemporáneo con jardines y piscina estilo laguna.', 5,
 'https://upload.wikimedia.org/wikipedia/commons/5/5a/Hotel_Hyatt_Santiago%2C_Chile.jpg'),
('Sheraton Miramar Hotel & Convention Center', 'Viña del Mar', 'Av. Marina 15', 'Ícono costero de Viña, literalmente arriba del mar.', 5,
 'https://upload.wikimedia.org/wikipedia/commons/3/32/Sheraton_Miramar%2C_Vi%C3%B1a_del_Mar_20200120_59.jpg'),
('The Singular Santiago, Lastarria', 'Santiago', 'Merced 294, Barrio Lastarria', 'Hotel boutique elegante en pleno Lastarria.', 5,
 'https://upload.wikimedia.org/wikipedia/commons/9/9a/The_Singular_Santiago_Lastarria_Hotel%2C_Santiago_20231013.jpg'),
('Hotel Cumbres Puerto Varas', 'Puerto Varas', 'Imperial 0561', 'Clásico con vista al Llanquihue, estilo patagón.', 5,
 'https://upload.wikimedia.org/wikipedia/commons/9/99/Puerto_Varas%2C_hotel_Cumbres.jpg'),
('Hotel Antumalal', 'Pucón', 'Km 2 Camino Pucón – Villarrica', 'Arquitectura moderna chilena, en ladera frente al lago.', 4,
 'https://upload.wikimedia.org/wikipedia/commons/3/37/Hotel_Antumalal_Pucon_%28atardecer%29.jpg');

-- Habitaciones (2 por hotel)
INSERT INTO habitacion (hotel_id, numero, tipo, capacidad, precio_por_noche, disponible)
SELECT id, '101', 'Doble', 2, 160000, TRUE FROM hotel WHERE nombre='Mandarin Oriental, Santiago';
INSERT INTO habitacion (hotel_id, numero, tipo, capacidad, precio_por_noche, disponible)
SELECT id, '102', 'Suite', 4, 280000, TRUE FROM hotel WHERE nombre='Mandarin Oriental, Santiago';

INSERT INTO habitacion (hotel_id, numero, tipo, capacidad, precio_por_noche, disponible)
SELECT id, '201', 'Doble', 2, 150000, TRUE FROM hotel WHERE nombre='Sheraton Miramar Hotel & Convention Center';
INSERT INTO habitacion (hotel_id, numero, tipo, capacidad, precio_por_noche, disponible)
SELECT id, '202', 'Suite', 3, 240000, TRUE FROM hotel WHERE nombre='Sheraton Miramar Hotel & Convention Center';

INSERT INTO habitacion (hotel_id, numero, tipo, capacidad, precio_por_noche, disponible)
SELECT id, '301', 'Doble', 2, 170000, TRUE FROM hotel WHERE nombre='The Singular Santiago, Lastarria';
INSERT INTO habitacion (hotel_id, numero, tipo, capacidad, precio_por_noche, disponible)
SELECT id, '302', 'Suite', 3, 260000, TRUE FROM hotel WHERE nombre='The Singular Santiago, Lastarria';

INSERT INTO habitacion (hotel_id, numero, tipo, capacidad, precio_por_noche, disponible)
SELECT id, '401', 'Doble', 2, 130000, TRUE FROM hotel WHERE nombre='Hotel Cumbres Puerto Varas';
INSERT INTO habitacion (hotel_id, numero, tipo, capacidad, precio_por_noche, disponible)
SELECT id, '402', 'Suite', 4, 220000, TRUE FROM hotel WHERE nombre='Hotel Cumbres Puerto Varas';

INSERT INTO habitacion (hotel_id, numero, tipo, capacidad, precio_por_noche, disponible)
SELECT id, '501', 'Doble', 2, 140000, TRUE FROM hotel WHERE nombre='Hotel Antumalal';
INSERT INTO habitacion (hotel_id, numero, tipo, capacidad, precio_por_noche, disponible)
SELECT id, '502', 'Suite', 3, 210000, TRUE FROM hotel WHERE nombre='Hotel Antumalal';
