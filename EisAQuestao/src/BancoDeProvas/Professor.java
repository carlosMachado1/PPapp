package BancoDeProvas;

import java.io.Serializable;
import java.util.ArrayList;

public class Professor extends Pessoa implements Serializable {
    private String matricula;

    public Professor(){
        super();
        this.nome = "nome";
        this.matricula = "matricula";
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
