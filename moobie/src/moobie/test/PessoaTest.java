package moobie.test;

import java.sql.Date;
import java.util.List;

import moobie.dao.PessoaDAO;
import moobie.entidade.Pessoa;

import org.junit.Test;

public class PessoaTest {
	Pessoa	  entidade;
	PessoaDAO Dao;
	
	
	@Test 
	public Pessoa create() throws Exception {
    //teste de criaçao
		 entidade = new Pessoa(-1, "Pessoa Teste", Date.valueOf("2020-01-01"), "123456789", "12345678901", "123456789");

		 return entidade;
	}
	
	@Test
	public void updateTest() throws Exception {

		entidade = create();		
		
		entidade.setNome("NOVO NOME");
		entidade.setRg("987654321");
		
		Dao.editPessoa(entidade);
		
	}
	
	 @Test
	 public void testList() throws Exception{
		 final List<Pessoa> pessoaList = Dao.listarPessoas();
		 
		System.out.println(pessoaList);
		 
	 }

}
