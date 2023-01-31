package com.estudos.sitevendas.controller;

import com.estudos.sitevendas.DTO.CategoriaDTO;
import com.estudos.sitevendas.Service.CategoriaService;
import com.estudos.sitevendas.Service.ProdutoService;
import com.estudos.sitevendas.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    ProdutoService produtoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> findById (@PathVariable Integer id){

        Optional<Categoria> categoria = categoriaService.findById(id);

        if(!categoria.isPresent()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id Não Encontrado" + id);
        }

        return ResponseEntity.ok().body(categoria);

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Object> save(@RequestBody @Valid Categoria categoria){


        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody @Valid Categoria categoria){


        Optional<Categoria> categoriaOptional = categoriaService.findById(id);


        if (!categoriaOptional.isPresent()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado " + id);

        }

        Categoria categoria1 = categoriaOptional.get();

        categoria1.setNome(categoria.getNome());

        categoriaService.save(categoria1);

        return ResponseEntity.ok().body(categoria1);

    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteById(@PathVariable Integer id){

        Optional<Categoria> categoriaOptional = categoriaService.findById(id);

        if (!categoriaOptional.isPresent()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado " + id);

        }

        categoriaService.delete(id);

        return ResponseEntity.ok().body("Id Deletado " + id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<CategoriaDTO>> findAll (){

        List<Categoria> categoria = categoriaService.findAll();

        List<CategoriaDTO> categoriaDTOS = categoria.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(categoriaDTOS);

    }

    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<CategoriaDTO>> findPage (
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction){

        Page<Categoria> categoria = categoriaService.findPage(page,linesPerPage,orderBy,direction);

        Page<CategoriaDTO> categoriaDTOS = categoria.map(obj -> new CategoriaDTO(obj));

        return ResponseEntity.ok().body(categoriaDTOS);

    }



}
