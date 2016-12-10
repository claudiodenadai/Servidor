package util;

import modelo.Usuario;

public class Validacao {

	public boolean validarLogin(Usuario usuario) {
		if (ListaUsuario.usuarios.stream().anyMatch(u -> u.getEmail().equals(usuario.getEmail()))
				&& ListaUsuario.usuarios.stream().anyMatch(u -> u.getSenha().equals(usuario.getSenha())))
			return true;
		return false;
	}

	public boolean validarCPF(Usuario usuario) {
		return ListaUsuario.usuarios.stream().anyMatch(u -> u.getCpf().equals(usuario.getCpf()));
	}

	public boolean validarEmail(Usuario usuario) {
		return ListaUsuario.usuarios.stream().anyMatch(u -> u.getEmail().equals(usuario.getEmail()));
	}

}
