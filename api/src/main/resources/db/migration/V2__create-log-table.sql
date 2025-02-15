CREATE TABLE log (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    servico UUID NOT NULL,
    tipo VARCHAR(255) NOT NULL,
    traceback TEXT NOT NULL,
    funcao VARCHAR(255),
    linha INTEGER,
    arquivo VARCHAR(255),
    criado_em TIMESTAMP NOT NULL DEFAULT NOW(),
    atualizado_em TIMESTAMP NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_log_servico FOREIGN KEY (servico) REFERENCES service(id) ON DELETE CASCADE
);