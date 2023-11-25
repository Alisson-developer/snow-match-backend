package com.snowmatch.dominio.servico;

import com.snowmatch.dominio.Usuario;
import com.snowmatch.dominio.dto.AutenticacaoDTO;
import com.snowmatch.dominio.dto.LoginDTO;
import com.snowmatch.dominio.dto.UsuarioDTO;
import com.snowmatch.dominio.servico.base.UsuarioBaseSd;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioSd extends UsuarioBaseSd {

    @Override
    public ResponseEntity<LoginDTO> incluir(Usuario usuario) {
        if (usuarioDados.findByNome(usuario.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT.value()).build();
        }
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        usuarioDados.save(usuario);
        String token = tokenSd.gerarToken(usuario);
        return ResponseEntity.status(HttpStatus.OK).body(new LoginDTO(token));
    }

    @Override
    public ResponseEntity<LoginDTO> login(AutenticacaoDTO autenticacaoDTO) {
        var loginSenha = new UsernamePasswordAuthenticationToken(autenticacaoDTO.nome(), autenticacaoDTO.senha());
        Authentication autenticacao = this.gerenciadorDeAutenticacao.authenticate(loginSenha);

        String token = tokenSd.gerarToken((Usuario) autenticacao.getPrincipal());
        System.out.println(token);
        return ResponseEntity.status(HttpStatus.OK).body(new LoginDTO(token));
    }

    public List<UsuarioDTO> obterTodosAtivos() {
        return this.obterTodos();
    }

    @Override
    public UsuarioDTO obterPorId(UUID idUsuario) {
        return usuarioDados.findById(idUsuario).map(UsuarioDTO::new).stream().findFirst().orElseThrow();
    }
}
