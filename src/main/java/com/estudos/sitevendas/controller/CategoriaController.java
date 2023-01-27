package com.estudos.sitevendas.controller;

import com.estudos.sitevendas.DTO.CidadeDTO;
import com.estudos.sitevendas.Service.CategoriaService;
import com.estudos.sitevendas.model.Categoria;
import com.estudos.sitevendas.model.Cidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Object> findAll (){

        List<Categoria> categoria = categoriaService.findAll();

        return ResponseEntity.ok().body(categoria);

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Object> save(@RequestBody @Valid Categoria categoria){

        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
    }

}
