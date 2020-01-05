package moobie.test;

import moobie.dao.CarroPessoaDAO;
import moobie.entidade.CarroPessoa;

import org.junit.Assert;
import org.junit.Test;

public class CarroPessoaTest {
	
	CarroPessoa	 entidade;
	CarroPessoaDAO dao;
	
	//integracao
	CarroTest carro;
	PessoaTest pessoa;
	
	@Test 
	public CarroPessoa create() throws Exception {
    //teste de criaçao
		carro.create();
		pessoa.create();
		
		 entidade = new CarroPessoa(carro.getEntidade() , pessoa.getEntidade());
		 
		 //verifica se o vinculo foi criado corretamente, havendo carro e pessoa
		 if (entidade != null){
			 Assert.assertTrue(entidade.getCarro() != null); 
			 Assert.assertTrue(entidade.getPessoa() != null);
		 }

		 return entidade;
	}

	public CarroPessoa getEntidade() {
		return entidade;
	}

	public void setEntidade(CarroPessoa entidade) {
		this.entidade = entidade;
	}
	
	
	
}
