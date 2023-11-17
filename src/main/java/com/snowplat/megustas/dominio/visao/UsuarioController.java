package com.snowplat.megustas.dominio.visao;

import com.snowplat.megustas.dominio.Usuario;
import com.snowplat.megustas.dominio.dto.UsuarioDTO;
import com.snowplat.megustas.dominio.visao.base.UsuarioBaseController;
import com.snowplat.megustas.dominio.visao.interfaces.IUsuarioBaseController;
import java.util.List;
import java.util.UUID;

public class UsuarioController extends UsuarioBaseController implements IUsuarioBaseController {

    @Override
    public void incluir(Usuario usuario) {
        this.incluir(usuario);
    }

    @Override
    public List<UsuarioDTO> obterTodos() {
        return this.usuarioSd.obterTodosAtivos();
    }

    @Override
    public UsuarioDTO obterPorId(UUID idUsusario) {
        return this.usuarioSd.obterPorId(idUsusario);
    }

}
