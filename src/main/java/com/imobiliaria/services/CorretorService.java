package com.imobiliaria.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imobiliaria.entities.Corretor;
import com.imobiliaria.repository.Corretors;

@Service
public class CorretorService {

    @Autowired
	private Corretors corretors;
	
	public void criar(Corretor corretor) {
		corretors.save(corretor);
	}

	public Corretor buscar(int id) {
		return corretors.findById(id).orElseThrow();
	}
	
	
	public List<Corretor> retornarcorretors() {
		return corretors.findAll();
	}
	
	
	public void deletar(int id) {
		corretors.deleteById(id);
	}
	
	public void atualizarCorretor(Integer id, Corretor novoCorretor) {
		Corretor antigoCorretor = corretors.findById(id).orElseThrow();
		novoCorretor.setId(antigoCorretor.getId());
		corretors.save(novoCorretor);
	}
    
}
