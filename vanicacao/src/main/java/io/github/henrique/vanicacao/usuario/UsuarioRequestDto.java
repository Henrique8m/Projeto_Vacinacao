package io.github.henrique.vanicacao.usuario;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class UsuarioRequestDto {

    @NotBlank
    private String nome;
    private String email;
    @NotBlank
    @CPF
    private String cpf;
    @NotNull
    private LocalDate dataNascimento;

    public UsuarioRequestDto(@NotBlank String nome,
                             @NotBlank @Email String email,
                             @NotBlank @CPF String cpf,
                             @NotNull LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
