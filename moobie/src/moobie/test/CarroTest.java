package moobie.test;

import java.util.List;

import moobie.dao.CarroDAO;
import moobie.entidade.Carro;

import org.junit.Test;

public class CarroTest {
		Carro	 entidade;
		CarroDAO Dao;
		
		
		@Test 
		public Carro create() throws Exception {
	    //teste de criaçao
			 entidade = new Carro(-1, "Marca Teste", "Modelo Teste", 2020, "Categoria Teste");

			 return entidade;
		}
		
		@Test
		public void updateTest() throws Exception {

			entidade = create();		
			
			entidade.setMarca("NOVA MARCA");
			entidade.setModelo("NOVO MODELO");
			
			Dao.editCarro(entidade);
			
		}
		
		 @Test
		 public void testList() throws Exception{
			 final List<Carro> carroList = Dao.listarCarros();
			 
			System.out.println(carroList);
			 
		 }

}
