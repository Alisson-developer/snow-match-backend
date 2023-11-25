package com.snowmatch.visao;

import com.snowmatch.anotacoes.SnowRequestMapping;
import com.snowmatch.anotacoes.SnowRestController;
import com.snowmatch.dominio.Usuario;
import com.snowmatch.dominio.dto.AutenticacaoDTO;
import com.snowmatch.dominio.dto.LoginDTO;
import com.snowmatch.dominio.dto.UsuarioDTO;
import com.snowmatch.visao.base.UsuarioBaseController;
import com.snowmatch.visao.interfaces.IUsuarioBaseController;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;

@SnowRestController
@SnowRequestMapping("usuario")
public class UsuarioController extends UsuarioBaseController implements IUsuarioBaseController {

    @Override
    public ResponseEntity<LoginDTO> incluir(Usuario usuario) {
        return this.usuarioSd.incluir(usuario);
    }

    @Override
    public ResponseEntity<LoginDTO> login(AutenticacaoDTO autenticacaoDTO) {
        return this.usuarioSd.login(autenticacaoDTO);
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
