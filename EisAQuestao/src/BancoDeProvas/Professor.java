package BancoDeProvas;

import java.util.ArrayList;

public class Professor {
    private String nome;
    private String matricula;

    public Professor(){
        this.nome = "nome";
        this.matricula = "matricula";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
