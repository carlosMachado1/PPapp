package classes;

import java.io.Serializable;

public abstract class Pessoa implements Serializable{
	public String nome;

	public Pessoa() {
		this.nome = "nome";
	}

	public abstract void setNome(String nome);

	public abstract String getNome();
}
