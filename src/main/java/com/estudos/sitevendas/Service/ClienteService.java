package com.estudos.sitevendas.Service;

import com.estudos.sitevendas.Repository.ClienteRepository;
import com.estudos.sitevendas.model.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public Optional<Cliente> findByid(Integer id){

        Optional<Cliente> cliente = clienteRepository.findById(id);

        return  cliente;

    }

    public Cliente save(Cliente cliente){

        return clienteRepository.save(cliente);

    }


    public List<Cliente> findAll(){

        return clienteRepository.findAll();

    }


    public void delete(Integer id){
        clienteRepository.deleteById(id);

    }

}
