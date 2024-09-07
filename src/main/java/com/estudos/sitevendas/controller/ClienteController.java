package com.estudos.sitevendas.controller;


import com.estudos.sitevendas.DTO.CategoriaDTO;
import com.estudos.sitevendas.DTO.ClienteDTO;
import com.estudos.sitevendas.Service.ClienteService;
import com.estudos.sitevendas.model.Categoria;
import com.estudos.sitevendas.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/cliente")
public class ClienteController {


    @Autowired
    private ClienteService clienteService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> findById(@PathVariable Integer id){

        Optional<Cliente> cliente = clienteService.findByid(id);

        if(!cliente.isPresent()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente nao encontrado");

        }
        return ResponseEntity.ok().body(cliente);

    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteById(@PathVariable Integer id){

        Optional<Cliente> cliente = clienteService.findByid(id);

        if(!cliente.isPresent()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente nao encontrado");

        }
        clienteService.delete(id);

        return ResponseEntity.ok().body("Id deletado" + id);

    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> update(@PathVariable Integer id, @Valid @RequestBody ClienteDTO clienteDTO){

        Optional<Cliente> cliente = clienteService.findByid(id);

        if(!cliente.isPresent()){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente nao encontrado");

        }

        Cliente find = cliente.get();

        find.setNome(clienteDTO.getNome());
        find.setEmail(clienteDTO.getEmail());

        clienteService.save(find);

        return ResponseEntity.ok().body("Id deletado" + id);

    }


    @RequestMapping(value = "/page", method = RequestMethod.GET)
    public ResponseEntity<Page<ClienteDTO>> findPage (

            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction){

        Page<Cliente> clientes = clienteService.findPage(page,linesPerPage,orderBy,direction);

        Page<ClienteDTO> clienteDTOS = clientes.map(obj -> new ClienteDTO(obj));

        return ResponseEntity.ok().body(clienteDTOS);

    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Object> findPage (@RequestBody ClienteDTO clienteDTO){

        Cliente cliente = clienteService.clienteFromDto(clienteDTO);

        clienteService.save(cliente);

        return ResponseEntity.ok().body(cliente);

    }


}
