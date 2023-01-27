package com.estudos.sitevendas.controller;


import com.estudos.sitevendas.DTO.EstadoDTO;
import com.estudos.sitevendas.Service.ProdutoService;
import com.estudos.sitevendas.model.Estado;
import com.estudos.sitevendas.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/produto")
public class ProdutoController {


    @Autowired
    private ProdutoService produtoService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Object> findAll(){

        List<Produto> produto = produtoService.findAll();

        return ResponseEntity.ok().body(produto);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Object> save(@RequestBody @Valid Produto produto){


        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.save(produto));
    }



}
