
create table Carreras
(
codigocar int auto_increment primary key not null,
carrera varchar(30) not null
);

insert into carreras values(null, "Computacion e Informatica");
insert into carreras values(null, "Administracion de Empresas");
insert into carreras values(null, "Fotografia");
insert into carreras values(null, "Redes y Comunicaciones");

select * from carreras;

create table Alumno
(
codigoalu int auto_increment primary key not null,
nombre varchar(30) not null,
codigocar int references Carreras,
dni int(8) not null,
email varchar(50) not null,
foreign key (codigocar) references Carreras(codigocar)
);


insert into Alumno values(null, "Jairo Mendez", 1 , 75489865, "Jairo@gmail.com");
insert into Alumno values(null, "Alex Gomez", 2, 78964523, "Alex@gmail.com");
insert into Alumno values(null, "Jhon Valverde", 4, 71523698, "Jhon@gmail.com");
insert into Alumno values(null, "Rebeca Montenegro", 3 , 72659831, "Rebeca@gmail.com");
insert into Alumno values(null, "Valeria Cifuentes", 3, 74125855, "Valeria@gmail.com");

select * from Alumno a inner join carreras c on a.codigocar=c.codigocar;



