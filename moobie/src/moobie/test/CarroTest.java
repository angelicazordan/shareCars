package moobie.test;

import java.util.List;

import moobie.dao.CarroDAO;
import moobie.entidade.Carro;

import org.junit.Assert;
import org.junit.Test;

public class CarroTest {
		Carro	 entidade;
		CarroDAO dao;
		
		
		@Test 
		public Carro create() throws Exception {
	    //teste de criaçao
			 entidade = new Carro(-1, "Marca Teste", "Modelo Teste", 2020, "Categoria Teste");
			 
			 Assert.assertTrue(entidade != null);

			 return entidade;
		}
		
		@Test
		public void shouldUpdateTest() throws Exception {
		//deveria editar 	
			entidade = create();	
			
			//stub para teste falho
			String marcaOld = entidade.getMarca();
			String modeloOld = entidade.getModelo();
			
			entidade.setMarca("NOVA MARCA");
			entidade.setModelo("NOVO MODELO");
			
			dao.editCarro(entidade);
			
			if (entidade != null) {
				Assert.assertEquals(entidade.getMarca(), marcaOld);
				Assert.assertEquals(entidade.getModelo(), modeloOld);
			}
			
			
		}
		
		@Test
		public void updateTest() throws Exception {
		//teste de edicao	
			entidade = create();		
			
			entidade.setMarca("NOVA MARCA");
			entidade.setModelo("NOVO MODELO");
			
			dao.editCarro(entidade);
			
			Assert.assertTrue(entidade != null);
			
		}
		
		 @Test
		 public void testList() throws Exception{
			 entidade = create();
			 
			 final List<Carro> carroList = dao.listarCarros();
			 
			 Assert.assertTrue(carroList != null);
			 
			 System.out.println(carroList);
			 
		 }

		public Carro getEntidade() {
			return entidade;
		}

		public void setEntidade(Carro entidade) {
			this.entidade = entidade;
		}
		 
		 

}
