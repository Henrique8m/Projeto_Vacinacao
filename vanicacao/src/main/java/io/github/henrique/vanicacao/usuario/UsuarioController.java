package io.github.henrique.vanicacao.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody @Valid UsuarioRequestDto requestDto,
                                         UriComponentsBuilder builder) {
        if (usuarioRepository.findTop1ByEmail(requestDto.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        if (usuarioRepository.findTop1ByCpf(requestDto.getCpf()).isPresent()) {
            return ResponseEntity.badRequest().build();
        }

        Usuario usuario = new Usuario(requestDto.getNome(), requestDto.getEmail(), requestDto.getCpf(), requestDto.getDataNascimento());
        usuarioRepository.save(usuario);

        URI uri = builder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
