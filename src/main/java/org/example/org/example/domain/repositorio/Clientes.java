package org.example.org.example.domain.repositorio;

import org.example.org.example.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public  interface Clientes extends JpaRepository <Cliente, Integer> {
//select c from cliente c where c.nome like :nome (Query Methods)
    //    caso eu não utilize a conteção do Query Methods
//    @Query(value= "select c from Cliente where c.nome like :nome")
//    com sql nativo sem ser hql:
    @Query(value = " select * from cliente c where c.nome like '%:nome%'", nativeQuery = true)
////    O @Param referencia o nome do parâmetro na Query no argumento abaixo
    List<Cliente> encontrarPorNome(@Param("nome") String nome);
//Query methods:
//     List<Cliente> findByNomeLike(@Param("nome") String nome);

    boolean existsByNome(String nome);
}
