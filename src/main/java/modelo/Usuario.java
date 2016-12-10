package modelo;

import java.time.LocalDate;

public class Usuario {
	
	private LocalDate aniversario;
	private String cpf;
	private String email;
	private String senha;
	private String nome;
	
	public LocalDate getAniversario() {
		return aniversario;
	}
	public void setAniversario(LocalDate aniversario) {
		this.aniversario = aniversario;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
