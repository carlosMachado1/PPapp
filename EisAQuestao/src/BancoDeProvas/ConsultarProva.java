package BancoDeProvas;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsultarProva {
    private ArrayList<Prova> provas;
    private ArrayList<Prova> provasAchadas;

    public ConsultarProva(){
        this.provas = new ArrayList<>();

        if(isPresent()){
            this.desserializar();
        }
    }

    public void consulta(){
        System.out.println("\n|Consultar Prova|\n");

        boolean continuar = true;

        while(continuar){

            System.out.println("Digite o número da opção escolhida: ");
            System.out.println("1 : Pesquisar uma prova registrada: ");
            System.out.println("2 : Excluir uma prova: ");
            System.out.println("3 : Voltar");

            Scanner input = new Scanner(System.in);

            String op = input.nextLine();

            System.out.println();

            switch(op){
                case "1": case "2":
                    this.pesquisarProva(op);
                    break;
                case "3":
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção digitada é inválida!\n");
            }
        }
    }

    public void serializar(){

        Write w = new Write();

        try {
            w.serialize("/home/hsleik/Documents/Programação/Repositories/PPapp/ArquivosSerializados/provas", this.provas);
        } catch (Exception ex) {
            System.err.println("Falha ao serializar! - " + ex.toString());
        }
    }

    public void desserializar(){
        Read r = new Read();

        this.provas = null;

        try {
            this.provas = r.deserialize("/home/hsleik/Documents/Programação/Repositories/PPapp/ArquivosSerializados/provas");
        } catch (Exception ex) {
            System.err.println("Falha ao desserializar! - " + ex.toString());
        }
    }

    public boolean isPresent(){
        File f = new File("/home/hsleik/Documents/Programação/Repositories/PPapp/ArquivosSerializados/provas");
        return f.exists() && !f.isDirectory();
    }

    public void adicionarProva(Prova prova){
        if(isPresent()){
            this.desserializar();
        }

        this.provas.add(prova);

        this.serializar();
    }

    public void pesquisarProva(String op){
        Scanner input = new Scanner(System.in);

        System.out.println("Qual o nome do professor que redigiu a prova? ");
        String pesqProf = input.nextLine();
        System.out.println();

        System.out.println("Qual a disciplina da prova? ");
        String pesqDisc = input.nextLine();
        System.out.println();

        System.out.println("Qual o assunto da prova? ");
        String pesqAss = input.nextLine();
        System.out.println();

        this.provasAchadas = new ArrayList<>();

        boolean foiAchado = false;

        for (Prova prova : this.provas) {
            if (pesqAss.equals(prova.getAssunto()) && pesqDisc.equals(prova.getDisciplina().getNomeDisciplina())
                && pesqProf.equals(prova.getProfessor().getNome()))
            {
                foiAchado = true;
                this.provasAchadas.add(prova);
            }
        }

        if(foiAchado){
            if(op.equals("1")){
                this.mostrarProva();
            }else{
                this.removerProva();
            }
        }else{
            System.out.println("Nenhuma prova foi encontrada!\n");
        }

    }

    public void mostrarProva(){

        if(this.provasAchadas.size() == 1){
            System.out.println("Foi encontrada uma prova que está de acordo com essas informações!");
            System.out.println("Exibindo resultado:");
        }else{
            System.out.println("Foram encontradas "+ this.provasAchadas.size() +" provas que estão de acordo" +
                    " com essas informações!");
            System.out.println("Exibindo resultados:");
        }

        for(int i = 0; i < this.provasAchadas.size(); i++){

            System.out.println("\n");

            System.out.println("Prova " + (i + 1));
            System.out.println("Curso:______________| Aluno(a):___________________________");
            System.out.println("Disciplina: " + this.provasAchadas.get(i).getDisciplina().getNomeDisciplina());
            System.out.println("Matrícula:__________| Turma:___________| Data:____________ ");
            System.out.println("Professor(a): " + this.provasAchadas.get(i).getProfessor().getNome());
            System.out.println("Nota:____");

            for(int j = 0; j < this.provasAchadas.get(i).getQuestoes().size(); j++){
                System.out.println();
                System.out.println("Questão " + (j + 1) + ") " +
                                    this.provasAchadas.get(i).getQuestoes().get(j).getTituloQuestao());
                System.out.println("A) " + this.provasAchadas.get(i).getQuestoes().get(j).getAlternativaA());
                System.out.println("B) " + this.provasAchadas.get(i).getQuestoes().get(j).getAlternativaB());
                System.out.println("C) " + this.provasAchadas.get(i).getQuestoes().get(j).getAlternativaC());
                System.out.println("D) " + this.provasAchadas.get(i).getQuestoes().get(j).getAlternativaD());
                System.out.println("E) " + this.provasAchadas.get(i).getQuestoes().get(j).getAlternativaE());
            }
            System.out.println("\nAperte Enter para continuar!");
            Scanner input = new Scanner(System.in);
            input.nextLine();
        }

        this.provasAchadas.clear();
    }

    public void removerProva(){
        if(this.provasAchadas.size() == 1){
            System.out.println("Foi encontrada uma prova que está de acordo com essas informações!");

            System.out.println("Excluir? ");

            this.remocaoProva(0);
        }else{
            System.out.println("Foram encontradas "+ this.provasAchadas.size() +" provas que estão de acordo" +
                               " com essas informações!");

            for(int i = 0; i < this.provasAchadas.size(); i++){
                System.out.println("Excluir prova " + (i + 1) + "? ");
                this.remocaoProva(i);
            }
        }

        this.provasAchadas.clear();
    }

    public void remocaoProva(int i){
        Scanner input = new Scanner(System.in);

        boolean isValid = false;

        while (!isValid) {

            System.out.println("S/N");

            String op = input.nextLine();

            switch (op) {
                case "S": case "s": case "Sim": case "sim": case "SIM": case "Y": case "y": case "yes": case "Yes": case "YES":
                    this.provas.remove(this.provasAchadas.get(i));
                    isValid = true;
                    break;
                case "N": case "n": case "Não": case "Nao": case "não": case "nao": case "NÃO": case "NAO": case "No": case "no":
                    isValid = true;
                    break;
                default:
                    System.out.println("Opção digitada é inválida!");
            }
        }

        this.serializar();
        this.desserializar();

        System.out.println();
    }
}
