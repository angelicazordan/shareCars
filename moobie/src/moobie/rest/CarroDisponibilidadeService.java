package moobie.rest;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import moobie.dao.CarroDisponibilidadeDAO;
import moobie.entidade.Carro;
import moobie.entidade.CarroDisponibilidade;;

@Path("/disponibilidade")
public class CarroDisponibilidadeService {
	
	private CarroDisponibilidadeDAO carroDisponibilidadeDAO;
	
	@PostConstruct
	private void init(){
		carroDisponibilidadeDAO = new CarroDisponibilidadeDAO();
	}
	
	@GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CarroDisponibilidade> listarAgendamentos(Carro carro) {
        List<CarroDisponibilidade> lista = null;
        try {
            lista = carroDisponibilidadeDAO.listarDisponibilidadePorCarro(carro);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
     
     
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addDisponibilidade(CarroDisponibilidade disponibilidade) {
        String msg = "";
 
        System.out.println("Adicionando disponibilidade para o carro :" + disponibilidade.getCarro().getId());
 
        try {
        	
        	int idGerado = carroDisponibilidadeDAO.addDisponibilidade(disponibilidade);
 
            msg = String.valueOf(idGerado);
        } catch (Exception e) {
            msg = "Erro ao adicionar disponibilidade!";
            e.printStackTrace();
        }
 
        return msg;
    }
     
    @GET
    @Path("/get/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public CarroDisponibilidade buscarDisponibilidade(CarroDisponibilidade disponibilidade) {
    	CarroDisponibilidade carroDisponibilidade = null;
        try {
        	carroDisponibilidade = carroDisponibilidadeDAO.buscarDisponibilidadePorDataHora(disponibilidade.getCarro(), disponibilidade.getData(), 
        			disponibilidade.getHora_ini(), disponibilidade.getHora_fim());
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return carroDisponibilidade;
    }
 
    @PUT
    @Path("/edit/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String editarDisponibilidade(CarroDisponibilidade disponibilidade, @PathParam("id") int idDisponibilidade) {
        String msg = "";
         
        System.out.println("Editando disponibilidade do carro :" + disponibilidade.getCarro().getId());
         
        try {
        	carroDisponibilidadeDAO.editDisponibilidade(disponibilidade, idDisponibilidade);
             
            msg = "Disponibilidade editada com sucesso!";
        } catch (Exception e) {
            msg = "Erro ao editar disponibilidade!";
            e.printStackTrace();
        }
         
        return msg;
    }
    
     
    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String removerDisponibilidade(@PathParam("id") int idDisponibilidade) {
        String msg = "";
         
        try {
        	carroDisponibilidadeDAO.deleteDisponibilidade(idDisponibilidade);
             
            msg = "Disponibilidade removida com sucesso!";
        } catch (Exception e) {
            msg = "Erro ao remover disponibilidade!";
	            e.printStackTrace();
	        }
	         
	        return msg;
	    }

}



