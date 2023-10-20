package com.imobiliaria.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imobiliaria.entities.Endereco;
import com.imobiliaria.repository.Enderecos ;

@Service
public class EnderecoService {

    @Autowired
	private Enderecos enderecos;
	
	public void criar(Endereco endereco) {
		enderecos.save(endereco);
	}

	public Endereco buscar(int id) {
		return enderecos.findById(id).orElseThrow();
	}
	
	
	public List<Endereco> retornarEndereco() {
		return enderecos.findAll();
	}
	
	
	public void deletar(int id) {
		enderecos.deleteById(id);
	}
	
	public void atualizarEndereco(Integer id, Endereco novoEndereco) {
		Endereco antigoEndereco = enderecos.findById(id).orElseThrow();
		novoEndereco.setId(antigoEndereco.getId());
		enderecos.save(novoEndereco);
	}
    
}
