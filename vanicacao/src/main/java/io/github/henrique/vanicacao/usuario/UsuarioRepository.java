package io.github.henrique.vanicacao.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findTop1ByEmail(String email);

    Optional<Usuario> findTop1ByCpf(String cpf);
}
