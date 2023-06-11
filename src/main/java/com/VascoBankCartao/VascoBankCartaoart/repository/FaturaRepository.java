
package com.VascoBankCartao.VascoBankCartaoart.repository;

import org.springframework.stereotype.Repository;
import com.VascoBankCartao.VascoBankCartaoart.models.Fatura;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Integer>{
    @Query(value = "SELECT * FROM FATURA WHERE id_cartao = :cartaoId",  nativeQuery = true)
    public List<Fatura> retornarFaturas(@Param("cartaoId") Integer cartaoId);
}
