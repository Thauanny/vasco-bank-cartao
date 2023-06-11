package com.VascoBankCartao.VascoBankCartaoart.repository;

import org.springframework.stereotype.Repository;

import com.VascoBankCartao.VascoBankCartaoart.models.CartaoCredito;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface CartaoRepository extends JpaRepository<CartaoCredito, Integer> {

    @Query(value = "SELECT * FROM COMPRA WHERE id_cartao = :cartaoId", nativeQuery = true)
    public List<CartaoCredito> findAllById(@Param("cartaoId") Integer cartaoId);

}
