package moobie.test;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import moobie.dao.AgendaCarroDAO;
import moobie.entidade.AgendaCarro;
import moobie.entidade.Carro;
import moobie.entidade.CarroDisponibilidade;

import org.junit.Assert;
import org.junit.Test;

public class AgendaCarroTest {
	AgendaCarro    entidade;
	AgendaCarroDAO dao;
	
	//integracao
	PessoaTest pessoa;
	CarroPessoaTest carro;
	CarroDisponibilidadeTest disponibilidade;
	
	@Test 
	public AgendaCarro create() throws Exception {
    //teste de criaçao
		pessoa.create(); //cria um novo objeto pra ser o locatario
		carro.create(); //carro e pessoa já vinculados
		disponibilidade.create(); //disponibilidade do carro;
		
		 entidade = new AgendaCarro(-1, pessoa.getEntidade(), carro.getEntidade(), Date.valueOf("2020-01-06"), Time.valueOf("09:30:00"),
				 Time.valueOf("12:00:00"), 1);

		 return entidade;
	}
	
	 @Test
	 public void disponibilidadeValidaTest() throws Exception{
	 //teste de criacao válida	 
		 entidade = create();
		 
		 CarroDisponibilidade disp = disponibilidade.getEntidade();
		 Boolean disponivel = true;
	 
	     //Não deve ser possível agendar um carro em uma data não disponível
		 if ((disp.getData() == entidade.getData()) && ((disp.getHora_ini().getTime()) <= (entidade.getHora_ini().getTime())) && 
					(disp.getHora_fim().getTime()) >= (entidade.getHora_fim().getTime())){
			 disponivel = true;
		 }else{
			 disponivel = false; 
		 }
		 
		 Assert.assertEquals(disponivel, true);
		 
	 }
	 
	 @Test
	 public void disponibilidadeInvalidaTest() throws Exception{
	 //teste de edicao inválida	 
		 entidade = create();
		 
		 CarroDisponibilidade disp = disponibilidade.getEntidade();
		 Boolean disponivel = true;
		 
		 entidade.setData(Date.valueOf("2019-01-01"));
		 
		 dao.editAgendamento(entidade, -1);
		 
	     //Não deve ser possível agendar um carro em uma data não disponível
		 if ((disp.getData() == entidade.getData()) && ((disp.getHora_ini().getTime()) <= (entidade.getHora_ini().getTime())) && 
					(disp.getHora_fim().getTime()) >= (entidade.getHora_fim().getTime())){
			 disponivel = true;
		 }else{
			 disponivel = false; 
		 }
		 
		 Assert.assertEquals(disponivel, true);
		 
	 }
	
	
	
	 @Test
	 public void testList() throws Exception{
	 //teste de listagem
		 entidade = create();
		 
		 final List<AgendaCarro> agendaList = dao.listarAgendamentos();
		 
		 Assert.assertTrue(agendaList != null);
		
		 System.out.println(agendaList);
		 
	 }
	 
	 @Test
	 public void testListPorCarro() throws Exception{
	 //teste de listagem por carro
		 entidade = create();
		 
		 Carro carro = disponibilidade.getEntidade().getCarro();
		 
		 final List<AgendaCarro> agendaList = dao.listarAgendamentosPorCarro(carro);
		 
		 Assert.assertTrue(agendaList != null);
		
		 System.out.println(agendaList);
		 
	 }


}
