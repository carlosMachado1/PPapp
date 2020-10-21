package BancoDeProvas;

import java.io.Serializable;

public class Professor extends Pessoa implements Serializable {
    private String matricula;

    public Professor(){
        super();
        this.matricula = "matricula";
    }

    @Override
    public String getNome() {
        return super.nome;
    }

    @Override
    public void setNome(String nome) {
        super.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
