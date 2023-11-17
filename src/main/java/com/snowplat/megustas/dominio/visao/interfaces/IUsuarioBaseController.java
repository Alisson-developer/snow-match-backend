package com.snowplat.megustas.dominio.visao.interfaces;

import com.snowplat.megustas.dominio.Usuario;
import com.snowplat.megustas.dominio.dto.UsuarioDTO;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public interface IUsuarioBaseController {

    @PostMapping("/cadastrar")
    void incluir(@RequestBody Usuario usuario);

    @GetMapping("/todos")
    List<UsuarioDTO> obterTodos();

    @GetMapping("/${idUsusario}")
    UsuarioDTO obterPorId(@PathVariable UUID idUsusario);

}
