package BancoDeProvas;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean continuar = true;

        ConsultarProva consulProvas = new ConsultarProva();

        while(continuar){
            System.out.println("| Início |\n");
            System.out.println("Digite o número da opção escolhida: ");
            System.out.println("1 : Criar Prova");
            System.out.println("2 : Consultar Prova");
            System.out.println("3 : Sair");

            String op = input.nextLine();


            switch(op){
                case "1":
                    CriarProva prova = new CriarProva();
                    consulProvas.adicionarProva(prova.criarProva());
                    break;
                case "2":
                    consulProvas.consulta();
                    break;
                case "3":
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção digitada é inválida!");
            }
        }
    }
}
