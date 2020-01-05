package moobie.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import moobie.entidade.Carro;
import moobie.entidade.CarroDisponibilidade;


public class CarroDisponibilidadeDAO {
	
	public Carro carro;
	
	public CarroDisponibilidade d1 = new CarroDisponibilidade(getCarro(), Date.valueOf("2020-01-06"), Time.valueOf("09:00:00"),  Time.valueOf("12:00:00"));
	public CarroDisponibilidade d2 = new CarroDisponibilidade(getCarro(), Date.valueOf("2020-01-07"), Time.valueOf("08:30:00"),  Time.valueOf("12:00:00"));
	public CarroDisponibilidade d3 = new CarroDisponibilidade(getCarro(), Date.valueOf("2020-01-08"), Time.valueOf("14:00:00"),  Time.valueOf("18:00:00"));
	
	public List<CarroDisponibilidade> listarDisponibilidadePorCarro(Carro carro) throws Exception {
		List<CarroDisponibilidade> listaDisponibilidade = new ArrayList<>();
		
		//simula lista de disponibilidade 
		setCarro(carro);
		
		listaDisponibilidade.add(d1);	                
        listaDisponibilidade.add(d2);                
        listaDisponibilidade.add(d3);
		
		return listaDisponibilidade;
		
	}
	
	public CarroDisponibilidade buscarDisponibilidadePorDataHora(Carro carro, Date data, Time hora_ini, Time hora_fim) throws Exception{
		List<CarroDisponibilidade> lista = new ArrayList<>();
		CarroDisponibilidade disponibilidade = null;
		
		lista = listarDisponibilidadePorCarro(carro);
		
		//faz uma busca simples nos objetos criados em memória
		for (CarroDisponibilidade d: lista){
			//verifica se a data escolhida é igual a data da disponibilidade
			//e se o horário inicial e final está dentro do horário da disponibilidade
			if ((d.getData() == data) && ((d.getHora_ini().getTime()) <= (hora_ini.getTime())) && 
					(d.getHora_fim().getTime()) >= (hora_fim.getTime())){
				disponibilidade = d;
			}
		}
		
		return disponibilidade;
	}
	
	public int addDisponibilidade(CarroDisponibilidade disponibilidade) throws Exception{
		int idGerado = 0;
		Random gerador = new Random();
		
		System.out.println("Inserindo disponibilidade: " + disponibilidade.getCarro() + " Data: " + disponibilidade.getData() + 
				" Hora ini: " + disponibilidade.getHora_ini() + " Hora fim: " + disponibilidade.getHora_fim());
		
		//gera int randomico para simular id inserido.
		idGerado = gerador.nextInt();				
		
		return idGerado; 
	}
	
	public void editDisponibilidade(CarroDisponibilidade disponibilidade, int id) throws Exception{
		System.out.println("Editando disponibilidade: id: " + id + disponibilidade.getCarro() + " Data: " + disponibilidade.getData() + 
				" Hora ini: " + disponibilidade.getHora_ini() + " Hora fim: " + disponibilidade.getHora_fim());
	}
	
	public void deleteDisponibilidade(int id) throws Exception{
		System.out.println("Deletando disponibilidade: id: " + id);
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public CarroDisponibilidade getD1() {
		return d1;
	}

	public void setD1(CarroDisponibilidade d1) {
		this.d1 = d1;
	}

	public CarroDisponibilidade getD2() {
		return d2;
	}

	public void setD2(CarroDisponibilidade d2) {
		this.d2 = d2;
	}

	public CarroDisponibilidade getD3() {
		return d3;
	}

	public void setD3(CarroDisponibilidade d3) {
		this.d3 = d3;
	}
	
	

}
