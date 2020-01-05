package moobie.entidade;

public class Carro {
	
	private int id;
	private String marca;
	private String modelo;
	private Integer ano;
	private String categoria;
	
	public Carro(Integer id, String marca, String modelo, Integer ano, String categoria){
		setId(id);
		setMarca(marca);
		setModelo(modelo);
		setAno(ano);
		setCategoria(categoria);
	}
	
	public Integer getId() {
		return id;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public Integer getAno() {
		return ano;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
		

}
