package moobie.entidade;

import java.sql.Date;
import java.sql.Time;

public class CarroDisponibilidade {
	
	private int id;
	private Carro carro;
	private Date data;
	private Time hora_ini;
	private Time hora_fim;
	
	public CarroDisponibilidade(Carro carro, Date data, Time hora_ini, Time hora_fim){		
		setCarro(carro);
		setData(data);
		setHora_ini(hora_ini);
		setHora_fim(hora_fim);
	}
	
	public int getId(){
		return id;
	}
	
	public Carro getCarro() {
		return carro;
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
	
	public void setId(int id){
		this.id = id;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
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
	
	
	

}
