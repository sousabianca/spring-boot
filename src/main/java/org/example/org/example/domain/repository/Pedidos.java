package org.example.org.example.domain.repository;

import jdk.dynalink.linker.LinkerServices;
import org.example.org.example.domain.entity.Cliente;
import org.example.org.example.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Pedidos extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByCliente (Cliente cliente);
}
