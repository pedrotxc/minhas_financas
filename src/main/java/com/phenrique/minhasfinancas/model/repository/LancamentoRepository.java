package com.phenrique.minhasfinancas.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.phenrique.minhasfinancas.model.entity.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

}
