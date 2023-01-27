package com.estudos.sitevendas.Service;


import com.estudos.sitevendas.Repository.ProdutoRepository;
import com.estudos.sitevendas.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public Optional<Produto> findById(Integer id){

        return  produtoRepository.findById(id);

    }

    public Produto save (Produto produto){

        return  produtoRepository.save(produto);
    }


    public void delete (Integer id){
        produtoRepository.deleteById(id);

    }

    public List<Produto> findAll(){

        return produtoRepository.findAll();

    }
}
