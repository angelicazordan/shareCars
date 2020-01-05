package moobie.test;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import moobie.dao.CarroDisponibilidadeDAO;
import moobie.entidade.CarroDisponibilidade;

public class CarroDisponibilidadeTest {
	
	CarroDisponibilidade    entidade;
	CarroDisponibilidadeDAO dao;
	
	//integracao
	CarroTest carro;
	
	@Test 
	public CarroDisponibilidade create() throws Exception {
    //teste de criaçao
		carro.create();
				
		entidade = new CarroDisponibilidade(carro.getEntidade(), Date.valueOf("2020-01-06"), Time.valueOf("09:00:00"),  Time.valueOf("12:00:00"));
		 
		 Assert.assertTrue(entidade != null);

		 return entidade;
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void dataInvalidaTest() throws Exception{
	//teste falho com datas inválidas	
		entidade = create();	
				
		//stub para teste falho
		Date dataAtual = new Date(new java.util.Date().getDate());
		
		
		entidade.setData(Date.valueOf("1999-01-06"));
		
		dao.editDisponibilidade(entidade, -1);
		
		
		if (entidade != null) {
			Assert.assertTrue(entidade.getData().getDate() >= dataAtual.getDate());
		}
		
	}
	
	@Test
	public void horaInvalidaTest() throws Exception{
	//teste falho com horas inválidas	
		entidade = create();			
		
		entidade.setHora_ini(Time.valueOf("18:00:00"));
		entidade.setHora_fim(Time.valueOf("09:00:00"));
		
		dao.editDisponibilidade(entidade, -1);
		
		
		if (entidade != null) {
			//a hora final deve ser maior que a hora inicial
			Assert.assertTrue(entidade.getHora_fim().getTime() > entidade.getHora_ini().getTime());
		}
		
	}
	
	@Test
	public void updateTest() throws Exception{
	//teste de edicao
		entidade = create();			
		
		entidade.setHora_ini(Time.valueOf("09:00:00"));
		entidade.setHora_fim(Time.valueOf("18:30:00"));
		
		dao.editDisponibilidade(entidade, -1);
		
		
		if (entidade != null) {
			//a hora final deve ser maior que a hora inicial
			Assert.assertTrue(entidade.getHora_fim().getTime() > entidade.getHora_ini().getTime());
		}
		
	}
	
	@Test
	 public void testList() throws Exception{
	 //teste de listagem	
		entidade = create();
		
		final List<CarroDisponibilidade> dispList = dao.listarDisponibilidadePorCarro(entidade.getCarro());
		 
		Assert.assertTrue(dispList != null);
		 
		System.out.println(dispList);
		 
	 }

	public CarroDisponibilidade getEntidade() {
		return entidade;
	}

	public void setEntidade(CarroDisponibilidade entidade) {
		this.entidade = entidade;
	}
	

}
