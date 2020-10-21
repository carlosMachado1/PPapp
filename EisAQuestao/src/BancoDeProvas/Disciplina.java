package BancoDeProvas;

import java.io.Serializable;
import java.util.ArrayList;

public class Disciplina implements Serializable {
    private String nomeDisciplina;

    public Disciplina() {
        this.nomeDisciplina = "nomeDisciplina";
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
}
