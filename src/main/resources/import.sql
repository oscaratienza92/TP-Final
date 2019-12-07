/* Creamos algunos usuarios con sus roles */
INSERT INTO tpfinal.usuario (username, password, nombre, apellido, email,enabled) VALUES ('oscar','$2a$10$Asxv5xHUNz4GA2NmE89dJe2wVDvAy8tRdfOwQY72qudcoaWpHUBMe', 'Oscar', 'Atienza','oatienza@telemercado.com.ar',1);
INSERT INTO tpfinal.usuario (username, password, nombre, apellido, email,enabled) VALUES ('admin','$2a$10$Asxv5xHUNz4GA2NmE89dJe2wVDvAy8tRdfOwQY72qudcoaWpHUBMe', 'John', 'Doe','jhon.doe@bolsadeideas.com',1);

INSERT INTO tpfinal.rol (nombre) VALUES ('Alumno');
INSERT INTO tpfinal.rol (nombre) VALUES ('Profesor');
INSERT INTO tpfinal.rol (nombre) VALUES ('Administrador');

INSERT INTO tpfinal.usuario_id_rol (usuario_id_usuario, id_rol_id_rol) VALUES (1, 1);
INSERT INTO tpfinal.usuario_id_rol (usuario_id_usuario, id_rol_id_rol) VALUES (2, 3);