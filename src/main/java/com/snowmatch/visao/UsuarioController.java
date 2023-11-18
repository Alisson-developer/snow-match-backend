package com.snowmatch.visao;

import com.snowmatch.anotacoes.SnowRestController;
import com.snowmatch.dominio.Usuario;
import com.snowmatch.dominio.dto.UsuarioDTO;
import com.snowmatch.visao.base.UsuarioBaseController;
import com.snowmatch.visao.interfaces.IUsuarioBaseController;
import java.util.List;
import java.util.UUID;

@SnowRestController
public class UsuarioController extends UsuarioBaseController implements IUsuarioBaseController {

    @Override
    public void incluir(Usuario usuario) {
        this.usuarioSd.incluir(usuario);
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
