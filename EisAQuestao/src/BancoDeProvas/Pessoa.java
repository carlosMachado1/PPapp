package classes;

public abstract class Pessoa {
	public String nome;
	private String cpf;
	private String nascimento;

	public Pessoa() {
		this.nome = "nome";
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}
}
