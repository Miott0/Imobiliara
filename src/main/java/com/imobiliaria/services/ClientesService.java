package com.imobiliaria.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imobiliaria.entities.Cliente;
import com.imobiliaria.repository.Clientes;

@Service
public class ClientesService {

    @Autowired
	private Clientes clientes;
	
	public void criar(Cliente cliente) {
		clientes.save(cliente);
	}

	public Cliente buscar(int id) {
		return clientes.findById(id).orElseThrow();
	}
	
	
	public List<Cliente> retornarClientes() {
		return clientes.findAll();
	}
	
	
	public void deletar(int id) {
		clientes.deleteById(id);
	}
	
	public void atualizarCliente(Integer id, Cliente novoCliente) {
		Cliente antigoCliente = clientes.findById(id).orElseThrow();
		novoCliente.setId(antigoCliente.getId());
		clientes.save(novoCliente);
	}
    
}
