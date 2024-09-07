package com.estudos.sitevendas.controller;

import com.estudos.sitevendas.DTO.CidadeDTO;
import com.estudos.sitevendas.Service.CidadeService;
import com.estudos.sitevendas.model.Cidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Object> findAll (){
        List<Cidade> cidade = cidadeService.findAll();
        return ResponseEntity.ok().body(cidade);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> findById(@PathVariable Integer id){
        Optional<Cidade> cidade = cidadeService.findById(id);
        return  ResponseEntity.ok().body(cidade);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Object> save(@RequestBody  @Valid CidadeDTO cidade){
        return ResponseEntity.status(HttpStatus.CREATED).body(cidadeService.save(cidade));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(Integer id){
        Optional<Cidade> obj = cidadeService.findById(id);
        if(!obj.isPresent()){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id" + id + "Não Encontrado");
        }
        cidadeService.delete(id);
        return ResponseEntity.ok().body("Id deletado" + id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody @Valid CidadeDTO cidadeDTO){
         Optional<Cidade> cidadeOptional = cidadeService.findById(id);
        if(!cidadeOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado");
        }
        return ResponseEntity.ok().body(cidadeService.put(id, cidadeDTO));
    }
}
