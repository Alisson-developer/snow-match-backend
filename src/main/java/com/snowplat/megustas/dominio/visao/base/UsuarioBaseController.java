package com.snowplat.megustas.dominio.visao.base;

import com.snowplat.megustas.dominio.servico.UsuarioSd;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class UsuarioBaseController {

    @Autowired
    protected UsuarioSd usuarioSd;

}
