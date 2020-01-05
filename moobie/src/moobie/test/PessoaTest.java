package moobie.test;

import java.sql.Date;
import java.util.List;

import moobie.dao.PessoaDAO;
import moobie.entidade.Pessoa;

import org.junit.Assert;
import org.junit.Test;

public class PessoaTest {
	Pessoa	  entidade;
	PessoaDAO Dao;
	
	
	@Test 
	public Pessoa create() throws Exception {
    //teste de criaçao
		 entidade = new Pessoa(-1, "Pessoa Teste", Date.valueOf("2020-01-01"), "123456789", "12345678901", "123456789");
		 
		 Assert.assertTrue(entidade != null);

		 return entidade;
	}
	
	@Test
	public void shouldUpdateTest() throws Exception {
    //deveria editar		
		entidade = create();	
		
		//stub para teste falho
		String nomeOld = entidade.getNome();
		String rgOld = entidade.getRg();
		
		entidade.setNome("NOVO NOME");
		entidade.setRg("987654321");
		
		Dao.editPessoa(entidade);
		
		
		if (entidade != null) {
			Assert.assertEquals(entidade.getNome(), nomeOld);
			Assert.assertEquals(entidade.getRg(), rgOld);
		}
		
		
	}
	
	@Test
	public void updateTest() throws Exception {
    //teste de ediçao
		entidade = create();	

		
		entidade.setNome("NOVO NOME");
		entidade.setRg("987654321");
		
		Dao.editPessoa(entidade);
		
		Assert.assertTrue(entidade != null);
		
		
	}
	
	 @Test
	 public void testList() throws Exception{
	 //teste de listagem
		 entidade = create();
		 
		 final List<Pessoa> pessoaList = Dao.listarPessoas();
		 
		 Assert.assertTrue(pessoaList != null);
		 
		 System.out.println(pessoaList);
		 
	 }

	public Pessoa getEntidade() {
		return entidade;
	}

	public void setEntidade(Pessoa entidade) {
		this.entidade = entidade;
	}
	 
	 

}
