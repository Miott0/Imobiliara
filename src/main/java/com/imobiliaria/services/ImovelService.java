package com.imobiliaria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.imobiliaria.entities.Cliente;
import com.imobiliaria.entities.Corretor;
import com.imobiliaria.entities.Endereco;
import com.imobiliaria.entities.Imovel;
import com.imobiliaria.repository.Clientes;
import com.imobiliaria.repository.Corretors;
import com.imobiliaria.repository.Enderecos;
import com.imobiliaria.repository.Imovels;

@Service
public class ImovelService {

	@Autowired
	private Imovels imovels;
	@Autowired
	private Enderecos enderecos;
	@Autowired
	private Clientes clientes;
	@Autowired
	private Corretors corretors;




	public void ciar(Imovel imovel, int id_endereco, int id_cliente) {

		Endereco endereco = enderecos.findById(id_endereco).orElseThrow();
		Cliente cliente = clientes.findById(id_cliente).orElseThrow();

		imovel.setCliente(cliente);
		imovel.setEndereco(endereco);
		cliente.setImovel(imovel);
		clientes.save(cliente);

		imovels.save(imovel);
	}

	public Imovel registrarCorretor(int id_corretor, int id_imovel) {

		Imovel imovel = imovels.findById(id_imovel).orElseThrow();
		Corretor corretor = corretors.findById(id_corretor).orElseThrow();
		if (corretor.getAprovado() == true) {
			imovel.setCorretor(corretor);
			imovels.save(imovel);
			corretor.cadastrarImovel(imovel);
			return imovel;
		}
		return imovel;

	}

	public Imovel buscar(int id) {
		return imovels.findById(id).orElseThrow();
	}

	public List<Imovel> retornarImovels() {
		return imovels.findAll();
	}

	public void deletar(int id) {
		imovels.deleteById(id);
	}

	public void atualizarImovel(Integer id, Imovel novoImovel) {
		Imovel antigoImovel = imovels.findById(id).orElseThrow();
		novoImovel.setId(novoImovel.getId());
		imovels.save(novoImovel);
	}

    
    public void definirStatus(int id_imovel) {
        Imovel imovel= imovels.findById(id_imovel).orElseThrow();
        imovel.DefinirStatus();
        imovels.save(imovel);  
    }

    
    public void validarImovel(int id_imovel) {
        Imovel imovel= imovels.findById(id_imovel).orElseThrow();
        imovel.ValidarImovel();
        imovels.save(imovel); 
    }

}