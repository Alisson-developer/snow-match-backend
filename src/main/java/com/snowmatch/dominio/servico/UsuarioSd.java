package com.snowmatch.dominio.servico;

import com.snowmatch.dominio.Usuario;
import com.snowmatch.dominio.dto.UsuarioDTO;
import com.snowmatch.dominio.servico.base.UsuarioBaseSd;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UsuarioSd extends UsuarioBaseSd {

    @Override
    public void incluir(Usuario usuario) {
        usuarioDados.save(usuario);
    }

    public List<UsuarioDTO> obterTodosAtivos() {
        return this.obterTodos();
    }

    @Override
    public UsuarioDTO obterPorId(UUID idUsuario) {
        return usuarioDados.findById(idUsuario).map(UsuarioDTO::new).stream().findFirst().orElseThrow();
    }
}
