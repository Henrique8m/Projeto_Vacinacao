package io.github.henrique.vanicacao.usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;

import io.github.henrique.vanicacao.vacinacao.Vacinacao;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	@CPF
	private String cpf;
	@NotNull
	private LocalDate dataNascimento;

	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<Vacinacao> vacinacoes = new ArrayList<>();

	@Deprecated
	public Usuario() {
	}

	public Usuario(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @CPF String cpf,
			@NotNull LocalDate dataNascimento) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public Long getId() {
		return id;
	}

}
