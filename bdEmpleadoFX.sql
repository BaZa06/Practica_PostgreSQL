CREATE TABLE empleado(
	id SERIAL PRIMARY KEY, -- O AUTOINTEGER
	nombres varchar(100) NOT NULL,
	apellidos VARCHAR(100) NOT NULL,
	cedula VARCHAR(100) NOT NULL,
	correo VARCHAR(100) NOT NULL,
	telefono VARCHAR(100) NOT NULL,
	cargo VARCHAR(100) NOT NULL,
	departamento VARCHAR(100) NOT NULL,
	salario NUMERIC(10,2) NOT NULL,
	fecha_contratacion DATE NOT NULL,
	estado VARCHAR(100) NOT NULL
	
);

INSERT INTO empleado(nombres, apellidos, cedula, correo, telefono, cargo, departamento, salario, fecha_contratacion, estado)
VALUES
('Blanca Alejandra', 'Zeledón Abea', '001-489664-0005N', 'bazeledon@uamv.edu.ni', '47589689', 'Gerente','Administración', 50000.00, '2022-01-15', 'Activo'),
('Luis Alberto', 'Morales Sánchez', '001-181294-0005E', 'luis.morales@gmail.com', '88885678', 'Supervisor', 'Producción', 35000.00, '2024-03-18', 'Inactivo'),
('Andy Josue', 'Rueda Sanchez', '001-050799-0004D', 'ana.rodriguez@gmail.com', '84789656', 'Recursos Humanos', 'Recursos Humanos', 30000.00, '2023-08-01', 'Activo'),
('Avril Denisse', 'Quezada Moncada', '001-100496-0003C', 'jose.hernandez@gmail.com', '88883456', 'Analista', 'Sistemas', 28000.00, '2023-02-10', 'Activo'),
('María Fernanda', 'González Pérez', '001-220398-0002B', 'maria.gonzalez@gmail.com', '88882345', 'Contadora', 'Finanzas', 32000.00, '2022-05-20', 'Activo');


SELECT * FROM empleado;