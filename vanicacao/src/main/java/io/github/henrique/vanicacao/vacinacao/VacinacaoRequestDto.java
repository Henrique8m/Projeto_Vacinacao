package io.github.henrique.vanicacao.vacinacao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class VacinacaoRequestDto {

    @NotBlank
    private String nomeVacina;
    @NotNull
    private LocalDate dataVacinacao;

    public VacinacaoRequestDto(@NotBlank String nomeVacina,
                               @NotNull LocalDate dataVacinacao) {
        this.nomeVacina = nomeVacina;
        this.dataVacinacao = dataVacinacao;
    }

    public String getNomeVacina() {
        return nomeVacina;
    }

    public LocalDate getDataVacinacao() {
        return dataVacinacao;
    }
}
