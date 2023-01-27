package com.estudos.sitevendas.Service;


import com.estudos.sitevendas.Repository.CategoriaRepository;
import com.estudos.sitevendas.model.Categoria;
import com.estudos.sitevendas.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {


    @Autowired
    private CategoriaRepository categoriaRepository;


    public Optional<Categoria> findById(Integer id) {
        return  categoriaRepository.findById(id);

    }

    public Categoria save (Categoria categoria){

        return categoriaRepository.save(categoria);
    }

    public List<Categoria> findAll(){

        return categoriaRepository.findAll();
    }

    public void delete(Integer id){

        categoriaRepository.deleteById(id);

    }
}
