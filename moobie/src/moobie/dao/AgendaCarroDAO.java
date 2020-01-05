package moobie.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import moobie.entidade.AgendaCarro;
import moobie.entidade.Carro;


public class AgendaCarroDAO {
	
	private PessoaDAO pessoaDAO = new PessoaDAO();
	private CarroPessoaDAO carroPessoaDAO = new CarroPessoaDAO();
	
	private AgendaCarro a1 = new AgendaCarro(1, pessoaDAO.getP3(), carroPessoaDAO.getCp1(), Date.valueOf("2020-01-06"), Time.valueOf("08:30:00"), 
			Time.valueOf("10:30:00"), 1);
	
	private AgendaCarro a2 = new AgendaCarro(2, pessoaDAO.getP3(), carroPessoaDAO.getCp2(), Date.valueOf("2020-01-08"), Time.valueOf("14:30:00"), 
			Time.valueOf("17:30:00"), 1);
	
	private AgendaCarro a3 = new AgendaCarro(3, pessoaDAO.getP4(), carroPessoaDAO.getCp3(), Date.valueOf("2020-01-07"), Time.valueOf("08:30:00"), 
			Time.valueOf("12:00:00"), 1);
	
	private AgendaCarro a4 = new AgendaCarro(4, pessoaDAO.getP5(), carroPessoaDAO.getCp2(), Date.valueOf("2020-01-07"), Time.valueOf("09:30:00"), 
			Time.valueOf("12:00:00"), 1);
			
	private AgendaCarro a5 = new AgendaCarro(5, pessoaDAO.getP5(), carroPessoaDAO.getCp3(), Date.valueOf("2020-01-08"), Time.valueOf("14:30:00"), 
			Time.valueOf("18:00:00"), 1);
	
	private AgendaCarro a6 = new AgendaCarro(6, pessoaDAO.getP4(), carroPessoaDAO.getCp1(), Date.valueOf("2020-01-08"), Time.valueOf("15:00:00"), 
			Time.valueOf("17:30:00"), 1);
	
	public List<AgendaCarro> listarAgendamentos() throws Exception {
		List<AgendaCarro> listaAgendamento = new ArrayList<>();
		
		//simula lista de agendamentos 
		
		//lista todos os agendamentos existentes
		listaAgendamento.add(a1);	       
		listaAgendamento.add(a2);
        listaAgendamento.add(a3);
        listaAgendamento.add(a4);
        listaAgendamento.add(a5);
        listaAgendamento.add(a6);
		
		return listaAgendamento;
		
	}
	
	//lista apenas os agendamentos do carro recebido por parametro
	public List<AgendaCarro> listarAgendamentosPorCarro(Carro carro) throws Exception {
		//lista geral simulando busca no banco de dados
		List<AgendaCarro> listaGeral = listarAgendamentos();
		
		List<AgendaCarro> listaPorCarro = new ArrayList<>();
		
		
		//simula lista de agendamentos 
		for (AgendaCarro a : listaGeral){
			//se o agendamento do indice for para o carro pesquisado, adiciona
			if (a.getCarroLocado().getCarro().getId() == carro.getId()){
				listaPorCarro.add(a);
			}
		}
		
		return listaPorCarro;
		
	}
	
	public AgendaCarro buscarAgendamentoPorId(int idAgendamento) throws Exception{
		List<AgendaCarro> lista = new ArrayList<>();
		AgendaCarro agendamento = null;
		
		lista = listarAgendamentos();
		
		//faz uma busca simples nos objetos criados em memória
		for (AgendaCarro a: lista){
			if (a.getId() == idAgendamento) {
				agendamento = a;
			}
		}
		
		return agendamento;
	}
	
	public int addAgendamento(AgendaCarro agendamento) throws Exception{
		
		int idGerado = 0;
		Random gerador = new Random();
		
		System.out.println("Inserindo agendamento: Locatario:" + agendamento.getPessoaLocatario() + " Carro: " + agendamento.getCarroLocado() + 
				" Data: " + agendamento.getData()  + " Hora ini: " + agendamento.getHora_ini() + " Hora fim: " + agendamento.getHora_fim());
		
		//gera int randomico para simular id inserido.
		idGerado = gerador.nextInt();				
		
		return idGerado; 
		
	}
	
	public void editAgendamento(AgendaCarro agendamento, int id) throws Exception{
		System.out.println("Editando agendamento: id:" + id + "Locatario:" + agendamento.getPessoaLocatario() + " Carro: " + agendamento.getCarroLocado() + 
				" Data: " + agendamento.getData()  + " Hora ini: " + agendamento.getHora_ini() + " Hora fim: " + agendamento.getHora_fim());
	}
	
	public void editStatusAgendamento(AgendaCarro agendamento, int id, int status) throws Exception{
		agendamento.setStatus(status);
		
		System.out.println("Editando o status do agendamento: id:" + id + "Locatario:" + agendamento.getPessoaLocatario() + " Carro: " + agendamento.getCarroLocado() + 
				" Data: " + agendamento.getData()  + " Hora ini: " + agendamento.getHora_ini() + " Hora fim: " + agendamento.getHora_fim() + 
				" Novo Status" + agendamento.getStatus());
		
		/*Considere o seguinte cenário: imagine que dois clientes
		fizeram dois bookings que conflitam em horários para um dono de carro. Ele
		aceita os dois. Como os horários conflitam, o primeiro cliente que pagar o
		booking deve ter prioridade, ou seja, o outro booking deveria ser cancelado.*/
		
		
		//caso o status do agendamento seja pago, deve procurar os demais agendamentos para mesma data e hora e cancelá-los
		if (agendamento.getStatus() == 2) {
			List<AgendaCarro> lista = new ArrayList<AgendaCarro>();
			
			lista = listarAgendamentosPorCarro(agendamento.getCarroLocado().getCarro());
			
			//percorre a lista verificando o status e cancelando o agendamento
			for (AgendaCarro a : lista){
				if ((a.getStatus() != 2) && (a.getStatus() != 3)){
					a.setStatus(3);
				}
			}	
		}
		
	}
	
	public void deleteAgendamento(int id) throws Exception{
		System.out.println("Deletando agendamento: id:" + id);
	}

	public AgendaCarro getA1() {
		return a1;
	}

	public void setA1(AgendaCarro a1) {
		this.a1 = a1;
	}

	public AgendaCarro getA2() {
		return a2;
	}

	public void setA2(AgendaCarro a2) {
		this.a2 = a2;
	}

	public AgendaCarro getA3() {
		return a3;
	}

	public void setA3(AgendaCarro a3) {
		this.a3 = a3;
	}

	public AgendaCarro getA4() {
		return a4;
	}

	public void setA4(AgendaCarro a4) {
		this.a4 = a4;
	}

	public AgendaCarro getA5() {
		return a5;
	}

	public void setA5(AgendaCarro a5) {
		this.a5 = a5;
	}

	public AgendaCarro getA6() {
		return a6;
	}

	public void setA6(AgendaCarro a6) {
		this.a6 = a6;
	}
	

}
