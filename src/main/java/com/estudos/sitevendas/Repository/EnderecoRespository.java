package com.estudos.sitevendas.Repository;

import com.estudos.sitevendas.model.Categoria;
import com.estudos.sitevendas.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRespository extends JpaRepository<Endereco,Integer> {


    @Query(value = " select * from cliente c where c.name like '%:name%' ", nativeQuery = true)
    List<Endereco> encontrarPorNome(@Param("name") String name);


}
