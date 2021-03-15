package io.github.henrique.vanicacao.vacinacao;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.github.henrique.vanicacao.usuario.Usuario;
import io.github.henrique.vanicacao.usuario.UsuarioRepository;

@RestController
@RequestMapping("usuarios/{id}/vacinacoes")
public class VacinacaoController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private VacinacaoRepository vacinacaoRepository;

    @PostMapping
    public ResponseEntity<Void> salvar(@PathVariable Long id,
                                   	   @RequestBody @Valid VacinacaoRequestDto requestDto,
                                       UriComponentsBuilder builder) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Usuario usuario = usuarioOptional.get();
        Vacinacao vacinacao = new Vacinacao(requestDto.getNomeVacina(), requestDto.getDataVacinacao(), usuario);
        vacinacaoRepository.save(vacinacao);

        URI uri = builder.path("usuarios/{id}/vacinacoes/{id}").buildAndExpand(vacinacao.getId(), usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
