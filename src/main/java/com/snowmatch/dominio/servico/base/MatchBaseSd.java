package com.snowmatch.dominio.servico.base;

import com.snowmatch.anotacoes.SnowAutowired;
import com.snowmatch.anotacoes.SnowService;
import com.snowmatch.dominio.repositorio.IMatchDados;
import java.util.UUID;

@SnowService
public abstract class MatchBaseSd {

    @SnowAutowired
    protected IMatchDados matchDados;

    protected abstract void curtir(UUID uuidUsuario);

    protected abstract void darMatch(UUID uuidMatch);

}
