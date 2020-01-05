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

import moobie.dao.AgendaCarroDAO;
import moobie.entidade.AgendaCarro;
import moobie.entidade.CarroDisponibilidade;

@Path("/agenda")
public class AgendaCarroService {
	
	private AgendaCarroDAO agendaCarroDAO;
	private CarroDisponibilidadeService carroDisponibilidadeService;
	
	@PostConstruct
	private void init(){
		agendaCarroDAO = new AgendaCarroDAO();
		carroDisponibilidadeService = new CarroDisponibilidadeService();
	}
	
	@GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AgendaCarro> listarAgendamentos() {
        List<AgendaCarro> lista = null;
        try {
            lista = agendaCarroDAO.listarAgendamentos();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
     
     
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addAgendamento(AgendaCarro agendamento) {
        String msg = "";
        int idGerado = 0;
 
        System.out.println("Agendando o carro :" + agendamento.getCarroLocado().getCarro().getId() +
        		"para a pessoa :" + agendamento.getPessoaLocatario().getId());
 
        try {
        	//Não deve ser possível agendar um carro em uma data não disponível
        	
            CarroDisponibilidade disponibilidade = new CarroDisponibilidade(agendamento.getCarroLocado().getCarro(), agendamento.getData(),
            		agendamento.getHora_ini(), agendamento.getHora_fim());
            
        	//adiciona o agendamento apenas se existir uma disponibilidade válida
            if (!(carroDisponibilidadeService.buscarDisponibilidade(disponibilidade) == null)){
        		idGerado = agendaCarroDAO.addAgendamento(agendamento);
        		msg = "Agendamento adicionado com sucesso!";
        	}else {
        		msg = "Não é possível adicionar o agendamento, carro indisponível.";
        	}
        	
        	
 
            msg = String.valueOf(idGerado);
        } catch (Exception e) {
            msg = "Erro ao adicionar agendamento!";
            e.printStackTrace();
        }
 
        return msg;
    }
     
    @GET
    @Path("/get/{id}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public AgendaCarro buscarPorId(@PathParam("id") int idAgendamento) {
        AgendaCarro agendamento = null;
        try {
        	agendamento = agendaCarroDAO.buscarAgendamentoPorId(idAgendamento);
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return agendamento;
    }
 
    @PUT
    @Path("/edit/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String editarAgendamento(AgendaCarro agendamento, @PathParam("id") int idAgendamento) {
        String msg = "";
         
        System.out.println("Agendando o carro :" + agendamento.getCarroLocado().getCarro().getId() +
        		"para a pessoa :" + agendamento.getPessoaLocatario().getId());
         
        try {
            agendaCarroDAO.editAgendamento(agendamento, idAgendamento);
             
            msg = "Agendamento editado com sucesso!";
        } catch (Exception e) {
            msg = "Erro ao editar o agendamento!";
            e.printStackTrace();
        }
         
        return msg;
    }
    
    @PUT
    @Path("/changestatus/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String editarStatusAgendamento(AgendaCarro agendamento, @PathParam("id") int idAgendamento) {
        String msg = "";
         
        System.out.println("Alterando o Status do agendamento do carro :" + agendamento.getCarroLocado().getCarro().getId() +
        		"para a pessoa :" + agendamento.getPessoaLocatario().getId());
         
        try {
            agendaCarroDAO.editStatusAgendamento(agendamento, idAgendamento, agendamento.getStatus());
             
            msg = "Status do agendamento editado com sucesso!";
        } catch (Exception e) {
            msg = "Erro ao editar o Status do agendamento!";
            e.printStackTrace();
        }
         
        return msg;
    }
     
    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String removerNota(@PathParam("id") int idAgendamento) {
        String msg = "";
         
        try {
        	agendaCarroDAO.deleteAgendamento(idAgendamento);;
             
            msg = "Agendamento removido com sucesso!";
        } catch (Exception e) {
            msg = "Erro ao remover o agendamento!";
            e.printStackTrace();
        }
         
        return msg;
    }

}
