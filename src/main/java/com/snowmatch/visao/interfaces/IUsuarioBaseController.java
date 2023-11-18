package com.snowmatch.visao.interfaces;

import com.snowmatch.dominio.Usuario;
import com.snowmatch.dominio.dto.UsuarioDTO;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/usuario")
public interface IUsuarioBaseController {

    @PostMapping("/cadastrar")
    void incluir(@RequestBody Usuario usuario);

    @GetMapping("/todos")
    List<UsuarioDTO> obterTodos();

    @GetMapping("/{idUsusario}")
    UsuarioDTO obterPorId(@PathVariable UUID idUsusario);

}
