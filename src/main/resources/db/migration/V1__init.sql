CREATE TABLE IF NOT EXISTS persona (
    id  serial,
    nombre varchar(45),
    apellido varchar (45),
    cedula varchar (10),
    celular varchar (45),
    primary key (id)
);

CREATE TABLE IF NOT EXISTS oficina (
    id  serial,
    codigo varchar(45),
    direccion varchar (45),
    primary key (id)

);


CREATE TABLE IF NOT EXISTS arriendo (
    id  serial,
    finicio varchar(45),
    ffin varchar (45),
    valor varchar (45),
    id_persona int,
    id_oficina int,
    primary key (id),
    foreign key (id_persona) references persona(id) on delete cascade on update cascade,
    foreign key (id_oficina) references oficina(id) on delete cascade on update cascade
);

