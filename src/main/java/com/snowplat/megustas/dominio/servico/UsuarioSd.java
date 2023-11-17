package com.snowplat.megustas.dominio.servico;

import com.snowplat.megustas.dominio.Usuario;
import com.snowplat.megustas.dominio.dto.UsuarioDTO;
import com.snowplat.megustas.dominio.servico.base.UsuarioBaseSd;
import java.util.List;
import java.util.UUID;

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
