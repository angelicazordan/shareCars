package moobie.dao;

import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import moobie.entidade.Pessoa;

public class PessoaDAO {
	
	/*classe simulando conexao de dados*/
	
	//Pessoa 1 e 2 possuem propriedade de veiculos  
	private Pessoa p1 = new Pessoa(1, "Maria", Date.valueOf("1987-12-01"), "985321475", "96523478555", "123456789");
	private Pessoa p2 = new Pessoa(2, "João", Date.valueOf("1990-03-23"), "655423368", "12548963258", "987654321");
	
	//Pessoa 3, 4 e 5 sao locadores
	private Pessoa p3 = new Pessoa(3, "Pedro", Date.valueOf("1972-10-05"), "100258544", "99985632447", "32165498");
	private Pessoa p4 = new Pessoa(4, "José", Date.valueOf("1999-08-25"), "96582348", "66892514756", "232326556");
	private Pessoa p5 = new Pessoa(5, "Joana", Date.valueOf("1992-07-30"), "235478111", "63254187425", "98986565656");
	
	public List<Pessoa> listarPessoas() throws Exception {
        List<Pessoa> lista = new ArrayList<>();
                
        lista.add(p1);               
        lista.add(p2);               
        lista.add(p3);
        
        return lista;
    }
	
	public int addPessoa(Pessoa pessoa) throws Exception{
		int idGerado = 0;
		Random gerador = new Random();
		
		System.out.println("Inserindo pessoa: " + pessoa.getNome() + " Data Nascto: " + pessoa.getData_nscto() + " RG: " + pessoa.getRg() + 
				" CPF: " + pessoa.getCpf() + " CNH: " + pessoa.getNro_cnh());
		
		//gera int randomico para simular id inserido.
		idGerado = gerador.nextInt();				
		
		return idGerado; 
	}
	
	public void editPessoa(Pessoa pessoa) throws Exception{
		
		System.out.println("Editando pessoa: " + pessoa.getNome() + " Data Nascto: " + pessoa.getData_nscto() + " RG: " + pessoa.getRg() + 
			" CPF: " + pessoa.getCpf() + " CNH: " + pessoa.getNro_cnh());
 
	}
	
	public void deletePessoa(Pessoa pessoa) throws Exception{
		
		System.out.println("Deletando carro: " + pessoa.getNome() + " Data Nascto: " + pessoa.getData_nscto() + " RG: " + pessoa.getRg() + 
				" CPF: " + pessoa.getCpf() + " CNH: " + pessoa.getNro_cnh());

	}

	public Pessoa getP1() {
		return p1;
	}

	public void setP1(Pessoa p1) {
		this.p1 = p1;
	}

	public Pessoa getP2() {
		return p2;
	}

	public void setP2(Pessoa p2) {
		this.p2 = p2;
	}

	public Pessoa getP3() {
		return p3;
	}

	public void setP3(Pessoa p3) {
		this.p3 = p3;
	}

	public Pessoa getP4() {
		return p4;
	}

	public void setP4(Pessoa p4) {
		this.p4 = p4;
	}

	public Pessoa getP5() {
		return p5;
	}

	public void setP5(Pessoa p5) {
		this.p5 = p5;
	}
	
	

}
