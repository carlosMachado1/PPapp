package BancoDeProvas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean continuar = true;

        while(continuar){
            System.out.println("");

            int op = 0;

            System.out.println("Digite o número da opção escolhida: ");
            System.out.println("1 : Criar Prova");
            System.out.println("2 : Consultar Prova");
            System.out.println("3 : Sair");
            try{
                op = input.nextInt();
            }catch(InputMismatchException ex){
                System.out.println("Opção digitada é inválida!");
                input.nextLine();
                continue;
            }

            switch(op){
                case 1:
                    System.out.println("Opção Criar Prova");
                    break;
                case 2:
                    System.out.println("Opção Consultar Provas!");
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção digitada é inválida!");
            }
        }
    }
}
