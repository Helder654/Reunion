CREATE TABLE funcionario (
    id BIGSERIAL PRIMARY KEY,
    name varchar(100) NOT NULL,
    email varchar(100) NOT NULL
);

CREATE TABLE sala (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    capacidade INTEGER NOT NULL
);

CREATE TABLE reserva (
    id BIGSERIAL PRIMARY KEY,
    funcionario_id BIGINT NOT NULL,
    sala_id BIGINT NOT NULL,
    inicio TIMESTAMP NOT NULL,
    fim TIMESTAMP NOT NULL,

    CONSTRAINT fk_reserva_funcionario
        FOREIGN KEY (funcionario_id)
        REFERENCES funcionario(id),

    CONSTRAINT fk_reserva_sala
        FOREIGN KEY (sala_id)
        REFERENCES sala(id),

    CONSTRAINT chk_reserva_horario
        CHECK (fim > inicio)
);