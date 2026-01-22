import RegraPetShop.Agendamento;

import java.util.ArrayList;
import java.util.Scanner;

public class Petshop {
        private Scanner input = new Scanner(System.in);
        private ArrayList<Agendamento> agenda = new ArrayList<>();

    public static void main(String[] args) {
        Petshop pet = new Petshop();
        pet.exibirMenu();
    }


    public void exibirMenu() {
        int opcao = 0;

        do {
            for(int i = 0; i < 3; i++) System.out.println();

            System.out.println("#################################################");
            System.out.println("#            NENO BOLACHÃO DA BISLAU            #");
            System.out.println("#              SERVIÇOS DE PETSHOP              #");
            System.out.println("#################################################");
          //  System.out.printf("* TOTAL AGENDADO: %-17d*\n"                       );
            System.out.println("*===============================================*");
            System.out.println("* MENU PRINCIPAL:                               *");
            System.out.println("*-----------------------------------------------*");
            System.out.println("* [1]  (+) NOVO AGENDAMENTO                     *");
            System.out.println("* [2]  (=) IMPRIMIR COMPROVANTE (Por ID)        *");
            System.out.println("* [3]  (?) CONSULTAR AGENDA GERAL               *");
            System.out.println("* [4]  (*) EDITAR AGENDAMENTO                   *");
            System.out.println("* [5]  (X) SAIR DO SISTEMA                      *");
            System.out.println("*===============================================*");
            System.out.print("  *>>> Digite o número da opção: ");

            //Validação contra letras
            if (input.hasNextInt()) {
                opcao = input.nextInt();
                input.nextLine();
            } else {
                input.nextLine();
                opcao = 0;
            }


            switch (opcao) {
                case 1 -> novoAgendamento();
                case 2 -> imprimirComprovante();
                case 3 -> consultarAgenda();
                case 5 -> System.out.println("Fechando o PetShop... Até amanhã!");
                default -> System.out.println(">>> Opção inválida! Tente Novamente.");
            }

        } while (opcao != 5);
        input.close();
    }



    public void novoAgendamento() {
        System.out.println("\n--- NOVO AGENDAMENTO ---");

        System.out.print("Nome do Tutor: ");
        String tutor = input.nextLine();

        System.out.print("Nome do Pet: ");
        String petEst = input.nextLine();


        System.out.print("Idade do Pet: ");
        String idade = "";

        if (input.hasNextInt()) {
            int valorIdade = input.nextInt();
            input.nextLine();
            idade = String.valueOf(valorIdade);
        } else {
            input.nextLine();
        }

        Agendamento novoAgendamento = new Agendamento(tutor, petEst, idade);
        agenda.add(novoAgendamento);

        System.out.print("Agendando");
        try {
            for (int i = 0; i< 3; i++ ) {
                System.out.print(".");
                Thread.sleep (500);
            }
        } catch (InterruptedException e) {
            System.out.println("Error no timer");
        }

        System.out.println("\n\nAgendamento realizado com Sucesso! 🤘");

        int idNovo = agenda.size() -1;
        novoAgendamento.exibirComprovante(idNovo);

        System.out.println("Pressione ENTER para voltar ao menu...");
        input.nextLine();
    }




    //IMPRIMIR COMPROVANTE
    public void imprimirComprovante() {
        if(agenda.isEmpty()) {
            System.out.println("\n A agenda está vázia!");
            return;
        }

        System.out.print("\nDigite o ID do agendamento para imprimir: ");
        if(input.hasNextInt()) {
            int id = input.nextInt();
            input.nextLine();

            if(id >= 0 && id < agenda.size()) {
                agenda.get(id).exibirComprovante(id);
            } else {
                System.out.println(">>> Erro: ID não encontrado!");
            }
        } else {
            input.nextLine();
            System.out.println(">>> Digite um número válido.");
        }
        System.out.println("\nPressione ENTER para voltar...");
        input.nextLine();
    }


    public void consultarAgenda() {
        System.out.println("\n--- AGENDA COMPLETA ---");
        if(agenda.isEmpty()) {
            System.out.println("Nenhum cliente agendado.");
        } else {
            for (int i = 0; i < agenda.size(); i++) {
                Agendamento a = agenda.get(i);
                System.out.printf("ID [%d] - | TUTOR: %s | NOME PET: %s | IDADE: %s Anos\n",
                        i,
                        a.getTutor() ,
                        a.getPetEst(),
                        a.getIdade());
            }
        }
        System.out.println("\nPressione ENTER para voltar...");
        input.nextLine();
    }




}





 //Aqui fecha a classe Petshop
