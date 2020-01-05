package moobie.entidade;

import java.sql.Date;
import java.sql.Time;

public class AgendaCarro {
	
	private int id;
	private Pessoa pessoaLocatario;
	private CarroPessoa carroLocado;	
	private Date data;
	private Time hora_ini;
	private Time hora_fim;
	private int status;
	
	public AgendaCarro(int id, Pessoa pessoaLocatario, CarroPessoa carroLocado, Date data, Time hora_ini, Time hora_fim, int status){
		setId(id);
		setPessoaLocatario(pessoaLocatario);
		setCarroLocado(carroLocado);
		setData(data);
		setHora_ini(hora_ini);
		setHora_fim(hora_fim);
		setStatus(status);
	}
	
	public int getId() {
		return id;
	}
	
	public Pessoa getPessoaLocatario() {
		return pessoaLocatario;
	}
	
	public CarroPessoa getCarroLocado() {
		return carroLocado;
	}
	
	public Date getData() {
		return data;
	}
	
	public Time getHora_ini() {
		return hora_ini;
	}
	
	public Time getHora_fim() {
		return hora_fim;
	}
	
	public int getStatus() {
		return status;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPessoaLocatario(Pessoa pessoaLocatario) {
		this.pessoaLocatario = pessoaLocatario;
	}

	public void setCarroLocado(CarroPessoa carroLocado) {
		this.carroLocado = carroLocado;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public void setHora_ini(Time hora_ini) {
		this.hora_ini = hora_ini;
	}

	public void setHora_fim(Time hora_fim) {
		this.hora_fim = hora_fim;
	}

	public void setStatus(int status) {
		/*
		 *Status dos agendamentos
		 *0 = solicitado pelo cliente
		 *1 = aceito pelo proprietário do carro
		 *2 = pago pelo cliente
		 *3 = cancelado
		 **/
		
		this.status = status;
	}
	
	
		

}
