package com.anajulia.modulo41.entidades;

import java.time.LocalDate;

public record Pessoa(
        String nome,
        LocalDate dt_nascimento
) {
}
