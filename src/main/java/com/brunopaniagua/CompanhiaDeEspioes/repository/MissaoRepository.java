package com.brunopaniagua.CompanhiaDeEspioes.repository;

import com.brunopaniagua.CompanhiaDeEspioes.model.MissaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissaoRepository extends JpaRepository<MissaoModel, Long> {
}
