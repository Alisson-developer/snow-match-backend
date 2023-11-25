package com.snowmatch.dominio.repositorio;

import com.snowmatch.anotacoes.SnowRepository;
import com.snowmatch.dominio.Match;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

@SnowRepository
public interface IMatchDados extends JpaRepository<Match, UUID> {
}
