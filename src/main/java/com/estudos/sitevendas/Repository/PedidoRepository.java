package com.estudos.sitevendas.Repository;

import com.estudos.sitevendas.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository  extends JpaRepository<Pedido, Integer> {
}
