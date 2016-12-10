package service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

import modelo.Usuario;
import util.ListaUsuario;
import util.Validacao;

@ApplicationPath("/resource")
@Path("/usuario")
public class UsuarioControle extends Application {
	private Validacao validacao = new Validacao();

	@POST
	@Path("/inserirUsuario")
	@Consumes("application/json")
	public Response inserirUsuario(Usuario usuario) {
		System.out.println("CHAMOU ");
		try {
			if (!validacao.validarEmail(usuario)) {
				if (!validacao.validarCPF(usuario)) {
					ListaUsuario.usuarios.add(usuario);
					System.out.print("Lista "+ListaUsuario.usuarios.size());
					return Response.status(Response.Status.OK).entity(Response.Status.OK.toString()).build();
				} else {
					return Response.status(Response.Status.FOUND).encoding(Response.Status.FOUND.toString()).build();
				}
			} else {
				return Response.status(Response.Status.FOUND).encoding(Response.Status.FOUND.toString()).build();
			}
		} catch (

		Exception e) {
			throw new WebApplicationException(500);
		}
	}

	@POST
	@Path("/acesso")
	@Consumes("application/json")
	public Response verificarUsuario(Usuario usuario) {
		System.out.println("Ok");
		if (validacao.validarLogin(usuario)) {
			return Response.status(Response.Status.OK).entity("{\"status\": true}").build();
		}
		return Response.status(Response.Status.UNAUTHORIZED).entity("{\"status\": false}").build();
	}

	@GET
	@Path("/buscarNome/{nome}")
	@Produces("application/json")
	public Response buscarPorNome(@PathParam("nome") String nome) {
		return Response.status(200).entity(new GenericEntity<List<Usuario>>(
				ListaUsuario.usuarios.stream().filter(u -> u.getNome().equals(nome)).collect(Collectors.toList())) {
		}).build();
	}

	@GET
	@Path("/buscarEmail/{email}")
	@Produces("application/json")
	public Response buscarEmail(@PathParam("email") String email) {
		return Response.status(200).entity(new GenericEntity<List<Usuario>>(
				ListaUsuario.usuarios.stream().filter(u -> u.getEmail().equals(email)).collect(Collectors.toList())) {
		}).build();
	}

	@GET
	@Path("/buscarCPF/{cpf}")
	@Produces("application/json")
	public Response buscarCPF(@PathParam("cpf") String cpf) {

		return Response.status(200).entity(new GenericEntity<List<Usuario>>(
				ListaUsuario.usuarios.stream().filter(u -> u.getCpf().equals(cpf)).collect(Collectors.toList())) {
		}).build();
	}

	@GET
	@Path("/buscar")
	@Produces("application/json")
	public Response buscar() {
		return Response.status(200).entity(new GenericEntity<List<Usuario>>(ListaUsuario.usuarios) {
		}).build();
	}

	@GET
	@Path("/buscarPorDataNascimento/{aniversario}")
	@Produces("application/json")
	public Response buscarPorDataNascimento(@PathParam("aniversario") LocalDate aniversario) {
		return Response.status(200).entity(ListaUsuario.usuarios.stream()
				.filter(u -> u.getAniversario().equals(aniversario)).collect(Collectors.toList())).build();
	}

}
