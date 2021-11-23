
create table Carreras
(
codigocar int auto_increment primary key not null,
carrera varchar(30) not null
);

create table Alumno
(
codigoalu int auto_increment primary key not null,
nombre varchar(30) not null,
codigocar int references Carreras
);


