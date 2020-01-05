package moobie.entidade;

public class CarroPessoa {
	
	private Carro carro;
	private Pessoa pessoa;
	
	public CarroPessoa(Carro carro, Pessoa pessoa){
		this.carro = carro;
		this.pessoa = pessoa;
	}
	
	public Carro getCarro() {
		return carro;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}


}
