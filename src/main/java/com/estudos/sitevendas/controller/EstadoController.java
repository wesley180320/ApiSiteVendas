package com.estudos.sitevendas.controller;

import com.estudos.sitevendas.DTO.EstadoDTO;
import com.estudos.sitevendas.Service.CidadeService;
import com.estudos.sitevendas.Service.EstadoService;
import com.estudos.sitevendas.model.Cidade;
import com.estudos.sitevendas.model.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/estado")
public class EstadoController {



    @Autowired
    private EstadoService estadoService;

    @Autowired
    private CidadeService cidadeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Object> findAll(){

        List<Estado> estado = estadoService.findAll();

        return ResponseEntity.ok().body(estado);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Object> save(@RequestBody @Valid EstadoDTO estado){


        return ResponseEntity.status(HttpStatus.CREATED).body(estadoService.save(estado));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public  ResponseEntity<Object> deleteById(@PathVariable Integer id){

        Optional<Estado> obj = estadoService.findById(id);

        if(!obj.isPresent()){

           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id" + id + "não encontrado");

        }
            estadoService.delete(id);
            return ResponseEntity.ok().body("Id deletado com sucesso" + id);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> findById( @PathVariable Integer id){


        Optional<Estado> estado = estadoService.findById(id);

        if(!estado.isPresent()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O estado " + id + "não exite.");
        }

        return ResponseEntity.ok().body(estado);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> findById( @PathVariable Integer id, @RequestBody @Valid EstadoDTO estadoDTO){

        Optional<Estado> estado = estadoService.findById(id);

        if(!estado.isPresent()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O estado " + id + "não exite.");
        }


        estadoService.put(estadoDTO, estado);

        return ResponseEntity.ok().body(estadoDTO);
    }

}
