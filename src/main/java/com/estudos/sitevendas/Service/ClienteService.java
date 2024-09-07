package com.estudos.sitevendas.Service;

import com.estudos.sitevendas.DTO.ClienteDTO;
import com.estudos.sitevendas.Repository.ClienteRepository;
import com.estudos.sitevendas.Repository.EnderecoRespository;
import com.estudos.sitevendas.model.Categoria;
import com.estudos.sitevendas.model.Cidade;
import com.estudos.sitevendas.model.Cliente;
import com.estudos.sitevendas.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRespository enderecoRespository;

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

    @Transactional
    public Cliente clienteFromDto(ClienteDTO clienteDTO){

        Cliente cliente = new Cliente(null, clienteDTO.getNome(), clienteDTO.getEmail(), clienteDTO.getCpfOuCnpj(), clienteDTO.getTipoCliente());

        Cidade cidade = new Cidade(clienteDTO.getId(), null, null);

        Endereco endereco = new Endereco(null, clienteDTO.getLogradouro(),clienteDTO.getNumero(),clienteDTO.getComplemento(),clienteDTO.getBairro(),clienteDTO.getCep(),cidade, cliente);

        cliente.getEnderecos().add(endereco);

        enderecoRespository.save(endereco);


        return cliente;
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){


        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);


        return clienteRepository.findAll(pageRequest);
    }

}
