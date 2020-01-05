package moobie.entidade;

import java.sql.Date;

public class Pessoa {
	
	private int id;
	private String nome;
	private Date data_nscto;
	private String rg;
	private String cpf;
	private String nro_cnh;

	
	public Pessoa(Integer id, String nome, Date data_nscto, String rg, String cpf, String nro_cnh){
		setId(id);
		setNome(nome);
		setData_nscto(data_nscto);
		setRg(rg);
		setCpf(cpf);
		setNro_cnh(nro_cnh);
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Date getData_nscto() {
		return data_nscto;
	}
	
	public String getRg() {
		return rg;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getNro_cnh() {
		return nro_cnh;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setData_nscto(Date data_nscto) {
		this.data_nscto = data_nscto;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setNro_cnh(String nro_cnh) {
		this.nro_cnh = nro_cnh;
	}
	
	
	
	
	

}
