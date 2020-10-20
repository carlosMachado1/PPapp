package BancoDeProvas;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CriarProva{
    private ArrayList<Questao> questoes;
    private String assunto;

    public Prova criarProva(){
        System.out.println("\n|Criar Prova|\n");

        Professor professor = this.setProfessor();
        Disciplina disciplina = this.setDisciplina();
        this.setQuestoes();

        return new Prova(professor, disciplina, this.assunto, this.questoes);
    }

    public void setQuestoes(){
        this.setAssunto();
        System.out.println();
        int numQuestoes = this.setNumQuestoes();
        System.out.println();

        Scanner input = new Scanner(System.in);
        this.questoes = new ArrayList<>();

        for(int i = 0; i < numQuestoes; i++){
            Questao questao = new Questao();

            System.out.println("Digite o enunciado da questão "+ (i + 1) +": ");
            questao.setTituloQuestao(input.nextLine());

            System.out.println("Alternativa A: ");
            questao.setAlternativaA(input.nextLine());
            System.out.println("Alternativa B: ");
            questao.setAlternativaB(input.nextLine());
            System.out.println("Alternativa C: ");
            questao.setAlternativaC(input.nextLine());
            System.out.println("Alternativa D: ");
            questao.setAlternativaD(input.nextLine());
            System.out.println("Alternativa E: ");
            questao.setAlternativaE(input.nextLine());

            boolean isValid = false;

            while(!isValid){
                System.out.println("Identifique a alternativa correta: ");
                String op = input.nextLine();

                switch(op){
                    case "A": case "a":
                        questao.setAlternativaCorreta("A");
                        isValid = true;
                        break;
                    case "B": case "b":
                        questao.setAlternativaCorreta("B");
                        isValid = true;
                        break;
                    case "C": case "c":
                        questao.setAlternativaCorreta("C");
                        isValid = true;
                        break;
                    case "D": case "d":
                        questao.setAlternativaCorreta("D");
                        isValid = true;
                        break;
                    case "E": case "e":
                        questao.setAlternativaCorreta("E");
                        isValid = true;
                        break;
                    default:
                        System.out.println("Você deve digitar uma letra entre A e E!");
                        break;
                }
            }

            this.questoes.add(questao);

            System.out.println();
        }
    }

    public void setAssunto(){
        Scanner input = new Scanner(System.in);

        System.out.println("Qual o assunto da prova? ");
        this.assunto = input.nextLine();
    }

    public int setNumQuestoes(){
        int numQuestoes;

        Scanner input = new Scanner(System.in);

        try{
            System.out.println("Digite o número de questões da prova: ");
            numQuestoes = input.nextInt();

            if(numQuestoes <= 0){
                System.out.println("Entrada inválida!");
                input.nextLine();
                numQuestoes = this.setNumQuestoes();
            }

        }catch (InputMismatchException ex){
            System.out.println("Digite um valor inteiro!");
            System.out.println();
            input.nextLine();
            numQuestoes = this.setNumQuestoes();
        }
        return numQuestoes;
    }

    public Professor setProfessor() {
        Scanner input = new Scanner(System.in);
        Professor prof = new Professor();

        System.out.println("Nome do professor: ");
        prof.setNome(input.nextLine());

        System.out.println("\nMatrícula: ");
        prof.setMatricula(input.nextLine());
        System.out.println("");

        return prof;
    }

    public Disciplina setDisciplina() {
        Scanner input = new Scanner(System.in);
        Disciplina disc = new Disciplina();

        System.out.println("Nome da disciplina: ");
        disc.setNomeDisciplina(input.nextLine());
        System.out.println("");

        return disc;
    }
}
