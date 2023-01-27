package com.estudos.sitevendas.Service;


import com.estudos.sitevendas.DTO.EstadoDTO;
import com.estudos.sitevendas.Repository.CidadeRepository;
import com.estudos.sitevendas.Repository.EstadoRepository;
import com.estudos.sitevendas.model.Cidade;
import com.estudos.sitevendas.model.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRespository;


    @Autowired
    private CidadeRepository cidadeRespository;

    public Optional<Estado> findById(Integer id){

        return estadoRespository.findById(id);

    }

    @Transactional
    public Estado save(EstadoDTO estadoDTO){

        Cidade cidade = new Cidade();

        Estado estado1 = new Estado(null, estadoDTO.getNome());

        cidade.setEstado(estado1);

        estadoDTO.getCidades().forEach(it ->

                cidade.setNome(it.getNome())

        );

        cidadeRespository.save(cidade);

        return estadoRespository.save(estado1);

    }

    public List<Estado> findAll(){

        return estadoRespository.findAll();

    }

    public void delete(Integer id){

        estadoRespository.deleteById(id);
    }

    public void put (EstadoDTO estadoDTO, Optional<Estado> estado){


        // Tu ta aqui dnv mano?
        // Continue assim.....
        // Falta pouco garoto.

        Cidade cidade = new Cidade();

        Estado estado1 = estado.get();

        estado1.setNome(estadoDTO.getNome());
        estado1.setCidades(estadoDTO.getCidades());

        cidade.setEstado(estado1);

        estado1.getCidades().forEach(it ->

                cidade.setNome(it.getNome())

        );

        estado1.setCidades(estadoDTO.getCidades());

        estadoRespository.save(estado1);
        cidadeRespository.save(cidade);


    }


}
