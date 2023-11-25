package com.snowmatch.visao.interfaces;

import com.snowmatch.dominio.Usuario;
import com.snowmatch.dominio.dto.AutenticacaoDTO;
import com.snowmatch.dominio.dto.LoginDTO;
import com.snowmatch.dominio.dto.UsuarioDTO;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IUsuarioBaseController {

    @PostMapping("/cadastrar")
    ResponseEntity<LoginDTO> incluir(@RequestBody Usuario usuario);

    @PostMapping("/login")
    ResponseEntity<LoginDTO> login(@RequestBody AutenticacaoDTO autenticacaoDTO);

    @GetMapping("/todos")
    List<UsuarioDTO> obterTodos();

    @GetMapping("/{idUsusario}")
    UsuarioDTO obterPorId(@PathVariable UUID idUsusario);

}
