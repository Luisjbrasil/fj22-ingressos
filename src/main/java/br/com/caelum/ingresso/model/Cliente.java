package br.com.caelum.ingresso.model;

public class Cliente {
	
	private String nome;
	
	private String cpf;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public boolean nomeValido() {
		
		return this.nome.length() > 2 ? true: false;	
		
	}
	

}
