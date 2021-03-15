package io.github.henrique.vanicacao.vacinacao;

import io.github.henrique.vanicacao.usuario.Usuario;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Vacinacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nomeVacina;
    @NotNull
    private LocalDate dataVacinacao;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Deprecated
    public Vacinacao() {
    }

    public Vacinacao(@NotBlank String nomeVacina,
                     @NotNull LocalDate dataVacinacao,
                     Usuario usuario) {
        this.nomeVacina = nomeVacina;
        this.dataVacinacao = dataVacinacao;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }
}
