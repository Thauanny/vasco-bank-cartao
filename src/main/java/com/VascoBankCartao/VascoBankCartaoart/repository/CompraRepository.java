
package com.VascoBankCartao.VascoBankCartaoart.repository;

import org.springframework.stereotype.Repository;
import com.VascoBankCartao.VascoBankCartaoart.models.Compra;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer>{
    @Query(value = "SELECT * FROM COMPRA WHERE id_cartao = :cartaoId",  nativeQuery = true)
    public List<Compra> retornarCompras(@Param("cartaoId") Integer cartaoId);
}
