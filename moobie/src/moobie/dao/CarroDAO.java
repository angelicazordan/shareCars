package moobie.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import moobie.entidade.Carro;

public class CarroDAO {
	
	/*classe simulando conexao de dados*/
	
	private Carro c1 = new Carro(1, "Renault", "Sandero", 2015, "Passeio");
	private Carro c2 = new Carro(2, "Fiat", "Strada", 2018, "Utilitário");
	private Carro c3 = new Carro(3, "Volkswagen", "Polo", 2019, "Passeio");
	
	public List<Carro> listarCarros() throws Exception {
        List<Carro> lista = new ArrayList<>();
               
        lista.add(c1);
        lista.add(c2);
        lista.add(c3);
        
        return lista;
    }
	
	public int addCarro(Carro carro) throws Exception{
		int idGerado = 0;
		Random gerador = new Random();
		
		System.out.println("Inserindo carro: " + carro.getMarca() + " Modelo: " + carro.getModelo() + " Ano: " + carro.getAno() + 
				" Categoria: " + carro.getCategoria());
		
		//gera int randomico para simular id inserido.
		idGerado = gerador.nextInt();				
		
		return idGerado; 
	}
	
	public void editCarro(Carro carro) throws Exception{
		
		System.out.println("Editando carro: " + carro.getMarca() + " Modelo: " + carro.getModelo() + " Ano: " + carro.getAno() + 
				" Categoria: " + carro.getCategoria());
 
	}
	
	public void deleteCarro(Carro carro) throws Exception{
		
		System.out.println("Deletando carro: " + carro.getMarca() + " Modelo: " + carro.getModelo() + " Ano: " + carro.getAno() + 
				" Categoria: " + carro.getCategoria());

	}

	public Carro getC1() {
		return c1;
	}

	public void setC1(Carro c1) {
		this.c1 = c1;
	}

	public Carro getC2() {
		return c2;
	}

	public void setC2(Carro c2) {
		this.c2 = c2;
	}

	public Carro getC3() {
		return c3;
	}

	public void setC3(Carro c3) {
		this.c3 = c3;
	}
	
	

}
