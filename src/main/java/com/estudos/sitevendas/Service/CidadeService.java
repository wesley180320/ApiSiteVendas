package com.estudos.sitevendas.Service;


import com.estudos.sitevendas.DTO.CidadeDTO;
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
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRespository;

    @Autowired
    private EstadoRepository estadoRespository;

    public Optional<Cidade> findById(Integer id){
        return cidadeRespository.findById(id);
    }

    @Transactional
    public List<Cidade> findAll(){
        return cidadeRespository.findAll();
    }


    public void delete(Integer id){
        cidadeRespository.deleteById(id);
    }

    public Cidade save (CidadeDTO cidadeDTO){
        Estado estado1 = new Estado(null,cidadeDTO.getEstado());
        Cidade cidade1 = new Cidade(null,cidadeDTO.getNome(),estado1);
        estado1.getCidades().add(cidade1);
        estadoRespository.save(estado1);
        return cidadeRespository.save(cidade1);
    }

    public Cidade put (Integer id, CidadeDTO cidadeDTO){
        Optional<Cidade> c1 = cidadeRespository.findById(id);
        Estado estadoUpdate = estadoRespository.findByNome(cidadeDTO.getEstado());
        Cidade cidadeUpdate = c1.get();
        cidadeUpdate.setNome(cidadeDTO.getNome());
        cidadeUpdate.setEstado(estadoUpdate);
        return cidadeRespository.save(cidadeUpdate);
    }

}
