package BancoDeProvas;

import java.util.ArrayList;

public class Professor {
    private String nome;
    private String matricula;
    private ArrayList<Disciplina> disciplinas;

    public Professor(String nome, String matricula){
        this.nome = nome;
        this.matricula = matricula;
        disciplinas = new ArrayList<>();
    }

    public void adicionarDisciplina(Disciplina disciplina){
        if(!disciplinas.contains(disciplina)){
            disciplinas.add(disciplina);
        }else{
            System.out.println("Disciplina já adicionada!");
        }
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
