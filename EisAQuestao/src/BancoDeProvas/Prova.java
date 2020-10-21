package BancoDeProvas;

import java.io.Serializable;
import java.util.ArrayList;

public class Prova implements Serializable{

    private Professor professor;
    private Disciplina disciplina;
    private String assunto;
    private ArrayList<Questao> questoes;

    public Prova(Professor professor, Disciplina disciplina, String assunto, ArrayList<Questao> questoes){
        this.professor = professor;
        this.disciplina = disciplina;
        this.assunto = assunto;
        this.questoes = questoes;
    }

    public Professor getProfessor() {
        return professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public String getAssunto() {
        return assunto;
    }

    public ArrayList<Questao> getQuestoes() {
        return questoes;
    }
}
