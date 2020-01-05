package moobie.dao;

import moobie.entidade.CarroPessoa;

public class CarroPessoaDAO {
	
	private CarroDAO carroDAO = new CarroDAO();
	private PessoaDAO pessoaDAO = new PessoaDAO();
	
	/*classe simulando conexao de dados
	 * 
	 * simulando o vínculo das pessoas com os carros
	 * para definir a propriedade de cada carro
	 * 
	 */
	
	private CarroPessoa cp1 = new CarroPessoa(carroDAO.getC1(), pessoaDAO.getP1()); //carro 1 pertence a pessoa 1
	private CarroPessoa cp2 = new CarroPessoa(carroDAO.getC2(), pessoaDAO.getP1()); //carro 2 pertence a pessoa 1
	private CarroPessoa cp3 = new CarroPessoa(carroDAO.getC3(), pessoaDAO.getP2()); //carro 3 pertence a pessoa 2
	
	public CarroPessoa getCp1() {
		return cp1;
	}
	public void setCp1(CarroPessoa cp1) {
		this.cp1 = cp1;
	}
	public CarroPessoa getCp2() {
		return cp2;
	}
	public void setCp2(CarroPessoa cp2) {
		this.cp2 = cp2;
	}
	public CarroPessoa getCp3() {
		return cp3;
	}
	public void setCp3(CarroPessoa cp3) {
		this.cp3 = cp3;
	}
	
	

}
